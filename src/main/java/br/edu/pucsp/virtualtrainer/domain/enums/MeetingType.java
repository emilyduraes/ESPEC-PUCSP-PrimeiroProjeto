package br.edu.pucsp.virtualtrainer.domain.enums;

public enum MeetingType {

    INSTANT(1),
    SCHEDULED(2),
    RECURRING(3),
    FIXED_TIME_RECURRING(4);

    private Integer type;

    private MeetingType(Integer type) {
        this.type = type;
    }

    public Integer getValue(){
        return this.type;
    }
}
