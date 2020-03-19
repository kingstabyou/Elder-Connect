package com.gluonapplication.lists;

import com.gluonapplication.properties.Ingredient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Ingredients {

    public static ObservableList ingredientsList = FXCollections.observableArrayList(
            new Ingredient("Egg",0.25,80,12),
            new Ingredient("Hot Dog",0.25,80,8),
            new Ingredient("Bread",0.25,80,2),
            new Ingredient("Cheese",0.25,80,12),
            new Ingredient("Cereal",0.25,80,8),
            new Ingredient("Spaghetti",0.25,80,2),
            new Ingredient("Udon",0.25,80,12),
            new Ingredient("Ramen",0.25,80,8),
            new Ingredient("Bun",0.25,80,2),
            new Ingredient("Dumpling",0.25,80,12),
            new Ingredient("Pizza",0.25,80,8),
            new Ingredient("Noodles",0.25,80,2)
    );

    ObservableList<String> names = FXCollections.observableArrayList();
}
