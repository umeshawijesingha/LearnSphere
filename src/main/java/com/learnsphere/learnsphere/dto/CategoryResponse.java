package com.learnsphere.learnsphere.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CategoryResponse {
    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;
}
