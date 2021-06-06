package br.edu.pucsp.virtualtrainer.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "live_class")
public class LiveClass {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "start_time")
    private LocalDateTime startTime;
    
    @Column(nullable = false)
    private Integer duration;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "trainer", referencedColumnName = "id")
    private Trainer trainer;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "field", referencedColumnName = "id")
    private Field field;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false, name = "start_url")
    private String startUrl;

    @Column(nullable = false, name = "join_url")
    private String joinUrl;

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
}
