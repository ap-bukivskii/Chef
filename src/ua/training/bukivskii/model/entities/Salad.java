package ua.training.bukivskii.model.entities;

import java.util.ArrayList;
import java.util.Comparator;

public class Salad implements Dish {
    private ArrayList<Saladable> ingredients;
    private String name;

    public Salad(String name){
        this.name = name;
        this.ingredients = new ArrayList<>();
    }

    //TODO where to sort and stuff?
    @Override
    public String getIngredientsSortedByCalories() {
        StringBuilder result = new StringBuilder();
        ingredients.stream().
                sorted(Comparator.comparingInt(Saladable::getCalories)).
                map(Saladable::toStringForUser). //TODO is it OK to owerride tostring as we want?
                forEach(result::append);
        return new String(result);
    }

    @Override
    public String getIngredientsSortedByCost() {
        StringBuilder result = new StringBuilder();
        ingredients.stream().
                sorted(Comparator.comparingInt(Saladable::getCost)).
                map(Saladable::toStringForUser). //TODO fix duplicate code
                forEach(result::append);
        return new String(result);
    }

    @Override
    public String getIngredientsSortedByName() {
        StringBuilder result = new StringBuilder();
        ingredients.stream().
                sorted(Comparator.comparing(Saladable::getName)).
                map(Saladable::toStringForUser).
                forEach(result::append);
        return new String(result);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getTotalCalories() {
        return ingredients.stream().mapToInt(Saladable::getCalories).sum();
    }

    @Override
    public int getTotalCost() {
        return ingredients.stream().mapToInt(Saladable::getCost).sum();
    }

    @Override
    public String getIngredientsInCaloriesRange(final int caloriesMin, final int caloriesMax) {
        StringBuilder result = new StringBuilder();
        ingredients.stream().
                filter(i-> (i.getCalories() > caloriesMin) && (i.getCalories() < caloriesMax)).
                map(Saladable::toStringForUser).
                forEach(result::append);
        return new String(result);
    }

    @Override
    public void addIngredient(Saladable ingredient) {
        this.ingredients.add(ingredient);
    }
}
