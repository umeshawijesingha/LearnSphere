package com.learnsphere.learnsphere.dto;

import com.learnsphere.learnsphere.entity.Course;
import com.learnsphere.learnsphere.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CertificateResponse {
    private Long id;
    private String certificateUrl;
    private Date issuedDate;
    private Student student;
    private Course course;
    private Date createdAt;
    private Date updatedAt;
}
