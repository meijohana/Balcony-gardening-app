package com.example.module_part3;

public class PlantData {
    private String name;
    private String state;
    private String price;

    public PlantData(String name, String state, String price) {
        this.name = name;
        this.state = state;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getPrice() {
        return price;
    }
}
