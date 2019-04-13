package com.example.task_example_DB.dao;

import com.example.task_example_DB.dao.Interfacedao.CategryService;
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
    public List<Category> findAllCategry() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategryById(Long id) {
        return categoryRepository.findCategoryById(id);
    }

    @Override
    public Category updateCategryById(Long id, Category categoryUpdateDTO) {
        Category category = categoryRepository.findCategoryById(id);
        category.setName(categoryUpdateDTO.getName());
        categoryRepository.save(category);
        return category;
    }

    @Override
    public void deleteCategryrById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category createCategry(Category categoryCreateDTO) {
        Category category = new Category(categoryCreateDTO.getName());
        categoryRepository.save(category);
        return category;
    }
}
