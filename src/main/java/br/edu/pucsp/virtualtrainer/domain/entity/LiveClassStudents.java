package br.edu.pucsp.virtualtrainer.domain.entity;

import javax.persistence.*;

@Entity
@IdClass(value = LiveClassStudentsId.class)
@Table(name = "live_class_enrolled_students")
public class LiveClassStudents {

    @Id
    @ManyToOne
    @JoinColumn(name = "live_class_id" )
    private LiveClass liveClassId;

    @Id
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student studentId;

    public LiveClassStudents() {
    }

    public LiveClassStudents(LiveClass liveClassId, Student studentId) {
        this.liveClassId = liveClassId;
        this.studentId = studentId;
    }

    public LiveClass getLiveClassId() {
        return liveClassId;
    }

    public void setLiveClassId(LiveClass liveClassId) {
        this.liveClassId = liveClassId;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }
}
