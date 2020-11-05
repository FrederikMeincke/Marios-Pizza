package com.mariospizza;

import java.util.ArrayList;

public class OrderSystem {
    Pizza pizza;

    static ArrayList<Order> activeOrdersList = new ArrayList<>();
    static ArrayList<Order> completedOrders = new ArrayList<>();

    public OrderSystem(ArrayList<Order> activeOrdersList, ArrayList<Order> completedOrders) {
        this.activeOrdersList = activeOrdersList;
        this.completedOrders = completedOrders;
    }

    /**
     * Removes a finished order from the active orders list and adds it to the completed orders list
     *
     * @param orderToComplete
     */
    public void completeOrder(Order orderToComplete) {
        completedOrders.add(orderToComplete);
        activeOrdersList.remove(orderToComplete);
    }

    /**
     * Prints all elements in the active orders list
     */
    public void checkActiveOrders() {
        for (Order order: activeOrdersList) {
            order.toString();
        }
    }

    /**
     * Deletes an order from the active orders list
     *
     * @param order
     */
    public void deleteOrder(Order order) {
        activeOrdersList.remove(order);
    }

    /**
     * Deletes order with orderNumber from the active order list
     *
     * @param orderNumber
     */
    public void cancelOrder(int orderNumber) {
        for (int i = 0; i < activeOrdersList.size(); i++) {
            if (orderNumber == activeOrdersList.get(i).getOrderID()) {
                deleteOrder(activeOrdersList.get(i));
            } 
        }
    }

    /**
     * puts the order in the completed orders list and then removes it from the active orders list
     *
     * @param orderToComplete
     */
    public void completedOrder(Order orderToComplete) {
        completedOrders.add(orderToComplete);
        activeOrdersList.remove(orderToComplete);
    }
}
