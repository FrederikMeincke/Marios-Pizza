package com.mariospizza;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Pizza {
    int pizzaID; //number you use to order the pizza
    String pizzaName;
    String pizzaDescription;
    int pizzaSize; //1 for normal, 2 for Deep-Pan, 3 for Family
    double priceNormal; // price of pizza. Maybe different prices for different sizes?
    double priceDeep;
    double priceFamily;

    /**
     * Pizza description.
     *
     * @param pizzaID number from menu
     * @param pizzaName name of the pizza
     * @param pizzaDescription description
     * @param priceNormal price for normal version
     * @param priceDeep price for deep pan version
     * @param priceFamily price for familiy version
     */
    public Pizza(int pizzaID, String pizzaName, String pizzaDescription,
                 double priceNormal, double priceDeep, double priceFamily) {
        setPizzaID(pizzaID);
        setPizzaName(pizzaName);
        setPizzaDescription(pizzaDescription);
        setPriceNormal(priceNormal);
        setPriceDeep(priceDeep);
        setPriceFamily(priceFamily);
    }
    //TODO: delete empty default constructor?
/*
    public Pizza() {

    }


 */
    public String toString() {
        return  "Pizza #" + getPizzaID() +
                "\nPizza name: " + getPizzaName() +
                "\nPizza size: " + getPizzaSize() +
                "\n";
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

    public double getPriceDeep() {
        return priceDeep;
    }

    public void setPriceFamily(double priceFamily) {
        this.priceFamily = priceFamily;
    }

    public double getPriceFamily() {
        return priceFamily;
    }

    public int getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(int pizzaSize) {
        this.pizzaSize = pizzaSize;
    }
}
