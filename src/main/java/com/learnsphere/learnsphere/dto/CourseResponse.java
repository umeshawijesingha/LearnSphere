package com.learnsphere.learnsphere.dto;

import com.learnsphere.learnsphere.entity.SubCategory;
import com.learnsphere.learnsphere.entity.Teacher;
import com.learnsphere.learnsphere.enums.CourseLanguageType;
import com.learnsphere.learnsphere.enums.CourseLevel;
import com.learnsphere.learnsphere.enums.CourseStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CourseResponse {

    private Long id;
    private String title;
    private String description;
    private String thumbnail;
    private Double price;
    private CourseLanguageType languageType;
    private CourseLevel level;
    private CourseStatus status;
    private Double duration;
    private Date createdAt;
    private Date updatedAt;
    private Teacher teacher;
    private SubCategory subCategory;
}
