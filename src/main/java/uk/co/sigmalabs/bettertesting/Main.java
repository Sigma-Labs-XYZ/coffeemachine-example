package uk.co.sigmalabs.bettertesting;

import java.util.Optional;

public class Main {

    private static final String EXIT = "exit";
    private static final String REMAINING = "remaining";
    private static final String BUY = "buy";
    private static final String FILL = "fill";
    private static final String TAKE = "take";

    public static void main(String[] args) {
        Cli cli = new Cli();

        boolean keepGoing = true;
        CoffeeMachine coffeeMachine = new SimpleCoffeeMachine(400, 540, 120, 9, 550);

        do {
            String command = cli.askAndAnswer("Write action (buy, fill, take, remaining, exit):");

            if(EXIT.equalsIgnoreCase(command)) {
                keepGoing = false;
            }

            if(REMAINING.equalsIgnoreCase(command)) {
                cli.writeln(coffeeMachine.getWaterLevel() + " ml of water");
                cli.writeln(coffeeMachine.getMilkLevel() + " ml of milk");
                cli.writeln(coffeeMachine.getCoffeeLevel() + " g of coffee beans");
                cli.writeln(coffeeMachine.getCups() + " disposable cups");
                cli.writeln("$" + coffeeMachine.getMoney() + " of money");
            }

            if(BUY.equalsIgnoreCase(command)) {
                int coffeeId = cli.askAndAnswerNumber("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                Optional<Drink> drinkOptional = coffeeMachine.getDrink(coffeeId);

                if(drinkOptional.isPresent()) {
                    Drink drink = drinkOptional.get();
                    if(coffeeMachine.canMake(drink)) {
                        cli.writeln("I have enough resources, making you a coffee!");
                        coffeeMachine.makeDrink(drink);
                    } else {
                        cli.writeln("Sorry not enough");
                    }
                }
            }

            if(TAKE.equalsIgnoreCase(command)) {
                cli.writeln("I gave you $" + coffeeMachine.getMoney());
                coffeeMachine.setMoney(0);
            }

            if(FILL.equalsIgnoreCase(command)) {
                int waterToAdd = cli.askAndAnswerNumber("Write how many ml of water you want to add:");
                int milkToAdd = cli.askAndAnswerNumber("Write how many ml of milk you want to add:");
                int coffeeToAdd = cli.askAndAnswerNumber("Write how many grams of coffee beans you want to add:");
                int cupsToAdd = cli.askAndAnswerNumber("Write how many disposable cups you want to add:");

                coffeeMachine.refill(waterToAdd, milkToAdd, coffeeToAdd, cupsToAdd);
            }

        }while (keepGoing);

    }

}