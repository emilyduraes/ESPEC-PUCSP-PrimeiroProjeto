package br.edu.pucsp.virtualtrainer.domain.dto;

import br.edu.pucsp.virtualtrainer.domain.entity.Student;

import java.time.LocalDateTime;
import java.util.List;

public class LiveClassDto {

    private Long id;
    
    private LocalDateTime startTime;
    
    private Integer duration;

    private TrainerDto trainer;
    
    private FieldDto field;
    
    private String title;

    private String type;

    private String startUrl;

    private String joinUrl;

    private List<Student> students;
    
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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

    public String getStartUrl() {
        return startUrl;
    }

    public void setStartUrl(String startUrl) {
        this.startUrl = startUrl;
    }

    public String getJoinUrl() {
        return joinUrl;
    }

    public void setJoinUrl(String joinUrl) {
        this.joinUrl = joinUrl;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
