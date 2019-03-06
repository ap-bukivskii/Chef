package ua.training.bukivskii.model.data;

import ua.training.bukivskii.model.entities.Saladable;
import ua.training.bukivskii.model.entities.Vegetable;

public enum Storage {

    POTATO(VegNames.POTATO,76,4),
    TOMATO(VegNames.TOMATO,20,9),
    SWEET_PEPPER(VegNames.SWEET_PEPPER,30,8),
    ONION(VegNames.ONION, 47,4),
    OLIVES(VegNames.OLIVES,115,50),
    CARROT(VegNames.CARROT,32,5),
    PEAS(VegNames.PEAS,76,14),
    CORN(VegNames.CORN,96,18),
    CUCUMBER(VegNames.CUCUMBER,15,6),
    CABBAGE(VegNames.CABBAGE,27,3);// Did you know there are dozens of cabbage sorts?

    private  String name;
    private  int calories;
    private  int cost;

    Storage(String name, int calories, int cost) {
        this.name = name;
        this.calories = calories;
        this.cost = cost;
    }

    public Saladable getItem(){ //if we need we can return not only vegetables
        return new Vegetable(this.name,this.calories,this.cost);
    }
}
