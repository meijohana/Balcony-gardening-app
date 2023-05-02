package com.example.module_part3;

public class PlantData {
    private String name;
    private String state;
    private String water;

    public PlantData(String name, String state, String water) {
        this.name = name;
        this.state = state;
        this.water = water;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getWater() {
        return water;
    }
}
