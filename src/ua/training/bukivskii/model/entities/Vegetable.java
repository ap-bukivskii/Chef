package ua.training.bukivskii.model.entities;

public class Vegetable implements Saladable {

    private final String name;
    private final int calories;
    private final int cost;

    public Vegetable(String name, int calories, int cost) {
        this.name = name;
        this.calories = calories;
        this.cost = cost;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCalories() {
        return this.calories;
    }

    @Override
    public int getCost() {
        return this.cost;
    }

    @Override
    public String toStringForUser() {
        return  name + "\t" + calories + "\t" + cost +"\n";
    }
}
