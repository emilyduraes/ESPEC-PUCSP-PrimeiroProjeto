package br.edu.pucsp.virtualtrainer.domain.response.api;

import br.edu.pucsp.virtualtrainer.domain.dto.api.MeetingSettingsResponseDto;

public class ZoomMetingResponse {

    private String uuid;
    private Long id;
    private String host_id;
    private String host_email;
    private String topic;
    private Integer type;
    private String status;
    private String timezone;
    private String agenda;
    private String created_at;
    private String start_url;
    private String join_url;
    private String password;
    private String h323_password;
    private String pstn_password;
    private String encrypted_password;
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

    public String getHost_id() {
        return host_id;
    }

    public void setHost_id(String host_id) {
        this.host_id = host_id;
    }

    public String getHost_email() {
        return host_email;
    }

    public void setHost_email(String host_email) {
        this.host_email = host_email;
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getStart_url() {
        return start_url;
    }

    public void setStart_url(String start_url) {
        this.start_url = start_url;
    }

    public String getJoin_url() {
        return join_url;
    }

    public void setJoin_url(String join_url) {
        this.join_url = join_url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getH323_password() {
        return h323_password;
    }

    public void setH323_password(String h323_password) {
        this.h323_password = h323_password;
    }

    public String getPstn_password() {
        return pstn_password;
    }

    public void setPstn_password(String pstn_password) {
        this.pstn_password = pstn_password;
    }

    public String getEncrypted_password() {
        return encrypted_password;
    }

    public void setEncrypted_password(String encrypted_password) {
        this.encrypted_password = encrypted_password;
    }

    public MeetingSettingsResponseDto getSettings() {
        return settings;
    }

    public void setSettings(MeetingSettingsResponseDto settings) {
        this.settings = settings;
    }
}
