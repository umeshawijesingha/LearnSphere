package com.learnsphere.learnsphere.mapper;

import com.learnsphere.learnsphere.dto.EnrollmentRequest;
import com.learnsphere.learnsphere.dto.EnrollmentResponse;
import com.learnsphere.learnsphere.entity.Enrollment;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentMapper implements Mapper<Enrollment, EnrollmentRequest, EnrollmentResponse>{
    @Override
    public Enrollment toEntity(EnrollmentRequest request) {
        Enrollment enrollment = new Enrollment();
        enrollment.setProgress(request.getProgress());
        enrollment.setCompletionStatus(request.getCompletionStatus());
        enrollment.setEnrolledAt(request.getEnrolledAt());
        return enrollment;
    }

    @Override
    public EnrollmentResponse toResponse(Enrollment enrollment) {
        EnrollmentResponse response = new EnrollmentResponse();
        enrollment.setId(enrollment.getId());
        response.setProgress(enrollment.getProgress());
        response.setCompletionStatus(enrollment.getCompletionStatus());
        enrollment.setEnrolledAt(enrollment.getEnrolledAt());
        enrollment.setCreatedAt(enrollment.getCreatedAt());
        enrollment.setUpdatedAt(enrollment.getUpdatedAt());
        return null;
    }
}
