package com.mariospizza;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

class MyFileWriter {

    /**
     * Saved active orders in an arraylist and file.txt
     * @param orderList
     * @param fileName
     */
    public void updateOrderFile(ArrayList<Order> orderList, String fileName) {
        try {
            PrintStream output = new PrintStream(new File(fileName+".txt"));
            for(int i = 0; i < orderList.size(); i++) {
                int orderID = orderList.get(i).getOrderID();
                String orderDate = orderList.get(i).getDateTimeStr();
                String orderIDString = String.format("%d",orderID);
                String pizzaList = "";
                for(int j = 0; j < orderList.get(i).getOrderPizzaList().size(); j++) {
                    pizzaList += orderList.get(i).getOrderPizzaList().get(j).getPizzaID() + " " +
                            + orderList.get(i).getOrderPizzaList().get(j).getPizzaSize() + " ";
                }
                //output.println(orderIDString + " " + pizzaList);
                output.println(orderIDString + " " + orderDate + " " + pizzaList);
            }
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }
}
