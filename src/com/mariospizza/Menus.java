package com.mariospizza;

import java.io.FileNotFoundException;

import static com.mariospizza.PizzaMenu.pizzaList;

public class Menus {

    /**
     * Menu build - While loop, Switch and case.
     */
    public static void mainMenu() {
        String headerText = "Mario's Pizzabar:\n";
        String leadText = "Choose an option: ";
        String[] menuItems = {"Show Pizza menu", "Check active orders",
                "Add new order", "Remove Order", "Check statistics", "Exit"};
        boolean menuRun = true;
        int menuChoice = -1;

        while (menuRun) {
            GenericMenu mainGenericMenu = new GenericMenu(headerText, leadText, menuItems);
            mainGenericMenu.printMenu();
            menuChoice = mainGenericMenu.readChoice();

            switch (menuChoice) {
                    case 1:
                        PizzaMenu.formatPizzaMenu(pizzaList);
                        break;
                    case 2:
                        MyFileReader.loadActiveOrders();
                        break;
                    case 3:
                        OrderSystem.addNewOrder();
                        break;
                    case 4:
                        System.out.println("4");
                        //deleteOrder();
                        break;
                    case 5:
                        MyFileReader.loadCompletedOrders();
                        //showStats();
                        break;
                    case 6:
                        menuRun = false;
                        break;
                    default:
                        System.out.println("\nInvalid input.\nPlease try Again!");
                        break;
            }
        }
    }
}
