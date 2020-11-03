package com.mariospizza;

public class Menus {

    public static void mainMenu() {
        String headerText = "Mario's Pizzabar:\n";
        String leadText = "Choose an option: ";
        String[] menuItems = {"Show Pizza menu", "Check active orders",
                "Add new order", "Remove Order", "Check statistics", "Exit"};

        GenericMenu mainGenericMenu = new GenericMenu(headerText, leadText, menuItems);
        mainGenericMenu.printMenu();

        switch (menuItems.length) {
            case 1:
                Pizza.printPizzaMenu();
                break;
            case 2:
                FileReader.loadActiveOrders();
                break;
            case 3:
                System.out.println("3");
                //FileWriter.addOrder();
                break;
            case 4:
                System.out.println("4");
                break;
            case 5:
                System.out.println("5");
                break;
            case 6:
                break;
        }
    }

    public static void checkMenu() {
        //displays menu Pizza.printMenu
    }

    public static void checkActiveOrders() {
        //print arraylist of Pizzas in activeOrders ArrayList
    }

    public static void addOrder() {
        //add new Pizza object to activeOrders ArrayList
    }

    public static void removeOrder() {
        //remove Pizza object from activeOrders ArrayList
    }


}
