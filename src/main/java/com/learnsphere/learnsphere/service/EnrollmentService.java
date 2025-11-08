package com.learnsphere.learnsphere.service;

import com.learnsphere.learnsphere.entity.Enrollment;
import com.learnsphere.learnsphere.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    private EnrollmentRepository enrollmentRepository;

    public List<Enrollment> getAllEnrollments(){
        return enrollmentRepository.findAll();
    }
}
