package ua.training.bukivskii.controller;


import ua.training.bukivskii.model.Chef;
import ua.training.bukivskii.model.entities.Salad;
import ua.training.bukivskii.viev.Messages;
import ua.training.bukivskii.viev.View;

import java.util.Scanner;

public class Controller {
    private View view = new View();
    private Scanner scanner = new Scanner(System.in);

    public void processUser() { //access point
        Chef chef = new Chef();
        Util util = new Util();

        Salad salad = chef.makeSalad(util.inputValidSaladName(scanner, view));
        //ask user what salad is wanted. Make wanted salad

        view.printMessage(String.format(view.unwrapBundled(Messages.SALAD_MADE),view.unwrapBundled(salad.getName()),salad.getTotalCalories(),salad.getTotalCost()));
        //Total calories and cost

        view.printUnbumdledMessage(chef.getSortedDishInfo(util.inputValidSortMethod(scanner, view),salad));
        //ask how to sort ingredients.
        //print sorted in the way user wants

        view.printUnbumdledMessage(chef.getIngredientsInCaloriesRange(salad, util.inputValidCaloriesRange(scanner, view)));
        //ask for calories range
        //and print filtered
    }
}
