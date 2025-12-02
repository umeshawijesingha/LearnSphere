package com.learnsphere.learnsphere.service;

import com.learnsphere.learnsphere.entity.Lesson;
import com.learnsphere.learnsphere.exception.ResourceNotFoundException;
import com.learnsphere.learnsphere.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    public Lesson createLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public Lesson updateLesson(Long id, Lesson lesson) {
        Lesson existingLesson = lessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found with id: " + id));

        //Update the fields
        existingLesson.setCourse(lesson.getCourse());
        existingLesson.setOrderIndex(lesson.getOrderIndex());
        existingLesson.setDuration(lesson.getDuration());
        existingLesson.setDescription(lesson.getDescription());
        existingLesson.setTitle(lesson.getTitle());
        existingLesson.setContentType(lesson.getContentType());
        existingLesson.setContentUrl(lesson.getContentUrl());

        return lessonRepository.save(existingLesson);
    }

    public void deleteCourse(Long id) {
        lessonRepository.deleteById(id);
    }
}
