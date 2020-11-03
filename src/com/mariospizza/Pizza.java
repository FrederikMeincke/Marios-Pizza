package com.mariospizza;
import java.io.*;
import java.util.Scanner;

public class Pizza {

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
