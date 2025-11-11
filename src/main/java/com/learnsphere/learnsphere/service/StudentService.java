package com.learnsphere.learnsphere.service;

import com.learnsphere.learnsphere.entity.Student;
import com.learnsphere.learnsphere.exception.ResourceNotFoundException;
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

    public Student getStudentByID(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id:" +id));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id:" +id));

        existingStudent.setFirstname(student.getFirstname());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setContactNo(student.getContactNo());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setCity(student.getCity());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setNicUrl(student.getNicUrl());
        existingStudent.setProfileUrl(student.getProfileUrl());
        existingStudent.setDateOfBirth(student.getDateOfBirth());
        existingStudent.setStatus(student.getStatus());
        existingStudent.setUpdatedAt(student.getUpdatedAt());

        return studentRepository.save(existingStudent);
    }
}
