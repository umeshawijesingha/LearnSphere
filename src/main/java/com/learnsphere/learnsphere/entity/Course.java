package com.learnsphere.learnsphere.entity;

import com.learnsphere.learnsphere.enums.CourseLanguageType;
import com.learnsphere.learnsphere.enums.CourseLevel;
import com.learnsphere.learnsphere.enums.CourseStatus;
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
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String thumbnail;
    private Double price;
    private CourseLanguageType languageType;
    private CourseLevel level;
    private CourseStatus status;
    private Double duration;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;
}
