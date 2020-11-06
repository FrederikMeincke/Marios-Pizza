package com.mariospizza;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MyFileReaderTest {

    MyFileReader testFileReader = new MyFileReader();

    @Test
    void processPizzaMenuLine() {
    }

    @Test
    void loadPizzaMenu() {
        //Loading our pizzaMenu text file into an ArrayList<Pizza>
        //If it loads correctly, we expect several Pizza objects inside the ArrayList<Pizza>
        //and Each Pizza object will have its variables assigned from the text file.
        //Our headers are also Pizza objects but don't contain important information besides their name
        /* test.txt
        testHeader
        5. pizzaNameTest1, description1, description2, 40 70 101
        3. pizzaNameTest2, description3, description4, 50 80 102
        testHeader2
        6. pizzaNameTest3, description5, 60 90 120
         */
        ArrayList<Pizza> testPizzaList = testFileReader.loadPizzaMenu("TestFile");
        //System.out.println(testPizzaList.get(0).getPizzaID());
        //System.out.println(testPizzaList.get(0).getPizzaName());
        //assertEquals("testHeader",testPizzaList.get(0).getPizzaName());

    }

    @Test
    void loadActiveOrders() {
    }

    @Test
    void loadCompletedOrders() {
    }
}