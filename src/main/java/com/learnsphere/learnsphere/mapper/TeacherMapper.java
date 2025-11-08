package com.learnsphere.learnsphere.mapper;

import com.learnsphere.learnsphere.dto.TeacherRequest;
import com.learnsphere.learnsphere.dto.TeacherResponse;
import com.learnsphere.learnsphere.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper implements Mapper <Teacher, TeacherRequest, TeacherResponse>{

    @Override
    public Teacher toEntity(TeacherRequest request){
        Teacher teacher = new Teacher();
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setEmail(request.getEmail());
        teacher.setContactNo(request.getContactNo());
        teacher.setAddress(request.getAddress());
        teacher.setCity(request.getCity());
        teacher.setNicUrl(request.getNicUrl());
        teacher.setProfileUrl(request.getProfileUrl());
        teacher.setQualifications(request.getQualifications());
        teacher.setWorksAt(request.getWorksAt());
        request.setWorkAddress(request.getWorkAddress());
        request.setStatus(request.getStatus());
        request.setDateOfBirth(request.getDateOfBirth());
        return teacher;
    }

    @Override
    public TeacherResponse toResponse(Teacher teacher){
        TeacherResponse response = new TeacherResponse();
        response.setFirstName(teacher.getFirstName());
        response.setLastName(teacher.getLastName());
        response.setEmail(teacher.getEmail());
        response.setContactNo(teacher.getContactNo());
        response.setAddress(teacher.getAddress());
        response.setCity(teacher.getCity());
        response.setNicUrl(teacher.getNicUrl());
        response.setProfileUrl(teacher.getProfileUrl());
        response.setQualifications(teacher.getQualifications());
        response.setWorksAt(teacher.getWorksAt());
        response.setAddress(teacher.getWorkAddress());
        response.setStatus(teacher.getStatus());
        response.setDateOfBirth(teacher.getDateOfBirth());
        response.setCreatedAt(teacher.getCreatedAt());
        response.setUpdatedAt(teacher.getUpdatedAt());
        return response;
    }


}
