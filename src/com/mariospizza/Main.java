package com.mariospizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Marios Pizza Menu POS for command line application
 * @author Frederik M., Jimmy, Kasper, Mads, Philip
 * @version 0.4
 */

public class Main {

    static MyFileReader fileReader = new MyFileReader();
    static ArrayList<Pizza> pizzaList = fileReader.loadPizzaMenu("PizzaMenuClean");

    public static String printPizzaDots(Pizza pizza, int formatLength) {
        // total length of the line
        String dotSpace = "";
        String pizzaString =
                pizza.getPizzaID() + ". " +
                pizza.getPizzaName() + ", " +
                pizza.getPizzaDescription() +
                pizza.getPriceNormal();
            int dotLength = Math.abs(pizzaString.length()-formatLength);

        for(int i = 0; i < dotLength; i++) {
            dotSpace += " ";
        }
        return dotSpace;
    }

    public static String printDots(String line, int formatLength) {
        String dotSpace = "";
        int dotLength = Math.abs(line.length()-formatLength);

        for(int i = 0; i < dotLength; i++) {
            dotSpace += " ";
        }
        return dotSpace;
    }

    public static void formatPizzaMenu(ArrayList<Pizza> pizzaList) throws FileNotFoundException {

        System.out.println(printDots("",97) + "alm    " + "deep    " + "family");
        for(int i = 0; i < pizzaList.size(); i++) {
            System.out.println(pizzaList.get(i).getPizzaID() + ". " +
                    pizzaList.get(i).getPizzaName() + ", " +
                    pizzaList.get(i).getPizzaDescription() +
                    printPizzaDots(pizzaList.get(i),100) +
                    pizzaList.get(i).getPriceNormal());
        }

        //String.format("%s, %s, %s, %d", Pizza.pizzaName, pizzaDescription, printDots(), pizzaPrice);
    }

    public static void main(String[] args) throws FileNotFoundException {
	// Program that lists a Pizza Menu,
    // can take orders and sort them chronologically based on time.
    // The system also needs to be able to delete an order once it has been retrieved and paid for.
       // Menus.mainMenu();
        formatPizzaMenu(pizzaList);

    }
}
