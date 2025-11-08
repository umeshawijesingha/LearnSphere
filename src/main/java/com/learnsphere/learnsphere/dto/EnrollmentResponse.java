package com.learnsphere.learnsphere.dto;

import com.learnsphere.learnsphere.entity.Course;
import com.learnsphere.learnsphere.entity.Student;
import com.learnsphere.learnsphere.enums.EnrollmentCompletionStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EnrollmentResponse {
    private Long id;
    private Double progress;
    private EnrollmentCompletionStatus completionStatus;
    private Date enrolledAt;
    private Date createdAt;
    private Date updatedAt;
    private Student student;
    private Course course;
}
