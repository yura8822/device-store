package com.example.task_example_DB.controller.api;

import com.example.task_example_DB.dao.impl.CategoryServiceImpl;
import com.example.task_example_DB.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    private CategoryServiceImpl categoryService;

    @Autowired
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @ResponseBody
    @GetMapping
    public List<Category> getAllCategory() {
        return categoryService.findAllCategory();
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public Category getCategoryByID(@PathVariable(value = "id") Long id) {
        return categoryService.findCategoryById(id);
    }

    @ResponseBody
    @PostMapping
    public Category createCategory(@RequestBody Category categoryCreateDTO) {
        return categoryService.createCategory(categoryCreateDTO);
    }

    @ResponseBody
    @PutMapping(value = "/{id}")
    public Category updateCategoryId(@PathVariable(value = "id") Long id, @RequestBody Category categoryUpdateDTO) {
        return categoryService.updateCategoryById(id, categoryUpdateDTO);
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void deleteCategoryId(@PathVariable(value = "id") Long id) {
        categoryService.deleteCategoryById(id);
    }


}
