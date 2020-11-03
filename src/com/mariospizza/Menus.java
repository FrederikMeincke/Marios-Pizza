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
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }
}
