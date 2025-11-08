package com.learnsphere.learnsphere.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "certificates")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String certificateUrl;
    private Date issuedDate;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne
    @JoinColumn( name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn( name = "course_id")
    private Course course;
}
