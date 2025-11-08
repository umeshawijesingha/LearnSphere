package com.learnsphere.learnsphere.mapper;

import com.learnsphere.learnsphere.dto.CourseEarningRequest;
import com.learnsphere.learnsphere.dto.CourseEarningResponse;
import com.learnsphere.learnsphere.entity.CourseEarning;
import org.springframework.stereotype.Component;

@Component
public class CourseEarningMapper implements Mapper<CourseEarning, CourseEarningRequest, CourseEarningResponse>{
    @Override
    public CourseEarning toEntity(CourseEarningRequest request) {
        CourseEarning courseEarning = new CourseEarning();
        courseEarning.setAmount(request.getAmount());
        courseEarning.setStatus(request.getStatus());
        courseEarning.setCourse(request.getCourse());
        return courseEarning;
    }

    @Override
    public CourseEarningResponse toResponse(CourseEarning courseEarning) {
        CourseEarningResponse response = new CourseEarningResponse();
        response.setId(courseEarning.getId());
        response.setAmount(courseEarning.getAmount());
        response.setStatus(courseEarning.getStatus());
        response.setCourse(courseEarning.getCourse());
        response.setPaidOutAt(courseEarning.getPaidOutAt());
        response.setCreatedAt(courseEarning.getCreatedAt());
        response.setUpdatedAt(courseEarning.getUpdatedAt());
        return null;
    }
}
