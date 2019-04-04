package com.example.task_example_DB.controller;


import com.example.task_example_DB.dao.ExpenceDAO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/DA")
    public String index() {
        ExpenceDAO.Test();
        return "DAO";
    }
}
