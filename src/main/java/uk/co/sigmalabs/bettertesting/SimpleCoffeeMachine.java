package uk.co.sigmalabs.bettertesting;

import java.util.List;
import java.util.Optional;

public class SimpleCoffeeMachine implements CoffeeMachine {

    private final List<Drink> availableDrinks;
    private int waterLevel;
    private int milkLevel;
    private int coffeeLevel;
    private int cups;
    private int money;

    public SimpleCoffeeMachine(int waterLevel, int milkLevel, int coffeeLevel, int cups, int money) {
        this.waterLevel = waterLevel;
        this.milkLevel = milkLevel;
        this.coffeeLevel = coffeeLevel;
        this.cups = cups;
        this.money = money;

        availableDrinks = List.of(
                new Drink(1, "espresso", 250, 0, 16, 4),
                new Drink(2, "latte", 350, 75, 20, 7),
                new Drink(3, "cappuccino", 200, 100, 12, 6)
        );
    }

    @Override
    public Optional<Drink> getDrink(int drinkId) {
        return availableDrinks.stream().filter(d -> d.getId() == drinkId).findFirst();
    }
    @Override
    public int getWaterLevel() {
        return waterLevel;
    }

    @Override
    public int getMilkLevel() {
        return milkLevel;
    }

    @Override
    public int getCoffeeLevel() {
        return coffeeLevel;
    }

    @Override
    public int getCups() {
        return cups;
    }

    @Override
    public int getMoney() {
        return money;
    }

    @Override
    public boolean canMake(Drink drink) {
        return drink.getCoffee() <= coffeeLevel &&
                drink.getMilk() <= milkLevel &&
                drink.getWater() <= waterLevel &&
                cups > 0;
    }

    @Override
    public void makeDrink(Drink drink) {
        coffeeLevel = getNewLevel(coffeeLevel, drink.getCoffee());
        waterLevel = getNewLevel(waterLevel, drink.getWater());
        milkLevel = getNewLevel(milkLevel, drink.getMilk());
        cups = getNewLevel(cups, 1);
        money += drink.getCost();
    }

    @Override
    public void refill(int water, int milk, int coffee, int cups) {
        waterLevel += water;
        milkLevel += milk;
        coffeeLevel += coffee;
        this.cups += cups;
    }

    @Override
    public void setMoney(int money) {
        this.money = money;
    }

    private int getNewLevel(int current, int remove) {
        int newLevel = current - remove;

        if(newLevel < 0) {
            return 0;
        }

        return newLevel;
    }


}
