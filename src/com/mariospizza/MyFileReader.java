package com.mariospizza;

import javax.print.attribute.standard.OrientationRequested;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class MyFileReader {

    public Pizza processPizzaMenuLine(Scanner input) {
        //int twoDigitsPlusDot = 3; // required length of String for the pizza number including the dot. TODO: Move this to menu printer
        String pizzaNumber = input.next(); // Includes "." but not spaces. TODO: Maybe unecessary, move to menu printer?
        String pizzaName = "";
        String pizzaDescription = "";
        double alm;
        double deep;
        double fam;

        /* TODO: Move this to the menu printer
        if(pizzaNumber.length() < twoDigitsPlusDot) {
            pizzaNumber += "  "; // Two spaces for formatting
        } else {
            pizzaNumber += " "; // One space for formatting
        }
         */
        if(!pizzaNumber.contains(".")) {
            //return  null;
            if(!input.hasNext(".")){ // checks if the next token isn't a pizzaID
                pizzaNumber += " " + input.next(); // for two-word headers
            }
            Pizza pizzaTitle = new Pizza(0,pizzaNumber,"",0,0,0);
            return pizzaTitle;
        }

        pizzaNumber = pizzaNumber.substring(0,pizzaNumber.length()-1); // removes "."
        int pizzaID = Integer.parseInt(pizzaNumber); // converts to integer so it works as an argument in the pizza constructor

        pizzaName = input.next(); // Adds pizzaname

        while(!pizzaName.contains(",")) {
            pizzaName += " " + input.next(); // For pizza names with multiple words
        }
        pizzaName = pizzaName.substring(0,pizzaName.length()-1); // TODO: Does it work?

        while(!input.hasNextDouble()) {
            pizzaDescription += input.next(); // Scans through all the toppings on the pizza //TODO: Add space between each token
        }
        //pizzaDescription = pizzaDescription.substring(-1); // Removes "," at the end if necessary
        alm = input.nextDouble();
        deep = input.nextDouble();
        if(deep > 100) { //TODO: clarify why this value is 100
            // all family pizzas cost more than 100, so if the next input is more than 100 then we know it's a family pizza and not a deep pan.
            fam = deep;
            deep = 0;
        } else {
            fam = input.nextDouble(); // in case the price is lower than 100, then the next pizza will be a family pizza.
        }

        // Once it finishes finding the prices it will end the method and we look for another line.
        Pizza pizza = new Pizza(pizzaID,pizzaName,pizzaDescription,alm,deep,fam);
        return pizza;
    }

    public ArrayList<Pizza> loadPizzaMenu(String fileName) {
        ArrayList<Pizza> pizzaList = new ArrayList<>();
        try {
            Scanner load = new Scanner(new File(fileName+".txt"));

            while (load.hasNextLine()) {
                Pizza pizza = processPizzaMenuLine(load);
                if(pizza != null) {
                    pizzaList.add(pizza); // processes the line and adds the pizza object to the array.
                }
            }
        } catch (IOException e){
            System.out.println("File not found.");
        }
        return pizzaList; //TODO: Finish the loading method for the ArrayList
    }

    /*
    public static void loadActiveOrders() {
        try {
            Scanner active = new Scanner(new File("ActiveOrders.txt"));

            while (active.hasNextLine()) {
                String activeOrders = active.nextLine();
                System.out.println(activeOrders); //TODO: insert the data from active orders
            }
        } catch (IOException e){
            System.out.println("File not found.");
        }
    }
     */

    public Order processOrderList(String line) {
        Order order = new Order();
        Scanner input = new Scanner(line);
        int orderID = input.nextInt();
        int pizzaID = -1;
        int pizzaSize = -1;

        order.setOrderID(orderID);
        while(input.hasNextInt()) {
            pizzaID = input.nextInt();
            pizzaSize = input.nextInt();

            order.addPizza(pizzaID,pizzaSize);
        }
        return order;
    }

    public ArrayList<Order> loadOrderFile(String fileName) {
        ArrayList<Order> orderList = new ArrayList<>();
        try {
            Scanner load = new Scanner(new File(fileName+".txt"));
            while (load.hasNextLine()) {
                String line = load.nextLine();
                Order order = processOrderList(line);
                if(order != null) {
                    orderList.add(order); // processes the line and adds the order object to the array.
                }
            }
        } catch (IOException e){
            System.out.println("File not found.");
        }
        return orderList; //TODO: Finish the loading method for the ArrayList
    }

    public ArrayList<Order> loadCompletedOrders() {
return null;
    }

//husk knj du har lavet denne static for at kunne teste i main
    /*
    public static void loadCompletedOrders() {
        try {
            Scanner complete = new Scanner(new File("CompletedOrders.txt"));

            while (complete.hasNextLine()) {
                String completedOrders = complete.nextLine();
                System.out.println(completedOrders);
            }
        } catch (IOException e){
            System.out.println("File not found.");
        }
    }
     */
}
