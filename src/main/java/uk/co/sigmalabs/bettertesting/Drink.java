package uk.co.sigmalabs.bettertesting;

import java.util.Objects;

public class Drink {

    private final int id;
    private final String name;
    private final int water;
    private final int milk;
    private final int coffee;
    private final int cost;

    public Drink(int id, String name, int water, int milk, int coffee, int cost) {
        this.id = id;
        this.name = name;
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return drink.name.equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, water, milk, coffee, cost);
    }
}
