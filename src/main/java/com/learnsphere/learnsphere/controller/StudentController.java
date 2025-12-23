package com.learnsphere.learnsphere.controller;

import com.learnsphere.learnsphere.dto.StudentRequest;
import com.learnsphere.learnsphere.dto.StudentResponse;
import com.learnsphere.learnsphere.entity.Student;
import com.learnsphere.learnsphere.mapper.StudentMapper;
import com.learnsphere.learnsphere.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Long id){
        Student student = studentService.getStudentByID(id);

        return ResponseEntity.ok(studentMapper.toResponse(student));
    }

    @PreAuthorize("hasRole('student')")
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

    @GetMapping("/search")
    public ResponseEntity<Page<StudentResponse>> search(@RequestParam(required = false) String firstName,
                                                        @RequestParam(required = false) String lastName,
                                                        @RequestParam(required = false) String email,
                                                        @RequestParam(required = false) String city,
                                                        Pageable pageable){
        Page<Student> page = studentService.search(firstName, lastName, email, city, pageable);
        Page<StudentResponse> responses = page.map(studentMapper::toResponse);
        return ResponseEntity.ok(responses);
    }
}
