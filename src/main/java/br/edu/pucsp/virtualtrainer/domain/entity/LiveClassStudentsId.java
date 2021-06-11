package br.edu.pucsp.virtualtrainer.domain.entity;

import java.io.Serializable;
import java.util.Objects;

public class LiveClassStudentsId implements Serializable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LiveClassStudentsId that = (LiveClassStudentsId) o;
        return liveClassId.equals(that.liveClassId) && studentId.equals(that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(liveClassId, studentId);
    }
}
