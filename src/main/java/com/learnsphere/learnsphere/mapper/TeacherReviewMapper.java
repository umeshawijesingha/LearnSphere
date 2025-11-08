package com.learnsphere.learnsphere.mapper;

import com.learnsphere.learnsphere.dto.TeacherReviewRequest;
import com.learnsphere.learnsphere.dto.TeacherReviewResponse;
import com.learnsphere.learnsphere.entity.TeacherReview;
import org.springframework.stereotype.Component;

@Component
public class TeacherReviewMapper implements Mapper <TeacherReview, TeacherReviewRequest, TeacherReviewResponse>{
    @Override
    public TeacherReview toEntity(TeacherReviewRequest request) {
        TeacherReview teacherReview = new TeacherReview();
        teacherReview.setRating(request.getRating());
        teacherReview.setComment(request.getComment());
        teacherReview.setStudent(request.getStudent());
        return teacherReview;
    }

    @Override
    public TeacherReviewResponse toResponse(TeacherReview teacherReview) {
        TeacherReviewResponse response = new TeacherReviewResponse();
        response.setId(teacherReview.getId());
        response.setRating(teacherReview.getRating());
        response.setComment(teacherReview.getComment());
        response.setStudent(teacherReview.getStudent());
        response.setCreatedAt(teacherReview.getCreatedAt());
        response.setUpdatedAt(teacherReview.getUpdatedAt());
        return response;
    }
}
