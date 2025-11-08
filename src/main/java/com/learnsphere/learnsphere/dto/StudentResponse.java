package com.learnsphere.learnsphere.dto;

import com.learnsphere.learnsphere.enums.StudentStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StudentResponse {
    private Long id;
    private String keycloakUserId;
    private String firstname;
    private String lastName;
    private String email;
    private String address;
    private String city;
    private String school;
    private String contactNo;
    private String nicUrl;
    private String profileUrl;
    private Date dateOfBirth;
    private StudentStatus status;
    private Date createdAt;
    private Date updatedAt;
}
