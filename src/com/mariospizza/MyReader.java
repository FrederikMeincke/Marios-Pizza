package com.mariospizza;

import java.io.File;
import java.io.IOException;
<<<<<<< Updated upstream
=======
import java.util.ArrayList;
>>>>>>> Stashed changes
import java.util.Scanner;

public class MyReader {

    public ArrayList<Pizza> loadPizzaMenu() {
        try {
            Scanner input = new Scanner(new File("PizzaMenu.txt"));

            while (input.hasNextLine()) {
                String pizza = input.nextLine();
                System.out.println(pizza);
            }
        } catch (IOException e){
            System.out.println("File not found.");
        }
        return new ArrayList<>(); //TODO: Finish the loading method for the ArrayList
    }

    public void loadActiveOrders() {

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
