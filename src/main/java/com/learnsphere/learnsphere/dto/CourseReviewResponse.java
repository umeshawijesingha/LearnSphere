package com.learnsphere.learnsphere.dto;

import com.learnsphere.learnsphere.entity.Course;
import com.learnsphere.learnsphere.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CourseReviewResponse {
    private Long id;
    private Double rating;
    private String comment;
    private Date createdAt;
    private Date updatedAt;
    private Student student;
    private Course course;
}
