package com.mariospizza;
import java.io.*;
import java.util.Scanner;

public class Pizza {
    int pizzaID; //number you use to order the pizza
    int pizzaSize; //1 for normal, 2 for Deep-Pan, 3 for Family
    double priceNormal; // price of pizza. Maybe different prices for different sizes?
    double priceDeep;
    double priceFamily;

    /**
     * Prints out the menu .txt file, line for line.
     */
    public static void printPizzaMenu() {
        try {
            Scanner input = new Scanner(new File("PizzaMenu.txt"));

            while (input.hasNextLine()) {
                String pizza = input.nextLine();
                System.out.println(pizza);
            }
        } catch (IOException e){
            System.out.println("File not found.");
        }
    }
}
