package com.example.task_example_DB.dao;

import com.example.task_example_DB.HibernateUtil;
import com.example.task_example_DB.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Component
public class ExpenceDAO {

    public void test() {
        EntityManager em = HibernateUtil.getEntityManager();

        em.getTransaction().begin();

        User user = new User("name");

        em.persist(user);
        em.getTransaction().commit();

//        session.save(user);
//
//        String queryString = "FROM User u WHERE u.name =\'name\'";
//        Query query = session.createQuery(queryString);
//        user = (User) query.getSingleResult();
//
//        System.out.println(user.getId());
//
//        Category category1 = new Category("category1");
//        session.save(category1);
//
//        String queryStringCategory1 = "FROM Category c WHERE c.name =\'category1\'";
//        Query queryCategory1 = session.createQuery(queryStringCategory1);
//        category1 = (Category) queryCategory1.getSingleResult();
//
//
//        Category category2 = new Category("category2");
//        session.save(category2);
//
//        String queryStringCategory2 = "FROM Category c WHERE c.name =\'category2\'";
//        Query queryCategory2 = session.createQuery(queryStringCategory2);
//        category2 = (Category) queryCategory2.getSingleResult();
//
//        Expence expence = new Expence(category1);
//        session.save(expence);
//
//        String queryStringExpence = "FROM Expence e WHERE e.category.id =\'" + category1.getId() + "\'";
//        Query queryExpence = session.createQuery(queryStringExpence);
//        expence = (Expence) queryExpence.getSingleResult();

//        user.setExpence(expence);
//        session.save(user);

//
//        tx.commit();
//
//        session.close();
    }
}
