package com.example.task_example_DB.dao.impl;

import com.example.task_example_DB.dao.CategryService;
import com.example.task_example_DB.entity.Category;
import com.example.task_example_DB.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryServiceImpl implements CategryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findCategoryById(id);
    }

    @Override
    public Category updateCategoryById(Long id, Category categoryUpdateDTO) {
        Category category = categoryRepository.findCategoryById(id);
        category.setName(categoryUpdateDTO.getName());
        categoryRepository.save(category);
        return category;
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category createCategory(Category categoryCreateDTO) {
        Category category = new Category(categoryCreateDTO.getName());
        categoryRepository.save(category);
        return category;
    }
}
