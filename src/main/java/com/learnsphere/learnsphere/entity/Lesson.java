package com.learnsphere.learnsphere.entity;

import com.learnsphere.learnsphere.enums.LessonContentType;
import com.learnsphere.learnsphere.enums.LessonStatus;
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
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int orderIndex;
    private String title;
    private String description;
    private LessonContentType contentType;
    private LessonStatus status;
    private String contentUrl;
    private Double duration;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
