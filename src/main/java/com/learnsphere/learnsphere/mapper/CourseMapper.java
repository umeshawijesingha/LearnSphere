package com.learnsphere.learnsphere.mapper;

import com.learnsphere.learnsphere.dto.CourseRequest;
import com.learnsphere.learnsphere.dto.CourseResponse;
import com.learnsphere.learnsphere.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper implements Mapper<Course, CourseRequest, CourseResponse>{
    @Override
    public Course toEntity(CourseRequest request) {
        Course course = new Course();
        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());
        course.setThumbnail(request.getThumbnail());
        course.setPrice(request.getPrice());
        course.setLanguageType(request.getLanguageType());
        course.setLevel(request.getLevel());
        course.setStatus(request.getStatus());
        course.setDuration(request.getDuration());
        course.setTeacher(request.getTeacher());
        course.setSubCategory(request.getSubCategory());
        return course;
    }

    @Override
    public CourseResponse toResponse(Course course) {
        CourseResponse response = new CourseResponse();
        response.setId(course.getId());
        response.setTitle(course.getTitle());
        response.setDescription(course.getDescription());
        response.setThumbnail(course.getThumbnail());
        response.setPrice(course.getPrice());
        response.setLanguageType(course.getLanguageType());
        response.setLevel(course.getLevel());
        response.setStatus(course.getStatus());
        response.setDuration(course.getDuration());
        response.setTeacher(course.getTeacher());
        response.setSubCategory(course.getSubCategory());
        return response;
    }
}
