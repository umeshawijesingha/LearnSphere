package com.learnsphere.learnsphere.controller;

import com.learnsphere.learnsphere.dto.TeacherResponse;
import com.learnsphere.learnsphere.entity.Teacher;
import com.learnsphere.learnsphere.mapper.TeacherMapper;
import com.learnsphere.learnsphere.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherMapper teacherMapper;

    @GetMapping
    public ResponseEntity<List<TeacherResponse>> getAllTeachers(){
        List<Teacher> teachers = teacherService.getAllTeachers();

        List<TeacherResponse> responses = teachers.stream()
                .map(teacherMapper::toResponse)
                .toList();

        return ResponseEntity.status(HttpStatus.CREATED).body(responses);
    }
}
