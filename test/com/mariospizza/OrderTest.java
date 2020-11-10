package com.mariospizza;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    void testToString() {
        Order order1 = new Order();
        String orderPrint;
        Boolean stringBool = true;

        order1.addPizza(1, 3);


        orderPrint = order1.toString();
        System.out.println(orderPrint);

        stringBool = orderPrint.isEmpty();

        assertEquals(false, stringBool);
    }

    @Test
    void addPizza() {
        Order order2 = new Order();
        int orderPizzaListSizeBefore;
        int orderPizzaListSizeAfter;

        orderPizzaListSizeBefore = order2.getOrderPizzaList().size();

        order2.addPizza(3,2);

        orderPizzaListSizeAfter = order2.getOrderPizzaList().size();

        assertEquals(1, (orderPizzaListSizeAfter - orderPizzaListSizeBefore));
    }

    @Test
    void changeOrder() {
    }

    @Test
    void getOrderPizzaList() {
        Order order3 = new Order();

        order3.getOrderPizzaList();
    }

    @Test
    void setOrderPizzaList() {
        Order order5 = new Order();

        ArrayList<Pizza> pizzaTestList = new ArrayList<>();
        pizzaTestList.add(new Pizza(23, "uwu pizza", "nyahallo x3",
                123.0,123.0,123.0));
        pizzaTestList.add(new Pizza(23, "pizza owo", "This is an owo pizza",
                134.0,1213.0,1236.0));

        order5.setOrderPizzaList(pizzaTestList);

        assertEquals("pizza owo", order5.getOrderPizzaList().get(1).getPizzaName());
    }

    @Test
    void getOrderID() {
        Order order5 = new Order();

        order5.getOrderPizzaList();
    }

    @Test
    void setOrderID() {
        Order order6 = new Order();

        order6.setOrderID(69);

        assertEquals(69, order6.getOrderID());
    }

    @Test
    void getDateTime() {
        Order order7 = new Order();

        assertEquals(LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")),
                order7.getDateTime().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
    }
}
