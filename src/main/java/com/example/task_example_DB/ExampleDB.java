package com.example.task_example_DB;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.task_example_DB")
public class ExampleDB {

    public static void main(String[] args) {
        SpringApplication.run(com.example.task_example_DB.ExampleDB.class, args);
    }

}
