package com.example.task_example_DB.controller;

import com.example.task_example_DB.dao.ExpenceServiceImpl;
import com.example.task_example_DB.entity.Category;
import com.example.task_example_DB.entity.Expence;
import com.example.task_example_DB.entity.User;
import com.example.task_example_DB.repo.CategoryRepository;
import com.example.task_example_DB.repo.ExpenceRepository;
import com.example.task_example_DB.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/expences")
public class ExpenceConroller {
    private ExpenceServiceImpl expenceService;

    @Autowired
    public ExpenceConroller(ExpenceServiceImpl expenceService) {
        this.expenceService = expenceService;
    }

    @ResponseBody
    @GetMapping
    public List<Expence> getAllExpence(){
        return expenceService.findAllExpence();
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public Expence getExpenceById(@PathVariable(value = "id") Long id){
        return expenceService.findExpenceById(id);
    }

    @ResponseBody
    @GetMapping(value = "amount/{amount}")
    public List<Expence> getExpenceAmountSort(@PathVariable(value = "amount") BigDecimal amount){
        return expenceService.findAllExpenceBySort(amount);
    }

    @ResponseBody
    @PostMapping(value = "/{id}/{amount}")
    public Expence createExpence(@PathVariable(value = "id") Long id, @PathVariable(value = "amount") BigDecimal amount){
        return expenceService.createExpence(id, amount);
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void deleteExpence(@PathVariable(value = "id") Long id) {
        expenceService.deleteExpenceById(id);
    }

}
