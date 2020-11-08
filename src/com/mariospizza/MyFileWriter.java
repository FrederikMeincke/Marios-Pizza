package com.mariospizza;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class MyFileWriter {

    // TODO: write to files

    /**
     * Save completed orders in an arraylist and file.txt
     * @param orderList
     * @param fileName
     */
    public void saveCompletedOrders(ArrayList<Order> orderList, String fileName) {
        try {
            PrintStream output = new PrintStream(new File(fileName+".txt"));
            for (int i = 0; i < orderList.size(); i++) {
                output.println(orderList.get(i).toString()); // TODO: Add toString in Order that prints the information we need in the text file
            }
        } catch (IOException e) {
            //TODO: Add message
        }

    }

    /**
     * Saved active orders in an arraylist and file.txt
     * @param orderList
     * @param fileName
     */
    public void updateOrderFile(ArrayList<Order> orderList, String fileName) {
        try {
            PrintStream output = new PrintStream(new File(fileName+".txt"));
            for (int i = 0; i < orderList.size(); i++) {
                int orderID = orderList.get(i).getOrderID();
                String orderIDString = String.format("%d",orderID);
                String pizzaList = "";
                        for(int j = 0; j < orderList.get(i).getOrderPizzaList().size(); j++) {
                            pizzaList += orderList.get(i).getOrderPizzaList().get(j).pizzaID + " " +
                            orderList.get(i).getOrderPizzaList().get(j).getPizzaSize() + " ";
                        }
                output.println(orderIDString + " " + pizzaList);
            }
        } catch (IOException e) {
            //TODO: Add message
        }
    }
}
