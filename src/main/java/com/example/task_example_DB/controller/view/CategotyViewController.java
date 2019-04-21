package com.example.task_example_DB.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategotyViewController {

    @GetMapping("/category")
    public String categoryCRUD(){
        return "thymeleaf/category";
    }
}
