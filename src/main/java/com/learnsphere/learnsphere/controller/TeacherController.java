package com.learnsphere.learnsphere.controller;

import com.learnsphere.learnsphere.dto.TeacherRequest;
import com.learnsphere.learnsphere.dto.TeacherResponse;
import com.learnsphere.learnsphere.entity.Teacher;
import com.learnsphere.learnsphere.mapper.TeacherMapper;
import com.learnsphere.learnsphere.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
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

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponse> getTeacherById(@PathVariable Long id){
        Teacher teacher = teacherService.getTeacherById(id);

        return ResponseEntity.ok(teacherMapper.toResponse(teacher));
    }

    @PostMapping
    public ResponseEntity<TeacherResponse> createTeacher(@RequestBody TeacherRequest request){
        Teacher teacher = teacherService.createTeacher(teacherMapper.toEntity(request));

        return ResponseEntity.ok(teacherMapper.toResponse(teacher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherResponse> updateTeacher(@PathVariable Long id, @RequestBody TeacherRequest request){
        Teacher teacher = teacherMapper.toEntity(request);
        teacher = teacherService.updateTeacher(id, teacher);

        return ResponseEntity.ok(teacherMapper.toResponse(teacher));
    }
}
