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
}