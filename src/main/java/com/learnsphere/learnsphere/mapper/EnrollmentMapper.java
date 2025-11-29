package com.learnsphere.learnsphere.mapper;

import com.learnsphere.learnsphere.dto.EnrollmentRequest;
import com.learnsphere.learnsphere.dto.EnrollmentResponse;
import com.learnsphere.learnsphere.entity.Enrollment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnrollmentMapper implements Mapper<Enrollment, EnrollmentRequest, EnrollmentResponse>{
    private final SimpleStudentMapper simpleStudentMapper;
    private final SimpleCourseMapper simpleCourseMapper;

    @Override
    public Enrollment toEntity(EnrollmentRequest request) {
        Enrollment enrollment = new Enrollment();
        enrollment.setProgress(request.getProgress());
        enrollment.setCompletionStatus(request.getCompletionStatus());
        return enrollment;
    }

    @Override
    public EnrollmentResponse toResponse(Enrollment enrollment) {
        EnrollmentResponse response = new EnrollmentResponse();
        response.setId(enrollment.getId());
        response.setProgress(enrollment.getProgress());
        response.setCompletionStatus(enrollment.getCompletionStatus());
        response.setEnrolledAt(enrollment.getEnrolledAt());
        response.setCreatedAt(enrollment.getCreatedAt());
        response.setUpdatedAt(enrollment.getUpdatedAt());
        response.setStudent(simpleStudentMapper.toSimpleResponse(enrollment.getStudent()));
        response.setCourse(simpleCourseMapper.toResponse(enrollment.getCourse()));
        return response;
    }
}
