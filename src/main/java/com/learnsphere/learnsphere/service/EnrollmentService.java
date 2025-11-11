package com.learnsphere.learnsphere.service;

import com.learnsphere.learnsphere.entity.Enrollment;
import com.learnsphere.learnsphere.exception.ResourceNotFoundException;
import com.learnsphere.learnsphere.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    private EnrollmentRepository enrollmentRepository;

    public List<Enrollment> getAllEnrollments(){
        return enrollmentRepository.findAll();
    }

    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with id:" + id));
    }

    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public Enrollment updateEnrollment(Long id, Enrollment enrollment) {
        Enrollment existingEnrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with id:" + id));

        //Update the fields
        existingEnrollment.setEnrolledAt(enrollment.getEnrolledAt());
        existingEnrollment.setProgress(enrollment.getProgress());
        existingEnrollment.setCompletionStatus(enrollment.getCompletionStatus());
        enrollment.setStudent(enrollment.getStudent());
        enrollment.setUpdatedAt(enrollment.getUpdatedAt());

        return enrollmentRepository.save(existingEnrollment);

    }
}
