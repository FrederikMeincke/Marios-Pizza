package com.mariospizza;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    Pizza pizza = new Pizza(1,"pizzaTest","boloni,sauerkraut,tears",35.0,55.0,105.0);

    @Test
    void testPrintPizzaMenu() {
    }

    @Test
    void setPizzaName() {
        String nameTest = "newName";
        pizza.setPizzaName(nameTest);
        assertEquals(nameTest,pizza.getPizzaName());
    }

    @Test
    void setPizzaDescription() {
        String descriptionTest = "newDescription, moreDescription";
        pizza.setPizzaDescription(descriptionTest);
        assertEquals(descriptionTest,pizza.getPizzaDescription());
    }

    @Test
    void setPriceNormal() {
        double priceTest = 50.0;
        pizza.setPriceNormal(priceTest);
        assertEquals(priceTest,pizza.getPriceNormal());
    }

    @Test
    void setPriceDeep() {
        double priceTest = 75.0;
        pizza.setPriceDeep(priceTest);
        assertEquals(priceTest,pizza.getPriceDeep());
    }

    @Test
    void setPriceFamily() {
        double priceTest = 110.0;
        pizza.setPriceFamily(priceTest);
        assertEquals(priceTest,pizza.getPriceFamily());
    }

    @Test
    void testToString() {
    }

    @Test
    void setPizzaID() {
    }

    @Test
    void getPizzaID() {
    }

    @Test
    void testSetPizzaName() {
    }

    @Test
    void getPizzaName() {
    }

    @Test
    void testSetPizzaDescription() {
    }

    @Test
    void getPizzaDescription() {
    }

    @Test
    void testSetPriceNormal() {
    }

    @Test
    void getPriceNormal() {
    }

    @Test
    void testSetPriceDeep() {
    }

    @Test
    void getPriceDeep() {
    }

    @Test
    void testSetPriceFamily() {
    }

    @Test
    void getPriceFamily() {
    }
}