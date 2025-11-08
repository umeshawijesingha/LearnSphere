package com.learnsphere.learnsphere.mapper;

import com.learnsphere.learnsphere.dto.LessonRequest;
import com.learnsphere.learnsphere.dto.LessonResponse;
import com.learnsphere.learnsphere.entity.Lesson;
import org.springframework.stereotype.Component;

@Component
public class LessonMapper implements Mapper<Lesson, LessonRequest, LessonResponse>{
    @Override
    public Lesson toEntity(LessonRequest request) {
        Lesson lesson =  new Lesson();
        lesson.setOrderIndex(request.getOrderIndex());
        lesson.setTitle(request.getTitle());
        lesson.setDescription(request.getDescription());
        lesson.setDuration(request.getDuration());
        lesson.setContentType(request.getContentType());
        lesson.setContentUrl(request.getContentUrl());
        lesson.setStatus(request.getStatus());
        lesson.setCourse(request.getCourse());
        return lesson;
    }

    @Override
    public LessonResponse toResponse(Lesson lesson) {
        LessonResponse response = new LessonResponse();
        response.setId(lesson.getId());
        response.setOrderIndex(lesson.getOrderIndex());
        response.setTitle(lesson.getTitle());
        response.setDescription(lesson.getDescription());
        response.setDuration(lesson.getDuration());
        response.setContentType(lesson.getContentType());
        response.setContentUrl(lesson.getContentUrl());
        response.setStatus(lesson.getStatus());
        response.setCourse(lesson.getCourse());
        response.setCreatedAt(lesson.getCreatedAt());
        response.setUpdatedAt(lesson.getUpdatedAt());
        return response;
    }
}
