package com.mariospizza;

import java.util.ArrayList;

public class OrderSystem {
    Pizza pizza;

    ArrayList<Order> activeOrderList = new ArrayList<>();
    ArrayList<Order> completedOrderList = new ArrayList<>();

    public OrderSystem(ArrayList<Order> activeOrdersList, ArrayList<Order> completedOrderList) {
        this.activeOrderList = activeOrderList;
        this.completedOrderList = completedOrderList;

    }

    public void completeOrder(Order orderToComplete) {
        completedOrderList.add(orderToComplete);
        activeOrderList.remove(orderToComplete);
    }

    public void checkActiveOrders() {
        for (Order order: activeOrderList) {
            order.toString();
        }
    }
    public void deleteOrder(Order order) {
        activeOrderList.remove(order);
    }
}