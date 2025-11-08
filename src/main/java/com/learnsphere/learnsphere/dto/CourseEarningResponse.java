package com.learnsphere.learnsphere.dto;

import com.learnsphere.learnsphere.entity.Course;
import com.learnsphere.learnsphere.enums.TeacherEarningStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CourseEarningResponse {
    private Long id;
    private String amount;
    private TeacherEarningStatus status;
    private Date paidOutAt;
    private Date createdAt;
    private Date updatedAt;
    private Course course;
}
