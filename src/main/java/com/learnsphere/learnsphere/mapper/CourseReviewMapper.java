package com.learnsphere.learnsphere.mapper;

import com.learnsphere.learnsphere.dto.CourseReviewRequest;
import com.learnsphere.learnsphere.dto.CourseReviewResponse;
import com.learnsphere.learnsphere.entity.CourseReview;
import org.springframework.stereotype.Component;

@Component
public class CourseReviewMapper implements Mapper<CourseReview, CourseReviewRequest, CourseReviewResponse>{
    @Override
    public CourseReview toEntity(CourseReviewRequest request) {
        CourseReview courseReview =  new CourseReview();
        courseReview.setRating(request.getRating());
        courseReview.setComment(request.getComment());
        courseReview.setStudent(request.getStudent());
        courseReview.setCourse(request.getCourse());
        return null;
    }

    @Override
    public CourseReviewResponse toResponse(CourseReview courseReview) {
        CourseReviewResponse response = new CourseReviewResponse();
        response.setId(courseReview.getId());
        response.setRating(courseReview.getRating());
        response.setComment(courseReview.getComment());
        response.setCreatedAt(courseReview.getCreatedAt());
        response.setUpdatedAt(courseReview.getUpdatedAt());
        return  response;
    }
}
