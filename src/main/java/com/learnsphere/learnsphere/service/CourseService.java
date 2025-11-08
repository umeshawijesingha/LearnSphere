package com.learnsphere.learnsphere.service;

import com.learnsphere.learnsphere.entity.Course;
import com.learnsphere.learnsphere.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }
}
