package com.mariospizza;

import java.util.Scanner;

/**
 * Marios Pizza Menu POS for command line application
 * @author Frederik M., Jimmy, Kasper, Mads, Phillip
 * @version 1
 */

public class Main {

    static MyFileReader fileReader = new MyFileReader();

    public static int inputInt(String prompt) {
        Scanner in = new Scanner(System.in);
        System.out.print(prompt);
        int input = in.nextInt();
        return input;
    }


    public static void main(String[] args) {
	// Program that lists a Pizza Menu,
    // can take orders and sort them chronologically based on time.
    // The system also needs to be able to delete an order once it has been retrieved and paid for.
        OrderSystem.activeOrdersList = fileReader.loadOrderFile("ActiveOrders");
        OrderSystem.completedOrders = fileReader.loadOrderFile("CompletedOrders");
        Menus.mainMenu();
    }
}
