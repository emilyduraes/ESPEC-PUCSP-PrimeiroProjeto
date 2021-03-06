package br.edu.pucsp.virtualtrainer.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.pucsp.virtualtrainer.service.StudentService;
import br.edu.pucsp.virtualtrainer.domain.request.StudentRequest;
import br.edu.pucsp.virtualtrainer.domain.response.StudentListResponse;
import br.edu.pucsp.virtualtrainer.domain.response.StudentResponse;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://34.68.231.180")
@RestController()
@RequestMapping("/student")
@PreAuthorize("hasRole('STUDENT')")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ApiOperation(value = "Insert a Student into the database")
    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody @Valid StudentRequest request) {
        studentService.createStudent(request);
    }

    @ApiOperation(value = "Find a Student from the database")
    @GetMapping(path = "/id/{studentId}")
    public StudentResponse getStudent(@PathVariable Long studentId) {
        return new StudentResponse(studentService.findStudent(studentId));
    }

    @ApiOperation(value = "Find a Student by name")
    @GetMapping(path = "/name/{studentName}")
    public StudentListResponse getStudents(@PathVariable String studentName){
        return new StudentListResponse(studentService.findStudents(studentName));
    }

    @ApiOperation(value = "Update a Student in the database")
    @PutMapping
    public void updateStudent(@RequestBody @Valid StudentRequest request) {
        studentService.updateStudent(request);
    }

    @ApiOperation(value = "Delete (deactivate) a Student from the database")
    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }
}

