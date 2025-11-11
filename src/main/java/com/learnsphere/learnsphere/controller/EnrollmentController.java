package com.learnsphere.learnsphere.controller;

import com.learnsphere.learnsphere.dto.EnrollmentRequest;
import com.learnsphere.learnsphere.dto.EnrollmentResponse;
import com.learnsphere.learnsphere.entity.Enrollment;
import com.learnsphere.learnsphere.mapper.EnrollmentMapper;
import com.learnsphere.learnsphere.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @GetMapping
    public ResponseEntity<List<EnrollmentResponse>> getAllEnrollments(){
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();

        List<EnrollmentResponse> responses = enrollments.stream()
                .map(enrollment -> enrollmentMapper.toResponse(enrollment)).toList();

        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentResponse> getEnrollmentById(@PathVariable Long id){
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);

        return ResponseEntity.ok(enrollmentMapper.toResponse(enrollment));
    }

    @PostMapping
    public ResponseEntity<EnrollmentResponse> createEnrollment(@RequestBody EnrollmentRequest request){
        Enrollment enrollment = enrollmentMapper.toEntity(request);
        enrollment = enrollmentService.createEnrollment(enrollment);

        return ResponseEntity.status(HttpStatus.CREATED).body(enrollmentMapper.toResponse(enrollment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentResponse> updateEnrollment(@PathVariable Long id, EnrollmentRequest request){
        Enrollment enrollment = enrollmentMapper.toEntity(request);
        enrollment = enrollmentService.updateEnrollment(id, enrollment);

        return ResponseEntity.ok(enrollmentMapper.toResponse(enrollment));
    }
}
