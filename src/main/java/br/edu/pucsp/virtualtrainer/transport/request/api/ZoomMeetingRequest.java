package br.edu.pucsp.virtualtrainer.transport.request.api;


import br.edu.pucsp.virtualtrainer.domain.dto.api.MeetingSettingsDto;
import br.edu.pucsp.virtualtrainer.domain.enums.ApprovalType;
import br.edu.pucsp.virtualtrainer.domain.enums.MeetingType;

import java.time.LocalDateTime;

public class ZoomMeetingRequest {

    private String topic;
    private String agenda;
    private Integer type;
    private LocalDateTime startTime;
    private Integer duration;
    private MeetingSettingsDto settings;


    public ZoomMeetingRequest(Builder builder) {
        this.topic = builder.topic;
        this.agenda = builder.agenda;
        this.type = builder.type;
        this.startTime = builder.startTime;
        this.duration = builder.duration;
        this.settings = builder.settings;
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

    public MeetingSettingsDto getSettings() {
        return settings;
    }



    public static class Builder {
        private String topic;
        private String agenda;
        private Integer type;
        private LocalDateTime startTime;
        private Integer duration;
        private MeetingSettingsDto settings;

        public Builder(){
            this.settings = new MeetingSettingsDto();
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

        public Builder withDefaultSettings(){
            this.settings.setVideoStartedByHost(true);
            this.settings.setMuteUponEntry(true);
            this.settings.setApprovalType(ApprovalType.NOT_NEEDED.getValue());
            this.settings.setAutoRecording("local");
            this.settings.setWaitingRoom(true);
            return this;
        }

        public ZoomMeetingRequest build(){
            return new ZoomMeetingRequest(this);
        }

    }
}
