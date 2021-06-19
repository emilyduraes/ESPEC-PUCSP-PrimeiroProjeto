package br.edu.pucsp.virtualtrainer.service;

import java.util.List;

import br.edu.pucsp.virtualtrainer.domain.dto.StudentDto;
import br.edu.pucsp.virtualtrainer.domain.request.StudentRequest;

public interface StudentService {

    void createStudent(StudentRequest request);
    StudentDto findStudent(Long id);
    List<StudentDto> findStudents(String name);
    void deleteStudent(Long id);
    void updateStudent(StudentRequest request);
}