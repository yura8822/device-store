package com.example.task_example_DB.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ExpenceDAO {

    private static SessionFactory sessionFactory = null;

    static {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = cfg.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
