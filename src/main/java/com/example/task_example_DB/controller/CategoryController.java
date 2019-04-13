package com.example.task_example_DB.controller;

import com.example.task_example_DB.dao.CategoryServiceImpl;
import com.example.task_example_DB.entity.Category;
import com.example.task_example_DB.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryServiceImpl categoryService;

    @Autowired
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @ResponseBody
    @GetMapping
    public List<Category> getAllCategory() {
        return categoryService.findAllCategry();
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public Category getCategoryByID(@PathVariable(value = "id") Long id) {
        return categoryService.findCategryById(id);
    }

    @ResponseBody
    @PostMapping
    public Category createCategory(@RequestBody Category categoryCreateDTO) {
        return categoryService.createCategry(categoryCreateDTO);
    }

    @ResponseBody
    @PutMapping(value = "/{id}")
    public Category updateCategoryId(@PathVariable(value = "id") Long id, @RequestBody Category categoryUpdateDTO) {
        return categoryService.updateCategryById(id,categoryUpdateDTO);
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void deleteCategoryId(@PathVariable(value = "id") Long id) {
        categoryService.deleteCategryrById(id);
    }


}
