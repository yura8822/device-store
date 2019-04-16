package com.example.task_example_DB.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JSPExampleController {

//    @GetMapping("/hello")
//    public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
//        model.addAttribute("name", name);
//        return "hello";
//    }

    @GetMapping("/jsp")
    String jspPage(Model model, @RequestParam String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/thymeleaf")
    String thymeleafPage(Model model,@RequestParam String name) {
        model.addAttribute("name", name);
        return "thymeleaf/hello";
    }
}
