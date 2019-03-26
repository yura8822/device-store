package com.example.devicestore.model;

import java.util.Date;

public class User {
    private long id;
    private String name;
    private String lastName;
    private Date dateBirth;

    public User(String name, String lastName, Date dateBirth) {
        this.name = name;
        this.lastName = lastName;
        this.dateBirth = dateBirth;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }
}
