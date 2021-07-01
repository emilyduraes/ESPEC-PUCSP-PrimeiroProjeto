package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.domain.dto.LiveClassDto;
import br.edu.pucsp.virtualtrainer.domain.entity.LiveClassStudents;
import br.edu.pucsp.virtualtrainer.domain.request.AddStudentRequest;
import br.edu.pucsp.virtualtrainer.domain.request.LiveClassRequest;
import br.edu.pucsp.virtualtrainer.domain.request.api.ZoomMeetingRequest;
import br.edu.pucsp.virtualtrainer.exception.DataNotFoundException;
import br.edu.pucsp.virtualtrainer.mapper.LiveClassMapper;
import br.edu.pucsp.virtualtrainer.repository.*;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static br.edu.pucsp.virtualtrainer.domain.enums.MeetingType.SCHEDULED;

@Service
public class LiveClassServiceImpl implements LiveClassService {

    private static final LiveClassMapper MAPPER = Mappers.getMapper(LiveClassMapper.class);

    private final LiveClassRepository repository;

    private final LiveClassStudentsRepository liveClassStudentsRepository;

    private final TrainerRepository trainerRepository;

    private final FieldRepository fieldRepository;

    private final StudentRepository studentRepository;

    private final ZoomApiService zoomApiService;

    public LiveClassServiceImpl(LiveClassRepository repository, TrainerRepository trainerRepository,
            FieldRepository fieldRepository, ZoomApiService zoomApiService, StudentRepository studentRepository,
                                LiveClassStudentsRepository liveClassStudentsRepository) {
        this.repository = repository;
        this.trainerRepository = trainerRepository;
        this.fieldRepository = fieldRepository;
        this.zoomApiService = zoomApiService;
        this.studentRepository = studentRepository;
        this.liveClassStudentsRepository = liveClassStudentsRepository;
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

        //TODO criação apenas para o perfil de treinador, se ele não tiver um perfil pago, max de 40 min e 100 pessoas
        var response = zoomApiService.createMeeting(meetingRequest);

        var liveClass = MAPPER.createEntity(request, trainer, field, response);

        repository.save(liveClass);
    }

    @Override
    public LiveClassDto findLiveClass(Long id) {
        var liveClass = repository.findByIdWithDetails(id).orElseThrow(() -> new DataNotFoundException(id));
        return MAPPER.detailedClassData(liveClass);
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
        return repository.findAllWithDetails()
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
    public void addStudentToLiveClass(AddStudentRequest request) {
        var student = studentRepository.findById(request.getStudentId()).orElseThrow(() -> new DataNotFoundException(request.getStudentId()));
        var liveClass = repository.findById(request.getLiveClassId()).orElseThrow(() -> new DataNotFoundException(request.getLiveClassId()));

        var liveClassStudents = new LiveClassStudents(liveClass, student);
        liveClassStudentsRepository.save(liveClassStudents);
    }

}
