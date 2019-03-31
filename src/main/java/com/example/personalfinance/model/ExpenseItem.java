package com.example.personalfinance.model;

public class ExpenseItem {
    private static int increment = 0;
    private long id;
    private String typeConsumption;
    private int price;

    public ExpenseItem() {
    }

    public ExpenseItem(long id, String typeConsumption, int price) {
        this.typeConsumption = typeConsumption;
        this.price = price;
        this.id = id;
    }

    public ExpenseItem(String typeConsumption, int price) {
        this.typeConsumption = typeConsumption;
        this.price = price;
        increment++;
        this.id = increment;
    }

    public long getId() {
        return id;
    }

    public String getTypeConsumption() {
        return typeConsumption;
    }

    public void setTypeConsumption(String typeConsumption) {
        this.typeConsumption = typeConsumption;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
