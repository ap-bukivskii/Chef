package ua.training.bukivskii.model.services;

import ua.training.bukivskii.model.entities.Dish;
import ua.training.bukivskii.model.entities.Saladable;

public class GetIngredientsInCaloriesRange {

    public String getIngredientsInCaloriesRange(final int caloriesMin, final int caloriesMax, Dish dish) {
        StringBuilder result = new StringBuilder();
        dish.getIngredients().stream().
                filter(i-> (i.getCalories() > caloriesMin) && (i.getCalories() < caloriesMax)).
                map(Saladable::toStringForUser).
                forEach(result::append);
        return new String(result);
    }
}
