package com.learnsphere.learnsphere.dto;

import com.learnsphere.learnsphere.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubCategoryRequest {

    private String name;
    private String description;
    private Category category;
}
