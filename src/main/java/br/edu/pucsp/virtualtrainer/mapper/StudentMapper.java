package br.edu.pucsp.virtualtrainer.mapper;

import org.mapstruct.Mapper;

import br.edu.pucsp.virtualtrainer.domain.dto.StudentDto;
import br.edu.pucsp.virtualtrainer.domain.entity.Student;
import br.edu.pucsp.virtualtrainer.domain.request.StudentRequest;

@Mapper()
public interface StudentMapper {
    Student dtoToEntity(StudentDto studentDto);
    StudentDto entityToDto(Student student);
    Student requestToEntity(StudentRequest request);
}