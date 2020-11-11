package com.mariospizza;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MyFileWriterTest {
    MyFileWriter testFileWriter = new MyFileWriter();
    MyFileReader testFileReader = new MyFileReader();

    @Test
    void updateOrderFile() {
        // Our method updates information in a text file based on an ArrayList<Order> that also contains an ArrayList<Pizza>
        // Check if file exists and if our values are correct from our ArrayLists

        String fileName = "TestOrderFile";
        ArrayList<Order> testOrderList = new ArrayList<>();
        Order testOrder = new Order();
        int assertOrderID = 1;
        testOrder.setOrderID(assertOrderID);
        int assertPizzaMenuChoice = 1;
        int assertPizzaSizechoice = 2;
        testOrder.addPizza(assertPizzaMenuChoice,assertPizzaSizechoice);
        testOrderList.add(testOrder);

        testFileWriter.updateOrderFile(testOrderList,fileName);
        ArrayList<Order> updatedTestList = testFileReader.loadOrderFile(fileName);
        assertEquals(assertOrderID,updatedTestList.get(0).getOrderID());
        assertEquals(assertPizzaMenuChoice,updatedTestList.get(0).getOrderPizzaList().get(0).getPizzaID());
        assertEquals(assertPizzaSizechoice,updatedTestList.get(0).getOrderPizzaList().get(0).getPizzaSize());
    }
}
