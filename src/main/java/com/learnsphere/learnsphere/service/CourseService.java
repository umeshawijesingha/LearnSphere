package com.learnsphere.learnsphere.service;

import com.learnsphere.learnsphere.dto.CourseRequest;
import com.learnsphere.learnsphere.entity.Course;
import com.learnsphere.learnsphere.exception.ResourceNotFoundException;
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

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Course not found with id: "+id));
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course course) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Course not found with id: "+ id));

        //Update the fields
        existingCourse.setTitle(course.getTitle());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setSubCategory(course.getSubCategory());
        existingCourse.setPrice(course.getPrice());
        existingCourse.setDuration(course.getDuration());
        existingCourse.setThumbnail(course.getThumbnail());
        existingCourse.setLanguageType(course.getLanguageType());
        existingCourse.setLevel(course.getLevel());
        existingCourse.setStatus(course.getStatus());
        existingCourse.setUpdatedAt(course.getUpdatedAt());

        return courseRepository.save(existingCourse);

    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
