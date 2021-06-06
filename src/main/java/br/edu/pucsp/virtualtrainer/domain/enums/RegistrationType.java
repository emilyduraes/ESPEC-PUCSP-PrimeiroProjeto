package br.edu.pucsp.virtualtrainer.domain.enums;

public enum RegistrationType {

    AUTO_APPROVE(0),
    MANUAL_APPROVE(1),
    APPROVE_NOT_NEEDED(2);

    private Integer type;

    private RegistrationType(Integer type) {
        this.type = type;
    }

    public Integer getValue(){
        return this.type;
    }
}
