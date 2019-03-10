package ua.training.bukivskii.model.entities;

import java.util.ArrayList;
import java.util.Objects;

public class Salad implements Dish {
    private ArrayList<Saladable> ingredients;
    private String name;
    private int totalCost;
    private int totalCalories;

    public Salad(String name){
        this.name = name;
        this.ingredients = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getTotalCalories() {
        return this.totalCalories;
    }

    @Override
    public int getTotalCost() {
        return this.totalCost;
    }

    @Override
    public ArrayList<Saladable> getIngredients() {
        return ingredients;
    }

    @Override
    public void addIngredient(Saladable ingredient) {
        Objects.requireNonNull(ingredient);
        this.ingredients.add(ingredient);
        this.totalCost+=ingredient.getCost();
        this.totalCalories+=ingredient.getCalories();
    } //TODO Salad`s method?
}
