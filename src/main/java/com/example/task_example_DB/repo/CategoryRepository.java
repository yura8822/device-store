package com.example.task_example_DB.repo;

import com.example.task_example_DB.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long > {
    Category findCategoryById(Long id);

}
