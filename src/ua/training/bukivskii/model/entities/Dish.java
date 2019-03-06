package ua.training.bukivskii.model.entities;

import java.util.ArrayList;

public interface Dish {
    void addIngredient(Saladable ingredient);
    String getIngredientsSortedByCalories();
    String getIngredientsSortedByCost();
    String getIngredientsSortedByName();
    String getName();
    int getTotalCalories();
    int getTotalCost();
    String getIngredientsInCaloriesRange(int caloriesMin , int caloriesMax);
}
