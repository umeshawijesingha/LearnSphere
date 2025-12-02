package com.learnsphere.learnsphere.controller;

import com.learnsphere.learnsphere.dto.LessonRequest;
import com.learnsphere.learnsphere.dto.LessonResponse;
import com.learnsphere.learnsphere.entity.Lesson;
import com.learnsphere.learnsphere.mapper.LessonMapper;
import com.learnsphere.learnsphere.service.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    private LessonService lessonService;
    private LessonMapper lessonMapper;

    @GetMapping
    public ResponseEntity<List<LessonResponse>> getAllLessons() {
        List<Lesson> lessons = lessonService.getAllLessons();
        List<LessonResponse> response = lessons.stream()
                .map(lessonMapper::toResponse).toList();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<LessonResponse> createLesson(@RequestBody LessonRequest request) {
        Lesson lesson = lessonMapper.toEntity(request);
        lesson = lessonService.createLesson(lesson);

        return ResponseEntity.status(HttpStatus.CREATED).body(lessonMapper.toResponse(lesson));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonResponse> updateLesson(@PathVariable Long id, @RequestBody LessonRequest request) {
        Lesson lesson = lessonMapper.toEntity(request);
        lesson = lessonService.updateLesson(id, lesson);

        return ResponseEntity.ok(lessonMapper.toResponse(lesson));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Long id) {
        lessonService.deleteCourse(id);

        return ResponseEntity.noContent().build();
    }
}
