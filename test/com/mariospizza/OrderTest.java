package com.mariospizza;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    void testToString() {
    }

    @Test
    void addPizza() {
    }

    @Test
    void changeOrder() {
    }

    @Test
    void getOrderPizzaList() {
    }

    @Test
    void setOrderPizzaList() {
    }

    @Test
    void getOrderID() {
    }

    @Test
    void setOrderID() {
    }
/*
    @Test
    void testToString() {
        Order order1 = new Order();
        String orderPrint;
        Boolean stringBool = true;

        order1.addPizza(new Pizza(69, "McMuffin's tramp pizza",
                "nyoh, den smagr sgyt godt G", 69.0, 420.0, 69420.0));

        order1.addPizza(new Pizza(123, "Rigmandspizza",
                "Den smager dyrt", 69000.0, 420000.0, 69420000.0));


        orderPrint = order1.toString();
        System.out.println(orderPrint);

        stringBool = orderPrint.isEmpty();

        assertEquals(false, stringBool);
    }

    @Test
    void addPizza() {
        int listSize = 0;
        Order order1 = new Order();

        order1.addPizza(new Pizza(69, "McMuffin's tramp pizza",
                "nyoh, den smagr sgyt godt G", 69.0, 420.0, 69420.0));

        order1.addPizza(new Pizza(123, "Rigmandspizza",
                "Den smager dyrt", 69000.0, 420000.0, 69420000.0));

        listSize = order1.getOrderPizzaList().size();

        assertEquals(2, listSize);
    }

    @Test
    void changeOrder() {
    }

    @Test
    void getOrderPizzaList() {
        int listSize = 0;
        Order order1 = new Order();

        order1.addPizza(new Pizza(69, "McMuffin's tramp pizza",
                "nyoh, den smagr sgyt godt G", 69.0, 420.0, 69420.0));

        order1.addPizza(new Pizza(123, "Rigmandspizza",
                "Den smager dyrt", 69000.0, 420000.0, 69420000.0));

        order1.addPizza(new Pizza(321, "123",
                "Den smager 123", 123.0, 123.0, 123.0));

        listSize = order1.getOrderPizzaList().size();

        assertEquals(3, listSize);
    }

    @Test
    void setOrderPizzaList() {
        int pizzaListSize = 0;
        Order order1 = new Order();

        order1.addPizza(new Pizza(69, "McMuffin's tramp pizza",
                "nyoh, den smagr sgyt godt G", 69.0, 420.0, 69420.0));

        order1.addPizza(new Pizza(123, "Rigmandspizza",
                "Den smager dyrt", 69000.0, 420000.0, 69420000.0));

        order1.addPizza(new Pizza(321, "123",
                "Den smager 123", 123.0, 123.0, 123.0));

        //new ArrayList that is gonna be passed to order1
        ArrayList<Pizza> testPizzaList = new ArrayList<>();
        testPizzaList.add(new Pizza(321, "321",
                "Den smager 321", 321.0, 321.0, 321.0));

        order1.setOrderPizzaList(testPizzaList);

        pizzaListSize = order1.getOrderPizzaList().size();

        assertEquals(1, pizzaListSize);
    }

    //this will fail if you test the entire class together because of the way unique ids are generated with static int
    @Test
    void getOrderID() {
        Order orderA = new Order();
        Order orderB = new Order();
        Order orderC = new Order();
        Order orderD = new Order();

        int orderID = 0;


        System.out.println(orderA.getOrderID());
        System.out.println(orderB.getOrderID());
        System.out.println(orderC.getOrderID());
        System.out.println(orderD.getOrderID());

        orderID = orderD.getOrderID();

        assertEquals(4, orderID);
    }

    @Test
    void setOrderID() {
        Order order1 = new Order();
        int orderID = 0;

        order1.setOrderID(420);

        orderID = order1.getOrderID();

        assertEquals(420, orderID);
    }

 */
}