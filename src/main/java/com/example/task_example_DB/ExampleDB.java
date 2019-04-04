package com.example.task_example_DB;

import com.example.task_example_DB.dao.ExpenceDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.support.GenericXmlApplicationContext;

@SpringBootApplication(scanBasePackages = "com.example.task_example_DB")
public class ExampleDB {

    public static void main(String[] args) {
        SpringApplication.run(com.example.task_example_DB.ExampleDB.class, args);

        SessionFactory sessionFactory = ExpenceDAO.getSessionFactory();
        Session session = sessionFactory.openSession();


    }

}
