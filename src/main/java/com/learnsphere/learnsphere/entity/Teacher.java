package com.learnsphere.learnsphere.entity;

import com.learnsphere.learnsphere.enums.StudentStatus;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "teachers")
@EntityListeners(AuditingEntityListener.class)
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String keycloakUserId;
    private String firstName;
    private String LastName;

    @Column(unique = true)
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

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
