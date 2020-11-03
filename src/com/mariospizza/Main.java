package com.mariospizza;

import java.util.ArrayList;

/**
 * Marios Pizza Menu POS for command line application
 * @author Frederik M., Jimmy, Kasper, Mads, Philip
 * @version 0.2
 */

public class Main {

    static FileReader fileReader = new FileReader();
    static ArrayList<Pizza> pizzaList = fileReader.loadPizzaMenu();

    public static void main(String[] args) {
	// Program that lists a Pizza Menu,
    // can take orders and sort them chronologically based on time.
    // The system also needs to be able to delete an order once it has been retrieved and paid for.
        Menus.mainMenu();

    }
}
