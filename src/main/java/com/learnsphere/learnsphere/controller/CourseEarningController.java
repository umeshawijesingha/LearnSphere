package com.learnsphere.learnsphere.controller;

import com.learnsphere.learnsphere.dto.CourseEarningRequest;
import com.learnsphere.learnsphere.dto.CourseEarningResponse;
import com.learnsphere.learnsphere.dto.CourseRequest;
import com.learnsphere.learnsphere.entity.CourseEarning;
import com.learnsphere.learnsphere.mapper.CourseEarningMapper;
import com.learnsphere.learnsphere.service.CourseEarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course-earnings")
public class CourseEarningController {

    @Autowired
    private CourseEarningService courseEarningService;

    @Autowired
    private CourseEarningMapper courseEarningMapper;

    @GetMapping
    public ResponseEntity<List<CourseEarningResponse>> getAllCourseEarning(){
        List<CourseEarning> courseEarningList = courseEarningService.getAllCourseEarning();

        List<CourseEarningResponse> responses = courseEarningList.stream()
                .map(courseEarning -> courseEarningMapper.toResponse(courseEarning)).toList();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseEarningResponse> getCourseEarningById(@PathVariable Long id){
        CourseEarning courseEarning = courseEarningService.getCourseById(id);

        return ResponseEntity.ok(courseEarningMapper.toResponse(courseEarning));
    }

    @PostMapping
    public ResponseEntity<CourseEarningResponse> createCourseEarning(@RequestBody CourseEarningRequest request){
        CourseEarning courseEarning = courseEarningMapper.toEntity(request);
        courseEarning = courseEarningService.createCourseEarning(courseEarning);

        return ResponseEntity.status(HttpStatus.CREATED).body(courseEarningMapper.toResponse(courseEarning));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseEarningResponse> updateCourseEarning(@PathVariable Long id, @RequestBody CourseEarningRequest request){
        CourseEarning courseEarning = courseEarningMapper.toEntity(request);
        courseEarning = courseEarningService.updateCourseEarning(id, courseEarning);

        return ResponseEntity.ok(courseEarningMapper.toResponse(courseEarning));
    }
}
