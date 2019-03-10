package ua.training.bukivskii.model.services.sorting;

import ua.training.bukivskii.model.entities.Dish;
import ua.training.bukivskii.model.entities.Saladable;

import java.util.Comparator;

public class SortByName implements Sort{
    @Override
    public String execute(Dish dish) {
        StringBuilder result = new StringBuilder();
        dish.getIngredients().stream().
                sorted(Comparator.comparing(Saladable::getName)).
                map(Saladable::toStringForUser).
                forEach(result::append);
        return new String(result);    }
}