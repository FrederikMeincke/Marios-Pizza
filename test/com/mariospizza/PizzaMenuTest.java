package com.mariospizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PizzaMenuTest {

    @Test
    void printSymbols() {
        String symbol = " ";
        String line = "Phillip";
        String line2 = "Brown";
        String line3 = "line + line2";
        String line4 = "line3 + printSymbols";
        int formatLenght = 15;
        assertEquals(formatLenght, line4.length());
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
}