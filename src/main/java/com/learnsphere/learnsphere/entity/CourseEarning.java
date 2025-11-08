package com.learnsphere.learnsphere.entity;

import com.learnsphere.learnsphere.enums.TeacherEarningStatus;
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
@Table(name = "course_earnings")
public class CourseEarning {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String amount;
    private TeacherEarningStatus status;
    private Date paidOutAt;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne
    @JoinColumn( name = "course_id")
    private Course course;



}
