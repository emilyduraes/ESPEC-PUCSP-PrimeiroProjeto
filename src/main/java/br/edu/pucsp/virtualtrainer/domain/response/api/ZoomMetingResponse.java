package br.edu.pucsp.virtualtrainer.domain.response.api;

import br.edu.pucsp.virtualtrainer.domain.dto.api.MeetingSettingsResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ZoomMetingResponse {

    private String uuid;
    private Long id;
    @JsonProperty("host_id")
    private String hostId;
    @JsonProperty("host_email")
    private String hostEmail;
    private String topic;
    private Integer type;
    private String status;
    private String timezone;
    private String agenda;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("start_url")
    private String startUrl;
    @JsonProperty("join_url")
    private String joinUrl;
    private String password;
    @JsonProperty("h323_password")
    private String h323Password;
    @JsonProperty("pstn_password")
    private String pstnPassword;
    @JsonProperty("encrypted_password")
    private String encryptedPassword;
    private MeetingSettingsResponseDto settings;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getHostEmail() {
        return hostEmail;
    }

    public void setHostEmail(String hostEmail) {
        this.hostEmail = hostEmail;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getH323Password() {
        return h323Password;
    }

    public void setH323Password(String h323Password) {
        this.h323Password = h323Password;
    }

    public String getPstnPassword() {
        return pstnPassword;
    }

    public void setPstnPassword(String pstnPassword) {
        this.pstnPassword = pstnPassword;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public MeetingSettingsResponseDto getSettings() {
        return settings;
    }

    public void setSettings(MeetingSettingsResponseDto settings) {
        this.settings = settings;
    }
}
