package com.example.task_example_DB.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @SequenceGenerator(name = "category_seq", sequenceName = "category_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    private long id;

    @NotNull(message = "name of user can't be empty")
    @Column(name = "name", length = 256)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    @Column(name = "expence_id")
    private List<Expence> expences;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Expence> getExpences() {
        return expences;
    }

    public void setExpences(List<Expence> expences) {
        this.expences = expences;
    }
}

