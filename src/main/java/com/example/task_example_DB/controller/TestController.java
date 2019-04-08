package com.example.task_example_DB.controller;


import com.example.task_example_DB.dao.ExpenceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private ExpenceDAO expenceDAO;

    @RequestMapping("/da")
    public String index() {

        expenceDAO.test();

        return "DAO";
    }
}
