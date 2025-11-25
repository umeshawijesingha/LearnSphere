package com.learnsphere.learnsphere.mapper;

import com.learnsphere.learnsphere.dto.SubCategoryRequest;
import com.learnsphere.learnsphere.dto.SubCategoryResponse;
import com.learnsphere.learnsphere.entity.SubCategory;
import org.springframework.stereotype.Component;

@Component
public class SubCategoryMapper implements Mapper<SubCategory, SubCategoryRequest, SubCategoryResponse>{
    @Override
    public SubCategory toEntity(SubCategoryRequest request) {
       SubCategory subCategory = new SubCategory();
       subCategory.setName(request.getName());
       subCategory.setDescription(request.getDescription());
       subCategory.setCategory(request.getCategory());
       return subCategory;
    }

    @Override
    public SubCategoryResponse toResponse(SubCategory subCategory) {
        SubCategoryResponse response = new SubCategoryResponse();
        response.setId(subCategory.getId());
        response.setName(subCategory.getName());
        response.setDescription(subCategory.getDescription());
        response.setCategory(subCategory.getCategory());
        response.setCreatedAt(subCategory.getCreatedAt());
        response.setUpdatedAt(subCategory.getUpdatedAt());
        return response;
    }
}

