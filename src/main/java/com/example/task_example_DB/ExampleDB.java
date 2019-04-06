package com.example.task_example_DB;


import com.example.task_example_DB.entity.Category;
import com.example.task_example_DB.entity.Expence;
import com.example.task_example_DB.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Query;

//@SpringBootApplication(scanBasePackages = "com.example.task_example_DB")
public class ExampleDB {

    public static void main(String[] args) {

// SpringApplication.run(ExampleDB.class, args);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        User user = new User("name");
        session.save(user);

        String queryString = "FROM User u WHERE u.name =\'name\'";
        Query query = session.createQuery(queryString);
        user = (User) query.getSingleResult();

        Category category1 = new Category("category1");
        session.save(category1);

        String queryStringCategory1 = "FROM Category c WHERE c.name =\'category1\'";
        Query queryCategory1 = session.createQuery(queryStringCategory1);
        category1 = (Category) queryCategory1.getSingleResult();


        Category category2 = new Category("category2");
        session.save(category2);

        String queryStringCategory2 = "FROM Category c WHERE c.name =\'category2\'";
        Query queryCategory2 = session.createQuery(queryStringCategory2);
        category2 = (Category) queryCategory2.getSingleResult();

        Expence expence = new Expence(category1);
        session.save(expence);

        String queryStringExpence = "FROM Expence e WHERE e.category.id =\'" + category1.getId() + "\'";
        Query queryExpence = session.createQuery(queryStringExpence);
        expence = (Expence) queryExpence.getSingleResult();

        user.setExpence(expence);
        session.save(user);


        tx.commit();

        session.close();




    }

}
