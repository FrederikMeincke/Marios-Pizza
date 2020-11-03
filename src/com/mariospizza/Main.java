package com.mariospizza;

/**
 * Marios Pizza Menu POS for command line application
 * @author Frederik M., Jimmy, Kasper, Mads, Philip
 * @version 0.2
 */

public class Main {


    public static void main(String[] args) {
	// Program that lists a Pizza Menu,
    // can take orders and sort them chronologically based on time.
    // The system also needs to be able to delete an order once it has been retrieved and paid for.

        // test print of printPizzaMenu() method
        Pizza.printPizzaMenu();
        //FileReader.loadCompletedOrders();



        String headerText = "Marios Pizzabar: ";
        String leadText = "Choose an option: ";
        String[] menuGenstande = { "Show Pizza menu", "Check active orders",
                "Add new order", "Remove Order", "Check statistics", "Exit" };

        Menu hovedMenu = new Menu(headerText, leadText, menuGenstande);
        hovedMenu.printMenu();



    }
}
