package ua.training.bukivskii.controller;

import ua.training.bukivskii.model.data.Recipes;
import ua.training.bukivskii.model.services.sorting.SortingTypes;
import ua.training.bukivskii.viev.Messages;
import ua.training.bukivskii.viev.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Util {
    private Map<Integer, SortingTypes> sortingTypes = new HashMap<>();
    {
        sortingTypes.put(1,SortingTypes.BY_CALORIES);
        sortingTypes.put(2,SortingTypes.BY_COST);
        sortingTypes.put(3,SortingTypes.BY_NAME);
    }

    Recipes inputValidSaladName(Scanner scanner, View view){
        String buffer;
        view.printMessage(view.unwrapBundled(Messages.CHOOSE_SALAD_START));
        printSaladVariants(view);
        view.printMessage(view.unwrapBundled(Messages.CHOOSE_SALAD_END));
        while (! (scanner.hasNextLine()&&(buffer = scanner.nextLine().trim()).matches(Regexps.SALAD_REGEXP))){
            view.printMessage(view.unwrapBundled(Messages.BAD_SALAD_CHOICE));
            printSaladVariants(view);
            view.printMessage(view.unwrapBundled(Messages.CHOOSE_SALAD_END));
        }
        return Recipes.values()[Integer.parseInt(buffer)-1];
    }
    private void printSaladVariants(View view) {
        for(Recipes rec: Recipes.values()){
            view.printMessage(view.unwrapBundled(rec.getName()+" - "+(rec.ordinal()+1)));
        }
    }

    SortingTypes inputValidSortMethod(Scanner scanner, View view){
        String buffer;
        view.printMessage(view.unwrapBundled(Messages.CHOOSE_SORT));
        while (! (scanner.hasNextLine()&&(buffer = scanner.nextLine().trim()).matches(Regexps.SORT_REGEXP))){
            view.printMessage(view.unwrapBundled(Messages.BAD_SORT_CHOICE));
        }
        try {
            return (sortingTypes.get(Integer.parseInt(buffer)));
        }catch (NullPointerException npe){
            return SortingTypes.BY_CALORIES;
        }
    }

    Range inputValidCaloriesRange(Scanner scanner, View view){
        String buffer;
        view.printMessage(view.unwrapBundled(Messages.ENTER_CALORIES_RANGE));
        while (! (scanner.hasNextLine()&&(buffer = scanner.nextLine().trim()).matches(Regexps.CALORIES_RANGE_REGEXP))){
            view.printMessage(view.unwrapBundled(Messages.BAD_CALORIES_RANGE));
        }
        return new Range(Integer.parseInt(buffer.split("[ \\-]")[0]),Integer.parseInt(buffer.split("[ \\-]")[1]));
    }
}
