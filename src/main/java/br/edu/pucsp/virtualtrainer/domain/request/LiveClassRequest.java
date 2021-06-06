package br.edu.pucsp.virtualtrainer.domain.request;

import java.time.LocalDateTime;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "LiveClassRequest", description = "Transport class for Live Class")
public class LiveClassRequest {

    @ApiModelProperty(name = "id")
    private Long id;

    @ApiModelProperty(name = "startTime")
    @Future(message = "This is not a valid start time")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    
    @ApiModelProperty(name = "duration")
    @Max(60)
    @Min(5)
    private Integer duration;

    @ApiModelProperty(name = "trainerId")
    private Long trainer;

    @ApiModelProperty(name = "fieldId")
    private Long field;

    @ApiModelProperty(name = "title")
    @NotEmpty(message = "The title cannot be null or empty")
    @Size(min = 3, max = 100, message = "A title should have between 3 and 255 characters")
    private String title;

    @ApiModelProperty(name = "type")
    private String type;

    @ApiModelProperty(name = "title")
    @NotEmpty(message = "Please inform a description for the class")
    @Size(min = 10, max = 200, message = "A description should have between 10 and 200 characters")
    private String description;


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

    public Long getTrainer() {
        return trainer;
    }

    public void setTrainer(Long trainer) {
        this.trainer = trainer;
    }

    public Long getField() {
        return field;
    }

    public void setField(Long field) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
