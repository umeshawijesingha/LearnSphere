package com.learnsphere.learnsphere.service;

import com.learnsphere.learnsphere.entity.Lesson;
import com.learnsphere.learnsphere.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons(){
        return lessonRepository.findAll();
    }
}
