package com.learnsphere.learnsphere.dto;

import com.learnsphere.learnsphere.enums.StudentStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TeacherRequest {

    private String firstName;
    private String LastName;
    private String email;
    private String contactNo;
    private String address;
    private String city;
    private String nicUrl;
    private String profileUrl;
    private String worksAt;
    private String workAddress;
    private String qualifications;
    private StudentStatus status;
    private Date dateOfBirth;
}
