package com.example.task_example_DB.entity;



import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name = "expence")
public class Expence implements Serializable {
    @Id
    @SequenceGenerator(name = "expence_seq", sequenceName = "expence_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expence_seq")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "expence")
    @Column(name = "user_id")
    private List<User> users = new LinkedList<>();

    public Expence() {
    }

    public Expence(Category category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        String categoryName = "category: null \n";

        if (this.category != null) categoryName = this.category.getName() + " id = " + this.category.getId() + " \n";

        String userName = "user: null";
        if (!users.isEmpty()){
            StringBuilder stringBuilder = new StringBuilder();
            for (User value : users){
                stringBuilder.append(value.getName() + " id = " + value.getId() +  ", ");
            }
            userName = stringBuilder.toString().substring(0,stringBuilder.length()-2) + "\n";
        }
        return categoryName + userName;
    }
}
