package com.learnsphere.learnsphere.dto;

import com.learnsphere.learnsphere.entity.Course;
import com.learnsphere.learnsphere.enums.LessonContentType;
import com.learnsphere.learnsphere.enums.LessonStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LessonResponse {
    private Long id;
    private int orderIndex;
    private String title;
    private String description;
    private LessonContentType contentType;
    private LessonStatus status;
    private String contentUrl;
    private Double duration;
    private Date createdAt;
    private Date updatedAt;
    private Course course;
}
