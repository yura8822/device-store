package com.example.task_example_DB;

import com.example.task_example_DB.dao.ExpenceDAO;
import com.example.task_example_DB.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.Query;

//@SpringBootApplication(scanBasePackages = "com.example.task_example_DB")
public class ExampleDB {

    public static void main(String[] args) {

//        EntityManager em = HibernateUtil.getEntityManager();
//
//        em.getTransaction().begin();
//
//        User user = new User("name");
//
//        em.persist(user);
//        em.getTransaction().commit();
//
//        User userFromDB = em.find(User.class, new Long(1));
//        em.detach(userFromDB);
//
//        System.out.println(userFromDB.getId());

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        User user = new User("name");
        session.save(user);

        tx.commit();

        tx.begin();

        String queryString = "FROM User u WHERE u.name =\'name\'";
        Query query = session.createQuery(queryString);
        user = (User) query.getSingleResult();

        tx.commit();
        session.close();

        System.out.println(user.getId());



    }

}
