package br.edu.pucsp.virtualtrainer.domain.enums;

public enum ApprovalType {

    AUTO_APPROVE(0),
    MANUAL(1),
    NOT_NEEDED(2);

    private Integer type;

    private ApprovalType(Integer type) {
        this.type = type;
    }

    public Integer getValue(){
        return this.type;
    }
}
