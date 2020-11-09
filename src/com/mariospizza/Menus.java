package com.mariospizza;

import static com.mariospizza.PizzaMenu.pizzaList;

public class Menus {

    /**
     * Main Menu build - While loop, Switch and case.
     */
    public static void mainMenu() {
        String headerText = "Mario's Pizzabar:\n";
        String leadText = "Choose an option: ";
        String[] menuItems = {"Show Pizza menu", "Check active orders",
                "Add new order", "Complete Order", "Cancel Order", "Check statistics", "Exit"};
        boolean menuRun = true;
        int menuChoice;

        while (menuRun) {
            GenericMenu mainGenericMenu = new GenericMenu(headerText, leadText, menuItems);
            mainGenericMenu.printMenu();
            menuChoice = mainGenericMenu.readChoice();

            switch (menuChoice) {

                case 1:
                    PizzaMenu.formatPizzaMenu(pizzaList);
                        break;
                case 2:
                    //MyFileReader.loadActiveOrders(); //TODO: maybe write something to a file
                    OrderSystem.checkActiveOrders();
                    break;
                case 3:
                    addNewOrderMenu();
                    break;
                case 4:
                    OrderSystem.completedOrder(OrderSystem.findOrder(Main.inputInt(
                            "What is the orderID of the Order to complete?: ")));
                    break;
                case 5:
                    OrderSystem.deleteOrder(OrderSystem.findOrder(Main.inputInt(
                            "What is the orderID of the Order to complete?: ")));
                    break;
                case 6:
                    System.out.println("Check statistics");
                    //MyFileReader.loadCompletedOrders();
                    //MyStats.();
                    System.out.println(OrderSystem.findOldestOrder().toString()); //TODO: Remove this just here to test findOldestOrder method
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

    /**
     * Method that adds an oder containing pizza(s) to the order system
     */
    public static void addNewOrderMenu() {
        String headerText = "Mario's Pizzabar add Order:\n";
        String leadText = "Choose an option: ";
        String[] menuItems = {"Add Pizza", "Remove Pizza",
                "List Current Order", "Save Order", "Main Menu"};
        boolean menuRun = true;
        int menuChoice;
        Order order = new Order();

        while (menuRun) {
            GenericMenu addOrderGenericMenu = new GenericMenu(headerText, leadText, menuItems);
            addOrderGenericMenu.printMenu();
            menuChoice = addOrderGenericMenu.readChoice();
            switch (menuChoice) {
                case 1:
                    OrderSystem.addPizzaToOrder(order);
                    break;
                case 2:
                    OrderSystem.removePizzaFromOrder(order);
                    break;
                case 3:
                    OrderSystem.listCurrentOrder(order);
                    break;
                case 4:
                    OrderSystem.saveCurrentOrder(order);
                    System.out.println("Returning to Main Menu...");
                    menuRun = false;
                    break;
                case 5:
                    menuRun = false;
                    break;
                default:
                    System.out.println("\nInvalid input.\nPlease try Again:");
                    break;
            }

        }
    }
}
