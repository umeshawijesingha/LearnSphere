package com.learnsphere.learnsphere.mapper;

import com.learnsphere.learnsphere.dto.CategoryRequest;
import com.learnsphere.learnsphere.dto.CategoryResponse;
import com.learnsphere.learnsphere.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements Mapper<Category, CategoryRequest, CategoryResponse>{

    @Override
    public Category toEntity(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        return  category;
    }

    @Override
    public CategoryResponse toResponse(Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        response.setDescription(category.getDescription());
        response.setCreatedAt(category.getCreatedAt());
        response.setUpdatedAt(category.getUpdatedAt());
        return  response;
    }
}
