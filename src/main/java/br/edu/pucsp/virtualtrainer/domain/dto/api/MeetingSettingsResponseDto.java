package br.edu.pucsp.virtualtrainer.domain.dto.api;

public class MeetingSettingsResponseDto {

    private boolean host_video;
    private boolean participant_video;
    private boolean cn_meeting;
    private boolean in_meeting;
    private boolean join_before_host;
    private Integer jbh_time;
    private boolean mute_upon_entry;
    private boolean watermark;
    private boolean use_pmi;
    private Integer approval_type;
    private String audio;
    private String auto_recording;
    private boolean enforce_login;
    private String enforce_login_domains;
    private String alternative_hosts;
    private boolean close_registration;
    private boolean show_share_button;
    private boolean allow_multiple_devices;
    private boolean registrants_confirmation_email;
    private boolean waiting_room;
    private boolean request_permission_to_unmute_participants;
    private String contact_name;
    private String contact_email;
    private boolean registrants_email_notification;
    private boolean meeting_authentication;
    private String encryption_type;
    private CountriesAndRegionsDto approved_or_denied_countries_or_regions;
    private BreakoutRoomDto breakout_room;
    private boolean alternative_hosts_email_notification;
    private boolean device_testing;

    public boolean isHost_video() {
        return host_video;
    }

    public void setHost_video(boolean host_video) {
        this.host_video = host_video;
    }

    public boolean isParticipant_video() {
        return participant_video;
    }

    public void setParticipant_video(boolean participant_video) {
        this.participant_video = participant_video;
    }

    public boolean isCn_meeting() {
        return cn_meeting;
    }

    public void setCn_meeting(boolean cn_meeting) {
        this.cn_meeting = cn_meeting;
    }

    public boolean isIn_meeting() {
        return in_meeting;
    }

    public void setIn_meeting(boolean in_meeting) {
        this.in_meeting = in_meeting;
    }

    public boolean isJoin_before_host() {
        return join_before_host;
    }

    public void setJoin_before_host(boolean join_before_host) {
        this.join_before_host = join_before_host;
    }

    public Integer getJbh_time() {
        return jbh_time;
    }

    public void setJbh_time(Integer jbh_time) {
        this.jbh_time = jbh_time;
    }

    public boolean isMute_upon_entry() {
        return mute_upon_entry;
    }

    public void setMute_upon_entry(boolean mute_upon_entry) {
        this.mute_upon_entry = mute_upon_entry;
    }

    public boolean isWatermark() {
        return watermark;
    }

    public void setWatermark(boolean watermark) {
        this.watermark = watermark;
    }

    public boolean isUse_pmi() {
        return use_pmi;
    }

    public void setUse_pmi(boolean use_pmi) {
        this.use_pmi = use_pmi;
    }

    public Integer getApproval_type() {
        return approval_type;
    }

    public void setApproval_type(Integer approval_type) {
        this.approval_type = approval_type;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getAuto_recording() {
        return auto_recording;
    }

    public void setAuto_recording(String auto_recording) {
        this.auto_recording = auto_recording;
    }

    public boolean isEnforce_login() {
        return enforce_login;
    }

    public void setEnforce_login(boolean enforce_login) {
        this.enforce_login = enforce_login;
    }

    public String getEnforce_login_domains() {
        return enforce_login_domains;
    }

    public void setEnforce_login_domains(String enforce_login_domains) {
        this.enforce_login_domains = enforce_login_domains;
    }

    public String getAlternative_hosts() {
        return alternative_hosts;
    }

    public void setAlternative_hosts(String alternative_hosts) {
        this.alternative_hosts = alternative_hosts;
    }

    public boolean isClose_registration() {
        return close_registration;
    }

    public void setClose_registration(boolean close_registration) {
        this.close_registration = close_registration;
    }

    public boolean isShow_share_button() {
        return show_share_button;
    }

    public void setShow_share_button(boolean show_share_button) {
        this.show_share_button = show_share_button;
    }

    public boolean isAllow_multiple_devices() {
        return allow_multiple_devices;
    }

    public void setAllow_multiple_devices(boolean allow_multiple_devices) {
        this.allow_multiple_devices = allow_multiple_devices;
    }

    public boolean isRegistrants_confirmation_email() {
        return registrants_confirmation_email;
    }

    public void setRegistrants_confirmation_email(boolean registrants_confirmation_email) {
        this.registrants_confirmation_email = registrants_confirmation_email;
    }

    public boolean isWaiting_room() {
        return waiting_room;
    }

    public void setWaiting_room(boolean waiting_room) {
        this.waiting_room = waiting_room;
    }

    public boolean isRequest_permission_to_unmute_participants() {
        return request_permission_to_unmute_participants;
    }

    public void setRequest_permission_to_unmute_participants(boolean request_permission_to_unmute_participants) {
        this.request_permission_to_unmute_participants = request_permission_to_unmute_participants;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public boolean isRegistrants_email_notification() {
        return registrants_email_notification;
    }

    public void setRegistrants_email_notification(boolean registrants_email_notification) {
        this.registrants_email_notification = registrants_email_notification;
    }

    public boolean isMeeting_authentication() {
        return meeting_authentication;
    }

    public void setMeeting_authentication(boolean meeting_authentication) {
        this.meeting_authentication = meeting_authentication;
    }

    public String getEncryption_type() {
        return encryption_type;
    }

    public void setEncryption_type(String encryption_type) {
        this.encryption_type = encryption_type;
    }

    public CountriesAndRegionsDto getApproved_or_denied_countries_or_regions() {
        return approved_or_denied_countries_or_regions;
    }

    public void setApproved_or_denied_countries_or_regions(CountriesAndRegionsDto approved_or_denied_countries_or_regions) {
        this.approved_or_denied_countries_or_regions = approved_or_denied_countries_or_regions;
    }

    public BreakoutRoomDto getBreakout_room() {
        return breakout_room;
    }

    public void setBreakout_room(BreakoutRoomDto breakout_room) {
        this.breakout_room = breakout_room;
    }

    public boolean isAlternative_hosts_email_notification() {
        return alternative_hosts_email_notification;
    }

    public void setAlternative_hosts_email_notification(boolean alternative_hosts_email_notification) {
        this.alternative_hosts_email_notification = alternative_hosts_email_notification;
    }

    public boolean isDevice_testing() {
        return device_testing;
    }

    public void setDevice_testing(boolean device_testing) {
        this.device_testing = device_testing;
    }
}
