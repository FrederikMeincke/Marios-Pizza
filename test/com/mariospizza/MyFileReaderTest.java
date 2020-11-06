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
        testHeader  name2
        5. pizzaNameTestOne, descrOne, descrTwo 40 70 101
        3. pizzaNameTestTwo, descrThree, descrFour 50 80 102

        testHeaderTest name3
        6. pizzaNameTestThree, descrFive 60 90 120
         */
        ArrayList<Pizza> testPizzaList = testFileReader.loadPizzaMenu("TestFile");
        assertEquals("testHeader name2",testPizzaList.get(0).getPizzaName());
        assertEquals(5,testPizzaList.get(1).getPizzaID());
        assertEquals("descrOne,descrTwo",testPizzaList.get(1).getPizzaDescription());
        assertEquals(40,testPizzaList.get(1).getPriceNormal());
        assertEquals("testHeaderTest name3",testPizzaList.get(3).getPizzaName());

        //TODO: fix description String so it contains spaces in both the real method and the test method.
    }

    @Test
    void loadActiveOrders() {
    }

    @Test
    void loadCompletedOrders() {
    }
}