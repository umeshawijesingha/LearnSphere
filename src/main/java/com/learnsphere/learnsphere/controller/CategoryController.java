package com.learnsphere.learnsphere.controller;

import com.learnsphere.learnsphere.dto.*;
import com.learnsphere.learnsphere.entity.Category;
import com.learnsphere.learnsphere.entity.SubCategory;
import com.learnsphere.learnsphere.mapper.CategoryMapper;
import com.learnsphere.learnsphere.mapper.SubCategoryMapper;
import com.learnsphere.learnsphere.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private SubCategoryMapper subCategoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        List<CategoryResponse> response = categories.stream().map(categoryMapper::toResponse).toList();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest request) {
        Category category = categoryMapper.toEntity(request);
        category = categoryService.createCategory(category);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoryMapper.toResponse(category));
    }

    @PutMapping
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable Long id, @RequestBody CategoryRequest request){
        Category category = categoryMapper.toEntity(request);
        category = categoryService.updateCategory(id, category);

        return ResponseEntity.ok(categoryMapper.toResponse(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sub-categories")
    public ResponseEntity<List<SubCategoryResponse>> getAllSubCategories(){
        List<SubCategory> subCategories = categoryService.getAllSubCategories();
        List<SubCategoryResponse> response = subCategories.stream().map(subCategoryMapper::toResponse).toList();

        return ResponseEntity.ok(response);
    }

    @PostMapping("/sub-categories")
    public ResponseEntity<SubCategoryResponse> createSubCategory(@RequestBody SubCategoryRequest request){
        SubCategory subCategory = subCategoryMapper.toEntity(request);
        subCategory = categoryService.createSubCategory(subCategory);

        return ResponseEntity.status(HttpStatus.CREATED).body(subCategoryMapper.toResponse(subCategory));
    }

    @PutMapping("/sub-categories")
    public ResponseEntity<SubCategoryResponse> updateSubCategory(@PathVariable Long id, @RequestBody SubCategoryRequest request){
        SubCategory subCategory = subCategoryMapper.toEntity(request);
        subCategory = categoryService.updateSubCategory(id, subCategory);

        return ResponseEntity.ok(subCategoryMapper.toResponse(subCategory));
    }

    @DeleteMapping("sub-categories/{id}")
    ResponseEntity<Void> deleteSubCategory(@PathVariable Long id){
        categoryService.deleteSubCategory(id);

        return ResponseEntity.noContent().build();
    }
}
