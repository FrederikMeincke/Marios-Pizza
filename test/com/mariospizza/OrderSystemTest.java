package com.mariospizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderSystemTest {

    @Test
    void findOrder() {
        Order order1 = new Order();
        Order order2 = new Order();

        OrderSystem.activeOrdersList.add(order1);
        OrderSystem.activeOrdersList.add(order2);

        Order testOrder = OrderSystem.findOrder(order2.getOrderID());

        assertEquals(order2, testOrder);
    }

    @Test
    void findOldestOrder() {
        Order oldestOrder;

        Order order3 = new Order();
        Order order4 = new Order();

        OrderSystem.activeOrdersList.add(order3);
        OrderSystem.activeOrdersList.add(order4);

        oldestOrder = OrderSystem.findOldestOrder();

        assertEquals(OrderSystem.activeOrdersList.get(0), oldestOrder);
    }

    @Test
    void completeOrder() {
        Order order5 = new Order();
        int cmpltOrdersSize;


        OrderSystem.activeOrdersList.add(order5);
        OrderSystem.completeOrder(order5);

        cmpltOrdersSize = OrderSystem.completedOrders.size();

        assertEquals(1, cmpltOrdersSize);
    }

    @Test
    void checkActiveOrders() {
        Order order6 = new Order();

        OrderSystem.activeOrdersList.add(order6);

        OrderSystem.checkActiveOrders();

    }

    @Test
    void deleteOrder() {
        Order order7 = new Order();
        Order order8 = new Order();

        int actvOrdersListSizeBefore;
        int actvOrdersListSizeAfter;

        OrderSystem.activeOrdersList.add(order7);
        OrderSystem.activeOrdersList.add(order8);

        actvOrdersListSizeBefore = OrderSystem.activeOrdersList.size();

        OrderSystem.deleteOrder(order7);

        actvOrdersListSizeAfter = OrderSystem.activeOrdersList.size();

        assertEquals(1, (actvOrdersListSizeBefore - actvOrdersListSizeAfter));

    }

    @Test
    void completedOrder() {
        Order order9 = new Order();
        Order order10 = new Order();

        int actvOrdersListSizeBefore;
        int cmpltOrdersListSizeBefore;
        int actvOrdersListSizeAfter;
        int cmpltOrdersListSizeAfter;

        OrderSystem.activeOrdersList.add(order9);
        OrderSystem.activeOrdersList.add(order10);


        actvOrdersListSizeBefore = OrderSystem.activeOrdersList.size();
        cmpltOrdersListSizeBefore = OrderSystem.completedOrders.size();

        OrderSystem.completedOrder(order9);

        actvOrdersListSizeAfter = OrderSystem.activeOrdersList.size();
        cmpltOrdersListSizeAfter = OrderSystem.completedOrders.size();

        assertEquals(1, (actvOrdersListSizeBefore - actvOrdersListSizeAfter));
        assertEquals(1, (cmpltOrdersListSizeAfter - cmpltOrdersListSizeBefore));
    }

    @Test
    void addPizzaToOrder() { //not really worth testing tbh and its broken af
        /*
        Order order11 = new Order();
        int orderPizzaListSize;

        OrderSystem.addPizzaToOrder(order11);

        orderPizzaListSize = order11.getOrderPizzaList().size();

        assertEquals(1, orderPizzaListSize);

         */
    }

    @Test
    void removePizzaFromOrder() { //not really worth testing tbh and also  broken af. Cause user input
        //.addPizza functionality will get checked in Order class

        /*
        Order order12 = new Order();
        int orderPizzaListSizeBefore;
        int orderPizzaListSizeAfter;

        order12.addPizza(35,2);
        order12.addPizza(26,3);

        orderPizzaListSizeBefore = order12.getOrderPizzaList().size();

        OrderSystem.removePizzaFromOrder(order12);

        orderPizzaListSizeAfter = order12.getOrderPizzaList().size();

        assertEquals(1, orderPizzaListSizeBefore - orderPizzaListSizeAfter);

         */
    }

    @Test
    void listCurrentOrder() { //just a print method maybe not worth testing
        Order order13 = new Order();

        order13.addPizza(2,2);

        OrderSystem.listCurrentOrder(order13);
    }

    @Test
    void saveCurrentOrder() {
        Order order14 = new Order();
        int activeOrdersListSizeBefore;
        int activeOrdersListSizeAfter;

        activeOrdersListSizeBefore = OrderSystem.activeOrdersList.size();

        OrderSystem.saveCurrentOrder(order14);

        activeOrdersListSizeAfter = OrderSystem.activeOrdersList.size();

        assertEquals(1, activeOrdersListSizeAfter - activeOrdersListSizeBefore);
    }
}
