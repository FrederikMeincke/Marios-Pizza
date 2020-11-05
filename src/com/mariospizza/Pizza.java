package com.mariospizza;
import java.io.*;
import java.util.Scanner;

public class Pizza {
    int pizzaID; //number you use to order the pizza
    String pizzaName;
    String pizzaDescription;
    int pizzaSize; //1 for normal, 2 for Deep-Pan, 3 for Family
    double priceNormal; // price of pizza. Maybe different prices for different sizes?
    double priceDeep;
    double priceFamily;


    public Pizza(int pizzaID, String pizzaName, String pizzaDescription, double priceNormal, double priceDeep, double priceFamily) {
        setPizzaID(pizzaID);
        setPizzaName(pizzaName);
        setPizzaDescription(pizzaDescription);
        setPriceNormal(priceNormal);
        setPriceDeep(priceDeep);
        setPriceFamily(priceFamily);
    }

    public String toString() {
        return pizzaName;
    }
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

    public void setPizzaID(int pizzaID) {
        this.pizzaID = pizzaID;
    }

    public int getPizzaID() {
        return pizzaID;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaDescription(String pizzaDescription) {
        this.pizzaDescription = pizzaDescription;
    }

    public String getPizzaDescription() {
        return pizzaDescription;
    }

    public void setPriceNormal(double priceNormal) {
        this.priceNormal = priceNormal;
    }

    public double getPriceNormal() {
        return priceNormal;
    }

    public void setPriceDeep(double priceDeep) {
        this.priceDeep = priceDeep;
    }

    public void setPriceFamily(double priceFamily) {
        this.priceFamily = priceFamily;
    }
}
