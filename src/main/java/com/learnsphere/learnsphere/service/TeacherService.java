package com.learnsphere.learnsphere.service;


import com.learnsphere.learnsphere.entity.Teacher;
import com.learnsphere.learnsphere.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }
}
