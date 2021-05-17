package br.edu.pucsp.virtualtrainer.model.dto;

import java.time.LocalDateTime;

import br.edu.pucsp.virtualtrainer.model.entity.Field;
import br.edu.pucsp.virtualtrainer.model.entity.Trainer;

public class LiveClassDto {

    private Long id;
    
    private LocalDateTime startTime;
    
    private LocalDateTime endTime;

    private Trainer trainer;
    
    private Field field;
    
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

    public Trainer getTrainer() {
        return trainer;
    }
    
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
    
    public Field getField() {
        return field;
    }
    
    public void setField(Field field) {
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
