package br.edu.pucsp.virtualtrainer.domain.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MeetingSettingsRequestDto {

    @JsonProperty("host_video")
    private boolean hostVideo;
    @JsonProperty("mute_upon_entry")
    private boolean muteUponEntry;
    @JsonProperty("registration_type")
    private Integer registrationType;
    @JsonProperty("auto_recording")
    private String autoRecording = "none";
    @JsonProperty("waiting_room")
    private boolean waitingRoom;

    public boolean isVideoStartedByHost() {
        return hostVideo;
    }

    public void setVideoStartedByHost(boolean hostVideo) {
        this.hostVideo = hostVideo;
    }

    public boolean isMuteUponEntry() {
        return muteUponEntry;
    }

    public void setMuteUponEntry(boolean muteUponEntry) {
        this.muteUponEntry = muteUponEntry;
    }

    public Integer getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(Integer registrationType) {
        this.registrationType = registrationType;
    }

    public String isAutoRecording() {
        return autoRecording;
    }

    public void setAutoRecording(String autoRecording) {
        this.autoRecording = autoRecording;
    }

    public boolean isWaitingRoom() {
        return waitingRoom;
    }

    public void setWaitingRoom(boolean waitingRoom) {
        this.waitingRoom = waitingRoom;
    }

}
