package com.example.task_example_DB;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.persistence.EntityManager;



@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.example.task_example_DB")
public class ExampleDB {

    public static EntityManager entityManager = HibernateUtil.getEntityManager();

    public static void main(String[] args) {
         SpringApplication.run(ExampleDB.class, args);

    }
}
