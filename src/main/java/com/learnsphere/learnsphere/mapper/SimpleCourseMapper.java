package com.learnsphere.learnsphere.mapper;

import com.learnsphere.learnsphere.dto.SimpleCourseResponse;
import com.learnsphere.learnsphere.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class SimpleCourseMapper {
    public SimpleCourseResponse toResponse(Course course){
        SimpleCourseResponse response = new SimpleCourseResponse();
        response.setId(course.getId());
        response.setTitle(course.getTitle());
        response.setPrice(course.getPrice());
        return response;
    }
}
