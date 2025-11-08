package com.learnsphere.learnsphere.dto;

import com.learnsphere.learnsphere.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TeacherReviewResponse {
    private Long id;
    private Double rating;
    private String comment;
    private Student student;
    private Date createdAt;
    private Date updatedAt;
}
