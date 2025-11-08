package com.learnsphere.learnsphere.dto;

import com.learnsphere.learnsphere.entity.Course;
import com.learnsphere.learnsphere.enums.TeacherEarningStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseEarningRequest {
    private String amount;
    private TeacherEarningStatus status;
    private Course course;
}
