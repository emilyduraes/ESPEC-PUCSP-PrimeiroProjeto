package br.edu.pucsp.virtualtrainer.domain.dto;

import java.time.LocalDateTime;

public class LiveClassDto {

    private Long id;
    
    private LocalDateTime startTime;
    
    private LocalDateTime endTime;

    private TrainerDto trainer;
    
    private FieldDto field;
    
    private String title;

    private String type;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public TrainerDto getTrainer() {
        return trainer;
    }
    
    public void setTrainer(TrainerDto trainer) {
        this.trainer = trainer;
    }
    
    public FieldDto getField() {
        return field;
    }
    
    public void setField(FieldDto field) {
        this.field = field;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
