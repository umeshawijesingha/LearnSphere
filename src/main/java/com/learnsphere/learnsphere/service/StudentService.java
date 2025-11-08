package com.learnsphere.learnsphere.service;

import com.learnsphere.learnsphere.entity.Student;
import com.learnsphere.learnsphere.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
