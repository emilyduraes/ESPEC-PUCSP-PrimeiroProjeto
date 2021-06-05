package br.edu.pucsp.virtualtrainer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import br.edu.pucsp.virtualtrainer.exception.CertificateNotPresentException;
import br.edu.pucsp.virtualtrainer.exception.DataNotFoundException;
import br.edu.pucsp.virtualtrainer.mapper.TrainerMapper;
import br.edu.pucsp.virtualtrainer.model.dto.TrainerDto;
import br.edu.pucsp.virtualtrainer.model.entity.Field;
import br.edu.pucsp.virtualtrainer.model.entity.Trainer;
import br.edu.pucsp.virtualtrainer.model.entity.TrainerField;
import br.edu.pucsp.virtualtrainer.repository.FieldRepository;
import br.edu.pucsp.virtualtrainer.repository.TrainerFieldRepository;
import br.edu.pucsp.virtualtrainer.repository.TrainerRepository;
import br.edu.pucsp.virtualtrainer.transport.request.TrainerFieldRequest;
import br.edu.pucsp.virtualtrainer.transport.request.TrainerRequest;


@Service
public class TrainerServiceImpl implements TrainerService {

    private static final TrainerMapper MAPPER = Mappers.getMapper(TrainerMapper.class);

    TrainerRepository repository;

    FieldRepository fieldRepository;

    TrainerFieldRepository trainerFieldRepository;

    public TrainerServiceImpl(TrainerRepository repository, FieldRepository fieldRepository,
                              TrainerFieldRepository trainerFieldRepository){
        this.repository = repository;
        this.fieldRepository = fieldRepository;
        this.trainerFieldRepository = trainerFieldRepository;
    }

    @Override
    public void createTrainer(TrainerRequest request) {
        Trainer trainer = MAPPER.requestToEntity(request);
        repository.save(trainer);
    }

    @Override
    public List<TrainerDto> findTrainers(String nickname) {
        return repository.findByNickname(nickname)
                .orElseThrow(() -> new DataNotFoundException(String.join(" ", nickname)))
                .stream()
                .filter(Trainer::isActive)
                .map(MAPPER::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TrainerDto findTrainer(Long trainerId) {
        Trainer trainer = repository.findById(trainerId)
                .orElseThrow(() -> new DataNotFoundException(trainerId));
        return MAPPER.entityToDto(trainer);
    }

    @Override
    public List<TrainerDto> findAllTrainers() {//TODO add case for no results?
        return repository.findAll()
                .stream()
                .filter(Trainer::isActive)
                .map(MAPPER::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTrainer(Long trainerId) {
        Trainer trainer = repository.findById(trainerId)
                .orElseThrow(() -> new DataNotFoundException(trainerId));
        trainer.setActive(false);
        repository.save(trainer);
    }

    @Override
    public void updateTrainer(TrainerRequest request) {
        Trainer trainer = repository.findById(request.getId())
                .orElseThrow(() -> new DataNotFoundException(request.getId()));
        trainer.setNickname(request.getNickname());
        trainer.setFullName(request.getFullName());
        trainer.setBirthdate(request.getBirthdate());
        trainer.setEmail(request.getEmail());
        trainer.setZoomAccount(request.getZoomAccount());
        trainer.setCellphone(request.getCellphone());
        repository.save(trainer);
    }

    @Override
    public void addFields(TrainerFieldRequest trainerFieldRequest){
        Field field = fieldRepository.findById(trainerFieldRequest.getFieldId()).orElseThrow(() -> new DataNotFoundException(trainerFieldRequest.getFieldId()));
        Trainer trainer = repository.findById(trainerFieldRequest.getTrainerId()).orElseThrow(() -> new DataNotFoundException(trainerFieldRequest.getTrainerId()));

        TrainerField trainerField = new TrainerField(trainer, field);
        if (field.isCertified()){
            if(trainerFieldRequest.getCertificate() != null){
                trainerField.setCertificate(trainerFieldRequest.getCertificate());
            } else{
                throw new CertificateNotPresentException();
            }
        }
        trainerFieldRepository.save(trainerField);
    }
}
