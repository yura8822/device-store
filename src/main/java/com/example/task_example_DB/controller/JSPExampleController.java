package com.example.task_example_DB.controller;

import com.example.task_example_DB.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JSPExampleController {

    private long iterator = 0;

    @GetMapping("/jsp")  //http://localhost:8080/jsp?name=ajit
    String jspPage(Model model, @RequestParam String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/thymeleaf") //http://localhost:8080/thymeleaf?name=ajit
    String thymeleafPage(Model model,@RequestParam String name) {
        model.addAttribute("name", name);
        return "thymeleaf/hello";
    }

    @ResponseBody
    @GetMapping("/iter")
    public long getIterator() {
        iterator = iterator + 1;
        return iterator;
    }

    @GetMapping("/user")
    public String createUser(){
        return "thymeleaf/User";
    }
}
