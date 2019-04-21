package com.example.task_example_DB.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExpenseViewController {

    @GetMapping("/expense")
    public String expenseCRUD(){
        return "thymeleaf/expense";
    }
}
