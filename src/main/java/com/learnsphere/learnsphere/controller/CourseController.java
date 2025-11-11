package com.learnsphere.learnsphere.controller;

import com.learnsphere.learnsphere.dto.CourseRequest;
import com.learnsphere.learnsphere.dto.CourseResponse;
import com.learnsphere.learnsphere.entity.Course;
import com.learnsphere.learnsphere.mapper.CourseMapper;
import com.learnsphere.learnsphere.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseMapper courseMapper;

    // ========================
    // Public (view-only)
    // ========================
    @GetMapping
    public ResponseEntity<List<CourseResponse>> getAllCourses(){
        List<Course> courses = courseService.getAllCourses();
        List<CourseResponse> responses = courses.stream().
                map(courseMapper::toResponse).toList();

        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable Long id){
        Course course = courseService.getCourseById(id);

        return ResponseEntity.ok(courseMapper.toResponse(course));
    }

    // ========================
    // Teacher-only (modify)
    // ========================
    @PostMapping
    public ResponseEntity<CourseResponse> createCourse(@RequestBody CourseRequest request){
        Course course = courseMapper.toEntity(request);
        course = courseService.createCourse(course);

        return ResponseEntity.status(HttpStatus.CREATED).body(courseMapper.toResponse(course));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseResponse> updateCourse(@PathVariable Long id, @RequestBody CourseRequest request ){
        Course course = courseMapper.toEntity(request);
        course = courseService.updateCourse(id, course);

        return ResponseEntity.ok(courseMapper.toResponse(course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);

        return ResponseEntity.noContent().build();
    }
}
