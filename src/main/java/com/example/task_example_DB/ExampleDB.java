package com.example.task_example_DB;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.example.task_example_DB")
public class ExampleDB extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ExampleDB.class, args);

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ExampleDB.class);
    }
}
