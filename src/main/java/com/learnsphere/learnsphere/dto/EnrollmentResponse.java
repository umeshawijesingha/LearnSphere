package com.learnsphere.learnsphere.dto;

import com.learnsphere.learnsphere.entity.Course;
import com.learnsphere.learnsphere.entity.Student;
import com.learnsphere.learnsphere.enums.EnrollmentCompletionStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class EnrollmentResponse {
    private Long id;
    private Double progress;
    private EnrollmentCompletionStatus completionStatus;
    private LocalDateTime enrolledAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private SimpleStudentResponse student;
    private SimpleCourseResponse course;
}
