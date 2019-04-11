package com.example.task_example_DB;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.example.task_example_DB");

    static {
        try {
            StandardServiceRegistry standardServiceRegistry =
                    new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
                            .build();
            sessionFactory = new MetadataSources(standardServiceRegistry).getMetadataBuilder()
                    .build().getSessionFactoryBuilder().build();
        } catch (Throwable th) {

            System.err.println("Enitial SessionFactory creation failed" + th);
            throw new ExceptionInInitializerError(th);

        }
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static SessionFactory getSessionFactory() {

        return sessionFactory;

    }
}
