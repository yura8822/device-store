package com.example.task_example_DB;

import com.example.task_example_DB.dao.ExpenceDAO;
import com.example.task_example_DB.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;

//@SpringBootApplication(scanBasePackages = "com.example.task_example_DB")
public class ExampleDB {

    public static void main(String[] args) {

        EntityManager em = HibernateUtil.getEntityManager();

        em.getTransaction().begin();

        User user = new User("name");

        em.persist(user);
        em.getTransaction().commit();

        User userFromDB = em.find(User.class, new Long(1));
        em.detach(userFromDB);

        System.out.println(userFromDB.getId());

    }

}
