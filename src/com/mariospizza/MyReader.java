package com.mariospizza;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyReader {

    public ArrayList<Pizza> loadPizzaMenu() {
        try {
            Scanner load = new Scanner(new File("PizzaMenu.txt"));

            while (load.hasNextLine()) {
                String loadPizza = load.nextLine();
                System.out.println(loadPizza);
            }
        } catch (IOException e){
            System.out.println("File not found.");
        }
        return new ArrayList<>(); //TODO: Finish the loading method for the ArrayList
    }

    public static void loadActiveOrders() {
        try {
            Scanner active = new Scanner(new File("ActiveOrders.txt"));

            while (active.hasNextLine()) {
                String activeOrders = active.nextLine();
                System.out.println(activeOrders);
            }
        } catch (IOException e){
            System.out.println("File not found.");
        }
    }

//husk knj du har lavet denne static for at kunne teste i main
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
}
