package com.learnsphere.learnsphere.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learnsphere.learnsphere.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {
    private String name;
    private String description;

    @JsonIgnore
    private Category category;
}
