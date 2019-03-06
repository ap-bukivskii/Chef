package ua.training.bukivskii.model;

import ua.training.bukivskii.model.data.Recipes;
import ua.training.bukivskii.model.entities.Dish;
import ua.training.bukivskii.model.entities.Salad;
import ua.training.bukivskii.model.entities.Saladable;
import ua.training.bukivskii.viev.Messages;

public class Chef {

    public static Salad makeSalad (Recipes rec)throws NullPointerException{
        if(rec==null){throw new NullPointerException("NULL recipe!");}
        Salad salad = new Salad(rec.getName());
        for (Saladable ingredient:rec.getIngredients()){
            salad.addIngredient(ingredient);
        }
        return salad;
    }

    //TODO should there be one class for making and another for info?
    //TODO should there even be the CHEF class? we can do it in controller...

    public static String getSortedDishInfo(String sortType, Dish dish) throws IllegalArgumentException, NullPointerException{
        if(dish==null){throw new NullPointerException("NULL Dish!");}
        //TODO enum sorting types?
        StringBuilder res = new StringBuilder(Messages.START_DISH_INFO +"\n" + Messages.INGREDIENTS_HEADER+"\n");
        switch (sortType){
            case "byCalories":
                res.append(dish.getIngredientsSortedByCalories());
                break;
            case "byCost":
                res.append(dish.getIngredientsSortedByCost());
                break;
            case "byNames":
                res.append(dish.getIngredientsSortedByName());
                break;
            default:
                throw new IllegalArgumentException("Sorting type "+sortType+ " is not supported.");
        }
        res.append(Messages.END_DISH_INFO);
        return new String(res);
    }

    public static String getIngredientsInCaloriesRange(Dish dish, int minCalories, int maxCalories)throws NullPointerException{
        if(dish==null){throw new NullPointerException("NULL Dish!");}
        StringBuilder res = new StringBuilder(Messages.START_INGREDIENTS_IN_CALORIES_RANGE + "\n" + Messages.INGREDIENTS_HEADER+"\n");
        res.append(dish.getIngredientsInCaloriesRange(minCalories,maxCalories));
        res.append(Messages.END_INGREDIENTS_IN_CALORIES_RANGE);
        return new String(res);
    }

}
