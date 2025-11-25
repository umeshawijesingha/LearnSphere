package com.learnsphere.learnsphere.dto;

import com.learnsphere.learnsphere.entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class SubCategoryResponse {

    private Long id;
    private String name;
    private String description;
    private Category category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
