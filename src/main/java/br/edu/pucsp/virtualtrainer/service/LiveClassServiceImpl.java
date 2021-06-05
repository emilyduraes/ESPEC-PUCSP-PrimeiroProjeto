package br.edu.pucsp.virtualtrainer.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import br.edu.pucsp.virtualtrainer.exception.DataNotFoundException;
import br.edu.pucsp.virtualtrainer.mapper.LiveClassMapper;
import br.edu.pucsp.virtualtrainer.model.dto.LiveClassDto;
import br.edu.pucsp.virtualtrainer.model.entity.Field;
import br.edu.pucsp.virtualtrainer.model.entity.LiveClass;
import br.edu.pucsp.virtualtrainer.model.entity.Trainer;
import br.edu.pucsp.virtualtrainer.repository.FieldRepository;
import br.edu.pucsp.virtualtrainer.repository.LiveClassRepository;
import br.edu.pucsp.virtualtrainer.repository.TrainerRepository;
import br.edu.pucsp.virtualtrainer.transport.request.LiveClassRequest;

@Service
public class LiveClassServiceImpl implements LiveClassService {

    private static final LiveClassMapper MAPPER = Mappers.getMapper(LiveClassMapper.class);

    LiveClassRepository repository;

    TrainerRepository trainerRepository;

    FieldRepository fieldRepository;

    public LiveClassServiceImpl(LiveClassRepository repository, TrainerRepository trainerRepository,
            FieldRepository fieldRepository) {
        this.repository = repository;
        this.trainerRepository = trainerRepository;
        this.fieldRepository = fieldRepository;
    }

    @Override
    public void createLiveClass(LiveClassRequest request) {
        Trainer trainer = trainerRepository.findById(request.getTrainer()).orElseThrow(() -> new DataNotFoundException(request.getTrainer()));
        Field field = fieldRepository.findById(request.getField()).orElseThrow(() -> new DataNotFoundException(request.getField()));

        LiveClass liveClass = new LiveClass();

        liveClass.setField(field);
        liveClass.setTrainer(trainer);
        liveClass.setStartTime(request.getStartTime());
        liveClass.setEndTime(request.getEndTime());
        liveClass.setTitle(request.getTitle());
        liveClass.setType(request.getType());

        repository.save(liveClass);
    }

    @Override
    public LiveClassDto findLiveClass(Long id) {
        LiveClass liveClass = repository.findById(id).orElseThrow(() -> new DataNotFoundException(id));
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
        LiveClass liveClass = repository.findById(request.getId()).orElseThrow(() -> new DataNotFoundException(request.getId()));
        liveClass.setTitle(request.getTitle());
        repository.save(liveClass);
    }

    @Override
    public void addStudentToLiveClass(Long id, Long studentId) {
        // TODO Auto-generated method stub
        
    }

}
