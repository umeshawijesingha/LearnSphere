package com.learnsphere.learnsphere.entity;

import com.learnsphere.learnsphere.enums.StudentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

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

    @Column(unique = true)
    private String email;

    private String address;
    private String city;
    private String school;
    private String contactNo;
    private String nicUrl;
    private String profileUrl;
    private Date dateOfBirth;
    private StudentStatus status;

    @OneToMany(mappedBy = "id")
    private List<Enrollment> enrollments;

    private SubCategory category;
    private Date createdAt;
    private Date updatedAt;
}
