package br.edu.pucsp.virtualtrainer.transport.request;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "LiveSessionRequest", description = "Transport class for Live Sessions")
public class LiveSessionRequest {

    @ApiModelProperty(name = "id")
    private Long id;

    @ApiModelProperty(name = "date")
    @Future(message = "This is not a valid date")
    private LocalDate date;

    @ApiModelProperty(name = "length")
    @Positive(message = "Invalid time length")
    @Min(value = 15, message = "A live session should have between 15 and 40 minutes")
    @Max(value = 40, message = "A live session should have between 15 and 40 minutes")
    private Integer length;

    @ApiModelProperty(name = "trainerId")
    private Long trainer;

    @ApiModelProperty(name = "fieldId")
    private Long field;

    @ApiModelProperty(name = "title")
    @NotEmpty(message = "The title cannot be null or empty")
    @Size(min = 3, max = 100, message = "A title should have between 3 and 255 characters")
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
