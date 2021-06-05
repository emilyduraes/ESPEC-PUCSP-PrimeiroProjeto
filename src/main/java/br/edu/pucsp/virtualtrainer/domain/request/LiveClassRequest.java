package br.edu.pucsp.virtualtrainer.domain.request;

import java.time.LocalDateTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
    
    @ApiModelProperty(name = "endTime")
    @Future(message = "This is not a valid end time")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

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
}
