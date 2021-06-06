package br.edu.pucsp.virtualtrainer.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.pucsp.virtualtrainer.domain.request.api.ZoomMeetingRequest;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import br.edu.pucsp.virtualtrainer.exception.DataNotFoundException;
import br.edu.pucsp.virtualtrainer.mapper.LiveClassMapper;
import br.edu.pucsp.virtualtrainer.domain.dto.LiveClassDto;
import br.edu.pucsp.virtualtrainer.repository.FieldRepository;
import br.edu.pucsp.virtualtrainer.repository.LiveClassRepository;
import br.edu.pucsp.virtualtrainer.repository.TrainerRepository;
import br.edu.pucsp.virtualtrainer.domain.request.LiveClassRequest;

import static br.edu.pucsp.virtualtrainer.domain.enums.MeetingType.SCHEDULED;

@Service
public class LiveClassServiceImpl implements LiveClassService {

    private static final LiveClassMapper MAPPER = Mappers.getMapper(LiveClassMapper.class);

    LiveClassRepository repository;

    TrainerRepository trainerRepository;

    FieldRepository fieldRepository;

    ZoomApiService zoomApiService;

    public LiveClassServiceImpl(LiveClassRepository repository, TrainerRepository trainerRepository,
            FieldRepository fieldRepository, ZoomApiService zoomApiService) {
        this.repository = repository;
        this.trainerRepository = trainerRepository;
        this.fieldRepository = fieldRepository;
        this.zoomApiService = zoomApiService;
    }

    @Override
    public void createLiveClass(LiveClassRequest request) {
        var trainer = trainerRepository.findById(request.getTrainer()).orElseThrow(() -> new DataNotFoundException(request.getTrainer()));
        var field = fieldRepository.findById(request.getField()).orElseThrow(() -> new DataNotFoundException(request.getField()));

        var meetingRequest = new ZoomMeetingRequest.Builder()
                .withName(request.getTitle())
                .withDescription("Description")
                .byHost(request.getTrainer())
                .type(SCHEDULED)
                .at(request.getStartTime())
                .duration(request.getDuration())
                .withDefaultSettings()
                .build();

        //TODO criação apenas para o perfil de treinador
        var response = zoomApiService.createMeeting(meetingRequest);

        var liveClass = MAPPER.createEntity(request, trainer, field, response);

        repository.save(liveClass);
    }

    @Override
    public LiveClassDto findLiveClass(Long id) {
        var liveClass = repository.findById(id).orElseThrow(() -> new DataNotFoundException(id));
        return MAPPER.entityToDto(liveClass);
    }

    @Override
    public List<LiveClassDto> findLiveClasses(String title) {
        return repository.findByTitle(title)
                .orElseThrow(() -> new DataNotFoundException(title))
                .stream()
                .filter(dates -> dates.getStartTime().isAfter(LocalDateTime.now()))
                .map(MAPPER::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LiveClassDto> findAllFutureLiveClasses(){
        return repository.findAll()
                .stream()
                .filter(dates -> dates.getStartTime().isAfter(LocalDateTime.now()))
                .map(MAPPER::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteLiveClass(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        } else {
            throw new DataNotFoundException(id);
        }
    }

    @Override
    public void updateLiveClass(LiveClassRequest request) {
        var liveClass = repository.findById(request.getId()).orElseThrow(() -> new DataNotFoundException(request.getId()));
        liveClass.setTitle(request.getTitle());
        repository.save(liveClass);
    }

    @Override
    public void addStudentToLiveClass(Long id, Long studentId) {
        // TODO Auto-generated method stub
        
    }

}
