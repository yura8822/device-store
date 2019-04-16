package com.example.task_example_DB.dao.Interfacedao;

import com.example.task_example_DB.entity.Category;

import java.util.List;

public interface CategryService {
    List<Category> findAllCategry();

    Category findCategryById(Long id);

    Category updateCategryById(Long id, Category categoryUpdateDTO);

    void deleteCategryrById(Long id);

    Category createCategry(Category categoryCreateDTO);
}
