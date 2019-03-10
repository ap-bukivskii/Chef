package ua.training.bukivskii.model;

import ua.training.bukivskii.controller.Range;
import ua.training.bukivskii.model.data.Recipes;
import ua.training.bukivskii.model.entities.Dish;
import ua.training.bukivskii.model.entities.Salad;
import ua.training.bukivskii.model.services.GetIngredientsInCaloriesRange;
import ua.training.bukivskii.model.services.sorting.SortIngredients;
import ua.training.bukivskii.model.services.sorting.SortingTypes;
import ua.training.bukivskii.viev.Messages;

import java.util.Arrays;
import java.util.Objects;

public class Chef {

    public Salad makeSalad (Recipes rec)throws NullPointerException{
        Objects.requireNonNull(rec,"NULL recipe!");
        Salad salad = new Salad(rec.getName());
        Arrays.stream(rec.getIngredients()).
                forEach(salad::addIngredient);
        return salad;
    }

    public String getSortedDishInfo(SortingTypes sortType, Dish dish) throws IllegalArgumentException, NullPointerException{
        Objects.requireNonNull(dish,"NULL Dish!");
        StringBuilder res = new StringBuilder(Messages.START_DISH_INFO +"\n" + Messages.INGREDIENTS_HEADER+"\n");
        try{
            res.append(SortIngredients.getInstance().getAction(sortType).execute(dish));
        }catch (NullPointerException npe){
            throw new IllegalArgumentException("Sorting type "+sortType+ " is not supported.");
        }
        res.append(Messages.END_DISH_INFO);
        return new String(res);
    }

    public String getIngredientsInCaloriesRange(Dish dish, Range range)throws NullPointerException{
        Objects.requireNonNull(dish,"NULL Dish!");
        StringBuilder res = new StringBuilder(Messages.START_INGREDIENTS_IN_CALORIES_RANGE + "\n" + Messages.INGREDIENTS_HEADER+"\n");
        res.append(new GetIngredientsInCaloriesRange().getIngredientsInCaloriesRange(range.getStart(), range.getEnd(), dish));
        res.append(Messages.END_INGREDIENTS_IN_CALORIES_RANGE);
        return new String(res);
    }

}
