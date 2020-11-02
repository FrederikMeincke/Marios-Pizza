package com.mariospizza;
import java.io.*;
import java.util.Scanner;

public class Pizza {

    public static void printPizzaMenu() {
        try {
            Scanner input = new Scanner(new File("PizzaMenu.txt"));

            while (input.hasNextLine()) {
                String text = input.nextLine();
                System.out.println(text);
            }
        } catch (IOException e){
            System.out.println("File not found.");
        }
    }
}
