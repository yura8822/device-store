package com.example.task_example_DB.dao;

import com.example.task_example_DB.entity.Category;

import java.util.List;

public interface CategryService {
    List<Category> findAllCategory();

    Category findCategoryById(Long id);

    Category updateCategoryById(Long id, Category categoryUpdateDTO);

    void deleteCategoryById(Long id);

    Category createCategory(Category categoryCreateDTO);
}
