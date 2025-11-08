package com.learnsphere.learnsphere.entity;

import com.learnsphere.learnsphere.enums.StudentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
