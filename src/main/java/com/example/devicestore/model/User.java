package com.example.devicestore.model;

import java.util.Date;

public class User {
    private static long inkrement;
    private long id;
    private String name;
    private String lastName;


    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        inkrement++;
        this.id = inkrement;
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

}
