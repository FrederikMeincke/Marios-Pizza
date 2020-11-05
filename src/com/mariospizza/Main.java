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

    public static void printDots(ArrayList<Pizza> pizzaList, int formatLength) {

        for(int i = 0; i < pizzaList.size(); i++) {
            String pizzaString = pizzaList.get(i).n
        }
    }

    public static void formatPizzaMenu() throws FileNotFoundException {
        File pizzaMenu = new File("PizzaMenuClean.txt");
        Scanner in = new Scanner(pizzaMenu);
        PrintWriter out = new PrintWriter("test.txt");

        double total = 0;

        while (in.hasNextLine()) {
            String line = in.nextLine();
            boolean found = false;
            String item = "";
            double price = 0;
            for (int i = 0; !found && i < line.length(); i++){
                char ch = line.charAt(i);
                if (ch == '-'){
                    found = true;
                    item = line.substring(0, i + 1);
                    price = Double.parseDouble(line.substring(i + 1).trim());
                }
            }
            if (found) {
                out.printf("%-20s %10.2f\n", item, price);
            }
        }

        String.format("%s, %s, %s, %d", Pizza.pizzaName, pizzaDescription, printDots(), pizzaPrice);
    }

    public static void main(String[] args) throws FileNotFoundException {
	// Program that lists a Pizza Menu,
    // can take orders and sort them chronologically based on time.
    // The system also needs to be able to delete an order once it has been retrieved and paid for.
       // Menus.mainMenu();
        formatPizzaMenu();

    }
}
