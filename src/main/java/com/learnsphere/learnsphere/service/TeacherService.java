package com.learnsphere.learnsphere.service;


import com.learnsphere.learnsphere.entity.Teacher;
import com.learnsphere.learnsphere.exception.ResourceNotFoundException;
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

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id:"+ id));
    }

    public Teacher createTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher teacher){
        Teacher existingTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id:" +id));

        //Update the fields
        existingTeacher.setFirstName(teacher.getFirstName());
        existingTeacher.setLastName(teacher.getLastName());
        existingTeacher.setEmail(teacher.getEmail());
        existingTeacher.setAddress(teacher.getAddress());
        existingTeacher.setCity(teacher.getCity());
        existingTeacher.setWorksAt(teacher.getWorksAt());
        existingTeacher.setQualifications(teacher.getQualifications());
        existingTeacher.setStatus(teacher.getStatus());
        existingTeacher.setNicUrl(teacher.getNicUrl());
        existingTeacher.setProfileUrl(teacher.getProfileUrl());
        existingTeacher.setUpdatedAt(teacher.getUpdatedAt());

        return teacherRepository.save(existingTeacher);
    }
}
