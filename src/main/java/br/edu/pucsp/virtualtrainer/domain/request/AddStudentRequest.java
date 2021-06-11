package br.edu.pucsp.virtualtrainer.domain.request;

public class AddStudentRequest {

    private Long liveClassId;

    private Long studentId;

    public Long getLiveClassId() {
        return liveClassId;
    }

    public void setLiveClassId(Long liveClassId) {
        this.liveClassId = liveClassId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
