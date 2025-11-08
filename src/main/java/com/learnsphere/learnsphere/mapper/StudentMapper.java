package com.learnsphere.learnsphere.mapper;

import com.learnsphere.learnsphere.dto.StudentRequest;
import com.learnsphere.learnsphere.dto.StudentResponse;
import com.learnsphere.learnsphere.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements Mapper<Student, StudentRequest, StudentResponse>{
    @Override
    public Student toEntity(StudentRequest request) {
        Student student = new Student();
        student.setFirstname(request.getFirstname());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setContactNo(request.getContactNo());
        student.setAddress(request.getAddress());
        student.setCity(request.getCity());
        student.setSchool(request.getSchool());
        student.setDateOfBirth(request.getDateOfBirth());
        student.setStatus(request.getStatus());
        student.setProfileUrl(request.getProfileUrl());
        student.setNicUrl(request.getNicUrl());
        return student;
    }

    @Override
    public StudentResponse toResponse(Student student) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setFirstname(student.getFirstname());
        response.setLastName(student.getLastName());
        response.setEmail(student.getEmail());
        response.setContactNo(student.getContactNo());
        response.setAddress(student.getAddress());
        response.setCity(student.getCity());
        response.setSchool(student.getSchool());
        response.setDateOfBirth(student.getDateOfBirth());
        response.setStatus(student.getStatus());
        response.setProfileUrl(student.getProfileUrl());
        response.setNicUrl(student.getNicUrl());
        response.setCreatedAt(student.getCreatedAt());
        response.setUpdatedAt(student.getUpdatedAt());
        return response;
    }
}
