package com.mariospizza;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MyFileWriterTest {

    @Test
    void updateOrderFile() {
        // Our method updates information in a text file based on an ArrayList<Order> that also contains an ArrayList<Pizza>
        // Check if file exists and if our values are correct from our ArrayLists
        String fileName = "TestOrderFile";
        ArrayList<Order> testOrderList = new ArrayList<>();
        Order testOrder = new Order();
        int assertPizzaMenuChoice = 1;
        int assertPizzaSizechoice = 2;
        testOrder.addPizza(assertPizzaMenuChoice,assertPizzaSizechoice);
        testOrderList.add(testOrder);

        try {
            PrintStream output = new PrintStream(new File(fileName + ".txt"));
            for (int i = 0; i < testOrderList.size(); i++) {
                int orderID = testOrderList.get(i).getOrderID();
                assertEquals(1,orderID); // assuming size 1 // ASSERTION LINE
                String orderIDString = String.format("%d", orderID);
                String pizzaList = "";
                for (int j = 0; j < testOrderList.get(i).getOrderPizzaList().size(); j++) {
                    int testPizzaMenuChoice = testOrderList.get(i).getOrderPizzaList().get(j).getPizzaID();
                    int testPizzaSize = testOrderList.get(i).getOrderPizzaList().get(j).getPizzaSize();
                    assertEquals(assertPizzaMenuChoice,testPizzaMenuChoice); // ASSERTION LINE 2
                    assertEquals(assertPizzaSizechoice,testPizzaSize); // ASSERTION LINE 3
                    pizzaList += testPizzaMenuChoice + " " +
                            +testPizzaSize + " ";
                }
                output.println(orderIDString + " " + pizzaList);
            }
        } catch (IOException e) {

        }
    }
}