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
        int pizzaID = pizza.getPizzaID();
        String pizzaName = pizza.getPizzaName();
        String pizzaDescription = pizza.getPizzaDescription();
        double normalPrice = pizza.getPriceNormal();
        // total length of the line
        String dotSpace = "";
        String pizzaString =
                pizzaID + ". " +
                pizzaName + ", " +
                pizzaDescription +
                normalPrice;
            int dotLength = Math.abs(pizzaString.length()-formatLength);

        for(int i = 0; i < dotLength; i++) {
            dotSpace += ".";
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

    public static String formatPizzaHeader(double number) {
        if(number == 0) {
            return "";
        } else {
            String string = String.format("%.0f",number);

            return string;
        }
    }

    public static void formatPizzaMenu(ArrayList<Pizza> pizzaList) throws FileNotFoundException {

        System.out.println(printDots("",95) + "alm    " + "deep    " + "family");
        for(int i = 0; i < pizzaList.size(); i++) {
            String pizzaID = formatPizzaHeader(pizzaList.get(i).getPizzaID());
            String pizzaName = pizzaList.get(i).getPizzaName();
            String pizzaDescription = pizzaList.get(i).getPizzaDescription();
            String pizzaDots = printPizzaDots(pizzaList.get(i), 100);
            String priceNormal = formatPizzaHeader(pizzaList.get(i).getPriceNormal());
            /*System.out.println( pizzaID + ". " +
                    pizzaName + ", " +
                    pizzaDescription +
                    pizzaDots +
                    priceNormal);

             */
            System.out.printf("%s. %s, %s %s %s\n",pizzaID,pizzaName,pizzaDescription,pizzaDots,priceNormal);
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
