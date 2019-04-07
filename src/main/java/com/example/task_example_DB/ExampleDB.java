package com.example.task_example_DB;


import com.example.task_example_DB.entity.Category;
import com.example.task_example_DB.entity.Expence;
import com.example.task_example_DB.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;

import javax.persistence.Query;
import java.util.List;

//@SpringBootApplication(scanBasePackages = "com.example.task_example_DB")
public class ExampleDB {

    public static EntityManager entityManager = HibernateUtil.getEntityManager();

    public static void main(String[] args) {
        // SpringApplication.run(ExampleDB.class, args);

        create(new Category("category 1"), new User("name_1"),
                new User("name_2"), new User("name_3"));
        create(new Category("category 2"), new User("name_4"),
                new User("name_5"), new User("name_6"));
        create(new Category("category 3"), new User("name_7"),
                new User("name_8"), new User("name_9"));
        readAll();

        delete(2);
        readAll();

        updateCategory(3, "updateCategory_1");
        readAll();
    }

    public static void create(Category category, User ... users){
       entityManager.getTransaction().begin();
       entityManager.persist(category);
       Expence expence = new Expence();
        expence.setCategory(category);
        for(User user: users){
            entityManager.persist(user);
            expence.getUsers().add(user);
        }
        entityManager.persist(expence);
        entityManager.getTransaction().commit();

    }
    public static void updateCategory(long id, String nameCategory){
        Expence expence = entityManager.find(Expence.class, id);
        entityManager.getTransaction().begin();
        expence.getCategory().setName(nameCategory);
        entityManager.getTransaction().commit();
    }

    public static void delete(long id){
        entityManager.getTransaction().begin();
        Expence expence = entityManager.find(Expence.class, id);
        entityManager.remove(expence);
        entityManager.getTransaction().commit();
    }

    public static void readAll(){
        List<Expence> expenxeList = entityManager.createQuery("SELECT expence FROM Expence expence")
                .getResultList();
        if(!expenxeList.isEmpty()){
            for (Expence expence: expenxeList){
                System.out.println(expence);
            }
        }else System.out.println("Databases isEmpty");
    }
}
