package com.mariospizza;

public class Menus {

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
                        Pizza.printPizzaMenu();
                        break;
                    case 2:
                        FileReader.loadActiveOrders();
                        break;
                    case 3:
                        System.out.println("3");
                        //addOrder();
                        break;
                    case 4:
                        System.out.println("4");
                        //deleteOrder();
                        break;
                    case 5:
                        FileReader.loadCompletedOrders();
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

    public static void checkActiveOrders() {
        //print arraylist of Pizzas in activeOrders ArrayList
    }

    public static void addOrder() {
        /*
        add new Pizza object to activeOrders ArrayList
        activeOrders.add(new Pizza(x,x,x));
         */
    }

    public static void removeOrder() {
        //remove Pizza object from activeOrders ArrayList
    }

    public static void showStats() {
        //read stats from stats.txt file
    }


}
