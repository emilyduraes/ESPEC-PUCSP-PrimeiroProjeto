package br.edu.pucsp.virtualtrainer.domain.dto.api;

public class MeetingSettingsDto {

    private boolean hostVideo;
    private boolean muteUponEntry;
    private Integer approvalType;
    private String autoRecording = "none";
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

    public Integer getApprovalType() {
        return approvalType;
    }

    public void setApprovalType(Integer approvalType) {
        this.approvalType = approvalType;
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
