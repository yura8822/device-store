package com.example.task_example_DB.controller;

import com.example.task_example_DB.entity.Category;
import com.example.task_example_DB.entity.Expence;
import com.example.task_example_DB.entity.User;
import com.example.task_example_DB.repo.CategoryRepository;
import com.example.task_example_DB.repo.ExpenceRepository;
import com.example.task_example_DB.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/expences")
public class ExpenceConroller {
    private ExpenceRepository expenceRepository;
    private UsersRepository usersRepository;
    private CategoryRepository categoryRepository;


    public ExpenceConroller(ExpenceRepository expenceRepository, UsersRepository usersRepository, CategoryRepository categoryRepository) {
        this.expenceRepository = expenceRepository;
        this.usersRepository = usersRepository;
        this.categoryRepository = categoryRepository;
    }

    @ResponseBody
    @GetMapping
    public List<Expence> getAllExpence(){
        List<Expence> expenceList = expenceRepository.findAll();
        return expenceList;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public Expence getExpenceById(@PathVariable(value = "id") Long id){
        Expence expence = expenceRepository.findExpenceById(id);
        return expence;
    }

    @ResponseBody
    @PostMapping(value = "/{id}")
    public Expence createExpence(@PathVariable(value = "id") Long id){
        User user = usersRepository.findUserById(id);
        Category category = categoryRepository.findCategoryById(id);
        Expence expence = new Expence(category, user);
        expenceRepository.save(expence);
        return expence;
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void deleteExpence(@PathVariable(value = "id") Long id) {
        expenceRepository.deleteById(id);
    }



}
