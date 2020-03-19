package com.gluonapplication.properties;

public class Ingredient { // store ingredient info
    private String name;
    private Double cost;
    private Integer calories;
    private Integer amount;

    public Ingredient(String name, Double cost, Integer calories, Integer amount){
        this.name = name;
        this.cost = cost;
        this.calories = calories;
        this.amount = amount;
    }

    public String getName(){
        return name;
    }

    public Integer getAmount(){
        return amount;
    }

    public Double getCost(){
        return cost;
    }

    public Integer getCalories(){
        return calories;
    }

}
