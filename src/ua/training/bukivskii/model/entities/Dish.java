package ua.training.bukivskii.model.entities;

import java.util.ArrayList;

public interface Dish {
    void addIngredient(Saladable ingredient);

    ArrayList<Saladable> getIngredients();
    String getName();
    int getTotalCalories();
    int getTotalCost();
}
