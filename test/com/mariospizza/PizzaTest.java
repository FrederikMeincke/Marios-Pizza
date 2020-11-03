package com.mariospizza;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    @Test
    void printPizzaMenu() {
        File pizzaMenu = new File("PizzaMenu.txt");
        boolean exists = pizzaMenu.exists();
        if (exists) {
            if (pizzaMenu.isFile() && pizzaMenu.exists());
        }
    }

    @Test
    void testPrintPizzaMenu() {
    }

    @Test
    void setPizzaName() {
    }

    @Test
    void setPizzaDescription() {
    }

    @Test
    void setPriceNormal() {
    }

    @Test
    void setPriceDeep() {
    }

    @Test
    void setPriceFamily() {
    }
}