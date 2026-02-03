package com.learnsphere.learnsphere.service;

import com.learnsphere.learnsphere.entity.Category;
import com.learnsphere.learnsphere.entity.SubCategory;
import com.learnsphere.learnsphere.exception.ResourceNotFoundException;
import com.learnsphere.learnsphere.repository.CategoryRepository;
import com.learnsphere.learnsphere.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    public Category updateCategory(Long id, Category category) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id:" + id));
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());

        return categoryRepository.save(existingCategory);
    }

    public void deleteCategory(Long id) {
        subCategoryRepository.deleteById(id);
    }

    public SubCategory createSubCategory(SubCategory subCategory) {
        Long categoryId = subCategory.getCategory().getId();
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        SubCategory sub = new SubCategory();
        sub.setName(subCategory.getName());
        sub.setDescription(subCategory.getDescription());
        sub.setCategory(category);
        return subCategoryRepository.save(sub);
    }

    public SubCategory updateSubCategory(Long id, SubCategory subCategory) {
        SubCategory existingSubCategory = subCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(" SubCategory not found with id: " +id));

        existingSubCategory.setName(subCategory.getName());
        existingSubCategory.setDescription(subCategory.getDescription());
        existingSubCategory.setCategory(subCategory.getCategory());

        return subCategoryRepository.save(existingSubCategory);
    }

    public void deleteSubCategory(Long id) {
        subCategoryRepository.deleteById(id);
    }
}
