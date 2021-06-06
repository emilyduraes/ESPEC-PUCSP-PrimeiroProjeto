package br.edu.pucsp.virtualtrainer.domain.request.api;


import br.edu.pucsp.virtualtrainer.domain.dto.api.MeetingSettingsRequestDto;
import br.edu.pucsp.virtualtrainer.domain.enums.MeetingType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

import static br.edu.pucsp.virtualtrainer.domain.enums.RegistrationType.*;

public class ZoomMeetingRequest {

    private String topic;
    private String agenda;
    private Integer type;
    @JsonProperty("start_time")
    private LocalDateTime startTime;
    private Integer duration;
    @JsonIgnore
    private Long trainerId;
    private MeetingSettingsRequestDto settings;

    public ZoomMeetingRequest() {
    }

    public ZoomMeetingRequest(Builder builder) {
        this.topic = builder.topic;
        this.agenda = builder.agenda;
        this.type = builder.type;
        this.startTime = builder.startTime;
        this.duration = builder.duration;
        this.settings = builder.settings;
        this.trainerId = builder.trainerId;
    }

    public String getTopic() {
        return topic;
    }

    public String getAgenda() {
        return agenda;
    }

    public Integer getType() {
        return type;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public MeetingSettingsRequestDto getSettings() {
        return settings;
    }



    public static class Builder {
        private String topic;
        private String agenda;
        private Integer type;
        private LocalDateTime startTime;
        private Integer duration;
        private Long trainerId;
        private MeetingSettingsRequestDto settings;

        public Builder(){
            this.settings = new MeetingSettingsRequestDto();
        }

        public Builder withName(String name){
            this.topic = name;
            return this;
        }

        public Builder withDescription(String description){
            this.agenda = description;
            return this;
        }

        public Builder duration(Integer duration){
            this.duration = duration;
            return this;
        }

        public Builder type(MeetingType type){
            this.type = type.getValue();
            return this;
        }

        public Builder at(LocalDateTime date){
            this.startTime = date;
            return this;
        }

        public Builder byHost(Long host){
            this.trainerId = host;
            return this;
        }

        public Builder withDefaultSettings(){
            this.settings.setVideoStartedByHost(true);
            this.settings.setMuteUponEntry(true);
            this.settings.setRegistrationType(APPROVE_NOT_NEEDED.getValue());
            this.settings.setAutoRecording("local");
            this.settings.setWaitingRoom(true);
            return this;
        }

        public ZoomMeetingRequest build(){
            return new ZoomMeetingRequest(this);
        }

    }
}
