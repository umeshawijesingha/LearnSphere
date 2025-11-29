package com.learnsphere.learnsphere.mapper;

import com.learnsphere.learnsphere.dto.SimpleStudentResponse;
import com.learnsphere.learnsphere.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class SimpleStudentMapper {
    public SimpleStudentResponse toSimpleResponse(Student student){
        SimpleStudentResponse response = new SimpleStudentResponse();
        response.setId(student.getId());
        response.setFirstname(student.getFirstname());
        response.setLastName(student.getLastName());
        response.setEmail(student.getEmail());
        return response;
    }
}
