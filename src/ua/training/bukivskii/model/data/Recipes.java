package ua.training.bukivskii.model.data;

import ua.training.bukivskii.model.entities.Saladable;

public enum Recipes {
    SUMMER(SaladNames.SUMMER, Storage.TOMATO.getItem(), Storage.CUCUMBER.getItem(), Storage.CABBAGE.getItem(), Storage.SWEET_PEPPER.getItem(), Storage.ONION.getItem()),
    WINTER(SaladNames.WINTER, Storage.POTATO.getItem(), Storage.PEAS.getItem(), Storage.CORN.getItem(), Storage.CARROT.getItem(),  Storage.OLIVES.getItem(),  Storage.ONION.getItem()),
    SIMPLE(SaladNames.SIMPLE, Storage.CUCUMBER.getItem(), Storage.CARROT.getItem(), Storage.CABBAGE.getItem(), Storage.ONION.getItem());

    private Saladable[] ingredients;
    private String name;

    Recipes(String name, Saladable... ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return this.name;
    }
    public Saladable [] getIngredients(){
        return ingredients;
    }

}
