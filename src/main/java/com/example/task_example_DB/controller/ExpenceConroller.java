package com.example.task_example_DB.controller;

import com.example.task_example_DB.entity.Expence;
import com.example.task_example_DB.repo.ExpenceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expences")
public class ExpenceConroller {
    private ExpenceRepository expenceRepository;

    public ExpenceConroller(ExpenceRepository expenceRepository) {
        this.expenceRepository = expenceRepository;
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
    @PostMapping
    public Expence createExpence(){
        Expence expence = new Expence();
        expenceRepository.save(expence);
        return expence;
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void deleteExpence(@PathVariable(value = "id") Long id) {
        expenceRepository.deleteById(id);
    }



}
