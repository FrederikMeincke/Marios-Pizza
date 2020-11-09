package com.mariospizza;

import org.junit.jupiter.api.Test;

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
    }

    @Test
    void formatPizzaMenu() {
    }

    @Test
    void pizzaInfo() {
    }

    @Test
    void testPrintSymbols() {
    }

    @Test
    void testFormatPizzaHeader() {
    }

    @Test
    void testFormatPizzaMenu() {
    }

    @Test
    void testPizzaInfo() {
    }

    @Test
    void run() {
    }
}