package com.learnsphere.learnsphere.controller;

import com.learnsphere.learnsphere.dto.StudentRequest;
import com.learnsphere.learnsphere.dto.StudentResponse;
import com.learnsphere.learnsphere.entity.Student;
import com.learnsphere.learnsphere.mapper.StudentMapper;
import com.learnsphere.learnsphere.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents(){
        List<Student> students = studentService.getAllStudents();

        List<StudentResponse> responses = students.stream()
                .map(studentMapper::toResponse)
                .toList();

        return ResponseEntity.status(HttpStatus.CREATED).body(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Long id){
        Student student = studentService.getStudentByID(id);

        return ResponseEntity.ok(studentMapper.toResponse(student));
    }

    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest request){
        Student student = studentMapper.toEntity(request);
        student = studentService.createStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(studentMapper.toResponse(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> updateStudent(@PathVariable Long id, @RequestBody StudentRequest request){
        Student student = studentMapper.toEntity(request);
        student = studentService.updateStudent(id, student);

        return ResponseEntity.ok(studentMapper.toResponse(student));

    }
}
