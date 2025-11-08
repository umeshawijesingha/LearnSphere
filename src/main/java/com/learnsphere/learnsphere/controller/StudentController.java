package com.learnsphere.learnsphere.controller;

import com.learnsphere.learnsphere.dto.StudentResponse;
import com.learnsphere.learnsphere.entity.Student;
import com.learnsphere.learnsphere.mapper.StudentMapper;
import com.learnsphere.learnsphere.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
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
}
