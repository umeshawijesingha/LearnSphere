package com.learnsphere.learnsphere.dto;

import com.learnsphere.learnsphere.entity.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherReviewRequest {
    private Double rating;
    private String comment;
    private Student student;
}
