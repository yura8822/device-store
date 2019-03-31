package com.example.devicestore.model;

public class ItemExpenditure {
    private static int increment=0;
    private long id;
    private String typeConsumption;
    private int price;

    public ItemExpenditure(){

    }

    public ItemExpenditure(String typeConsumption, int price) {
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
