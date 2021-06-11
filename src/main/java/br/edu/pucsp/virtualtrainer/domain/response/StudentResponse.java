package br.edu.pucsp.virtualtrainer.domain.response;

import br.edu.pucsp.virtualtrainer.domain.dto.StudentDto;

public class StudentResponse {
    
    private StudentDto student;

    public StudentResponse(StudentDto student) {
        this.student = student;
    }

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }
}
