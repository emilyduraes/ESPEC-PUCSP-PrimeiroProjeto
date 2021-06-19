package br.edu.pucsp.virtualtrainer.domain.response;

import br.edu.pucsp.virtualtrainer.domain.dto.TrainerDto;

import java.util.List;

public class TrainerListResponse {

    private List<TrainerDto> trainers;

    public TrainerListResponse(List<TrainerDto> trainers) {
        this.trainers = trainers;
    }

    public List<TrainerDto> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<TrainerDto> trainers) {
        this.trainers = trainers;
    }
}
