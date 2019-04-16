package com.example.task_example_DB.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JSPExampleController {

    private long iterator = 0;

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

    @ResponseBody
    @GetMapping("/iter")
    public long getIterator() {
        iterator = iterator + 1;
        return iterator;
    }
}
