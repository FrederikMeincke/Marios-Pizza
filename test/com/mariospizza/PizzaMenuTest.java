package com.mariospizza;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class PizzaMenuTest {

    @Test
    void printSymbols() {
        int formatLength = 15;
        String symbol = " ";
        String line1 = "Phillip";
        String line2 = "Brown";
        String line3 = line1 + line2;
        String line4 = line3 + PizzaMenu.printSymbols(symbol,line3,formatLength);
        assertEquals(formatLength, line4.length());
        assertEquals("PhillipBrown   ", line4);
    }

    @Test
    void formatPizzaHeader() {
        double test1 = 1;
        double test0 = 0;
        assertEquals("1",PizzaMenu.formatPizzaHeader(test1));
        assertEquals("",PizzaMenu.formatPizzaHeader(test0));
    }

    @Test
    void formatPizzaMenu() {
        // Receives an ArrayList<Pizza> that it then formats into Strings with information about each pizza and headers
        // and subsequently prints a String for each pizza and headers.
        // Unfortunately we would have to make this method return a String in order to test it as we only work with variables
        // that are local to the method itself.
    }
}
