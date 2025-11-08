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
@Table(name = "sub_categories")
public class SubCategory {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
