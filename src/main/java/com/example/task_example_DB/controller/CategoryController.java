package com.example.task_example_DB.controller;

import com.example.task_example_DB.entity.Category;
import com.example.task_example_DB.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorys")
public class CategoryController {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @ResponseBody
    @GetMapping
    public List<Category> getAllCategory(){
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public Category getCategoryByID(@PathVariable(value = "id") Long id){
        Category category = categoryRepository.findCategoryById(id);
        return category;
    }

    @ResponseBody
    @PostMapping
    public Category createCategory(@RequestBody Category categoryCreateDTO){
        Category category = new Category();
        category.setName(categoryCreateDTO.getName());
        categoryRepository.save(category);
        return category;
    }

    @ResponseBody
    @PutMapping(value = "/{id}")
    public Category updateCategoryId(@PathVariable(value = "id") Long id, @RequestBody Category categoryUpdateDTO){
        Category category = categoryRepository.findCategoryById(id);
        category.setName(categoryUpdateDTO.getName());
        categoryRepository.save(category);
        return category;
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void deleteCategoryId(@PathVariable(value = "id") Long id){
        categoryRepository.deleteById(id);
    }


}
