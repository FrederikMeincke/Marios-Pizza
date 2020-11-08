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
                "Add new order", "Complete Order", "Cancel Order", "Check statistics", "Exit"};
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
                    //MyFileReader.loadActiveOrders();
                    OrderSystem.checkActiveOrders();
                    break;
                case 3:
                    OrderSystem.addNewOrder();
                    break;
                case 4:
                    OrderSystem.completedOrder(OrderSystem.findOrder(Main.inputInt(
                            "What is the orderID of the Order to complete?: ")));
                    break;
                case 5:
                    OrderSystem.deleteOrder(OrderSystem.findOrder(Main.inputInt("")));
                    break;
                case 6:
                    System.out.println("Check statistics");
                    //MyFileReader.loadCompletedOrders();
                    //MyStats.();
                    break;
                case 7:
                    menuRun = false;
                    break;
                default:
                    System.out.println("\nInvalid input.\nPlease try Again!");
                    break;
            }
        }
    }
}
