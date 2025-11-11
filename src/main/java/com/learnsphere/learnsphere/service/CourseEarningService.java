package com.learnsphere.learnsphere.service;

import com.learnsphere.learnsphere.entity.CourseEarning;
import com.learnsphere.learnsphere.exception.ResourceNotFoundException;
import com.learnsphere.learnsphere.repository.CourseEarningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseEarningService {

    @Autowired
    private CourseEarningRepository courseEarningRepository;

    public List<CourseEarning> getAllCourseEarning(){
        return courseEarningRepository.findAll();
    }

    public CourseEarning getCourseById(Long id){
        return courseEarningRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course Earning not found with Id:" +id));
    }

    public CourseEarning createCourseEarning(CourseEarning courseEarning){
        return courseEarningRepository.save(courseEarning);
    }

    public CourseEarning updateCourseEarning(Long id, CourseEarning courseEarning){
        CourseEarning existingCourseEarning = courseEarningRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with Id:" +id));

        existingCourseEarning.setStatus(courseEarning.getStatus());
        existingCourseEarning.setAmount(courseEarning.getAmount());
        existingCourseEarning.setUpdatedAt(courseEarning.getUpdatedAt());

        return courseEarningRepository.save(courseEarning);
    }
}
