package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.domain.request.TrainerFieldRequest;
import br.edu.pucsp.virtualtrainer.domain.dto.TrainerDto;
import br.edu.pucsp.virtualtrainer.domain.request.TrainerRequest;

import java.util.List;

public interface TrainerService {

    void createTrainer(TrainerRequest request);
    List<TrainerDto> findTrainers(String name);
    TrainerDto findTrainer(Long trainerId);
    List<TrainerDto> findAllTrainers();
    void addFields(TrainerFieldRequest trainerFieldRequest);
    void deleteTrainer(Long trainerId);
    void updateTrainer(TrainerRequest request);
}
