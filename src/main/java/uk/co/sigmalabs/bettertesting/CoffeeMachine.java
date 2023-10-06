package uk.co.sigmalabs.bettertesting;

import java.util.Optional;

public interface CoffeeMachine {
    Optional<Drink> getDrink(int drinkId);

    int getWaterLevel();

    int getMilkLevel();

    int getCoffeeLevel();

    int getCups();

    int getMoney();

    boolean canMake(Drink drink);

    void makeDrink(Drink drink);

    void refill(int water, int milk, int coffee, int cups);

    void setMoney(int money);
}
