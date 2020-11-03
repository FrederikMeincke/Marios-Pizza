package com.mariospizza;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MyReader {

    public void loadPizzaMenu() {

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
