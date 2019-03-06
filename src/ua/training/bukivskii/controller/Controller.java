package ua.training.bukivskii.controller;


import ua.training.bukivskii.model.Chef;
import ua.training.bukivskii.model.data.Recipes;
import ua.training.bukivskii.model.entities.Salad;
import ua.training.bukivskii.viev.Messages;
import ua.training.bukivskii.viev.View;

import java.util.Scanner;

public class Controller {
    private View view = new View();
    private Scanner scanner = new Scanner(System.in);

    public void processUser() { //access point
        Salad salad = Chef.makeSalad(inputValidSaladName(scanner));
        //ask user what salad is wanted. Make wanted salad

        view.printMessage(String.format(view.unwrapBundled(Messages.SALAD_MADE),view.unwrapBundled(salad.getName()),salad.getTotalCalories(),salad.getTotalCost()));
        //Total calories and cost

        view.printMessage(view.unwrapBundled(Chef.getSortedDishInfo(inputValidSortMethod(),salad)));
        //ask how to sort ingredients. print sorted in the way user wants

        //TODO class for range?
        int[] caloriesRange = inputValidCaloriesRange();
        view.printMessage(view.unwrapBundled(Messages.VEGETABLES_IN_CALORIES_RANGE));
        view.printMessage(view.unwrapBundled(Chef.getIngredientsInCaloriesRange(salad, caloriesRange[0], caloriesRange[1])));
        //ask for calories range and print filtered
    }

    private Recipes inputValidSaladName(Scanner scanner){
        String res;
        view.printMessage(view.unwrapBundled(Messages.CHOOSE_SALAD_START));
        for(Recipes rec: Recipes.values()){
            view.printMessage(view.unwrapBundled(rec.getName()+" - "+(rec.ordinal()+1)));
        }
        view.printMessage(view.unwrapBundled(Messages.CHOOSE_SALAD_END));
        while (! (scanner.hasNextLine()&&(res = scanner.nextLine().trim()).matches(Regexps.SALAD_REGEXP))){
            view.printMessage(Messages.BAD_SALAD_CHOICE);
            for(Recipes rec: Recipes.values()){
                view.printMessage(view.unwrapBundled(rec.getName()+" - "+(rec.ordinal()+1)));
            }
            view.printMessage(view.unwrapBundled(Messages.CHOOSE_SALAD_END));
        }
        return Recipes.values()[Integer.parseInt(res)-1];
    }

    private String inputValidSortMethod(){
        String res;
        view.printMessage(view.unwrapBundled(Messages.CHOOSE_SORT));
        while (! (scanner.hasNextLine()&&(res = scanner.nextLine().trim()).matches(Regexps.SORT_REGEXP))){
            view.printMessage(view.unwrapBundled(Messages.BAD_SORT_CHOICE));
        }
        switch (Integer.parseInt(res)){
            case 1:
                return "byCalories";
            case 2:
                return "byCost";
            case 3:
                return "byNames";
        }
        return "sortMethod";
    }

    private int [] inputValidCaloriesRange(){
        String buffer;
        int[] result = {0,0};
        view.printMessage(view.unwrapBundled(Messages.ENTER_CALORIES_RANGE));
        while (! (scanner.hasNextLine()&&(buffer = scanner.nextLine().trim()).matches(Regexps.CALORIES_RANGE_REGEXP))){
            view.printMessage(view.unwrapBundled(Messages.BAD_CALORIES_RANGE));
        }
        result[0] = Integer.parseInt(buffer.split("[ \\-]")[0]);
        result[1] = Integer.parseInt(buffer.split("[ \\-]")[1]);
        return result;
    }

}
