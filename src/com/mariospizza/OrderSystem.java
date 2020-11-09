package com.mariospizza;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderSystem {
    static ArrayList<Order> activeOrdersList = new ArrayList<>();
    static ArrayList<Order> completedOrders = new ArrayList<>();
    static MyFileWriter fileWriter = new MyFileWriter();

    /**
     * Method for returning an Order from an orderID.
     * Useful for other methods so they can figure out which Order to manipulate
     *
     * @param orderID
     * @return Order in activeOrdersList if it matches orderID else returns null
     */
    public static Order findOrder(int orderID) {
        Order order = null;

        for (Order activeOrder: activeOrdersList) {
            if (activeOrder.getOrderID() == orderID) {
                return activeOrder;
            }
        }
        return null; //TODO: Maybe add an exception for Order not found?
    }

    public static Order findOldestOrder() {
        Order oldestOrder;
        Order checkOrder;
        Order tmpOrder;
        LocalDateTime tmpOrderTime;
        LocalDateTime checkOrderTime;
        boolean isTmpOrderBefore;

        checkOrder = activeOrdersList.get(0);
        oldestOrder = checkOrder;

        for (int i = 1; i < activeOrdersList.size(); i++) {
            tmpOrder = activeOrdersList.get(i);

            checkOrderTime = checkOrder.getDateTime();
            tmpOrderTime = tmpOrder.getDateTime();

            isTmpOrderBefore = tmpOrder.getDateTime().isBefore(checkOrderTime); //is tmpOrder before CheckOrder?

            if (isTmpOrderBefore) {
                checkOrder = tmpOrder;
                oldestOrder = checkOrder;
            }
        }

        if (oldestOrder == null) {
            //TODO: throw exception????
        }

        return oldestOrder;
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
    public static void checkActiveOrders() {
        for (Order order: activeOrdersList) {
            System.out.println("\n" + order.toString());
        }
    }

    /**
     * Deletes an order from the active orders list
     *
     * @param order
     */
    public static void deleteOrder(Order order) {
        activeOrdersList.remove(order);
    }

    /**
     * puts the order in the completed orders list and then removes it from the active orders list
     *
     * @param orderToComplete
     */
    public static void completedOrder(Order orderToComplete) {
        completedOrders.add(orderToComplete);
        activeOrdersList.remove(orderToComplete);
        fileWriter.updateOrderFile(completedOrders,"CompletedOrders");
        fileWriter.updateOrderFile(activeOrdersList,"ActiveOrders");
    }

    public static void addPizzaToOrder(Order order) {
        System.out.println("\nAdding a pizza to current order:");
        order.addPizza(Main.inputInt("Add pizza #"),Main.inputInt(
                "What size? 1: Normal, 2: Deep Pan, 3: Family:"));
    }

    public static void removePizzaFromOrder(Order order) {
        Scanner scn = new Scanner(System.in);
        System.out.println("\nRemove a pizza from the current order:");
        for (int i = 1; i <= order.getOrderPizzaList().size(); i++) {
            System.out.println(i + ". \n"

                    + order.getOrderPizzaList().get(i - 1).toString());
        }

        System.out.println("Type the number of the pizza you want to delete");

        int userchoice = -1; //TODO: input validation?
        userchoice = scn.nextInt();

        order.getOrderPizzaList().remove(userchoice - 1);

    }

    public static void listCurrentOrder(Order order) {
        System.out.println("\nListing pizzas on current order:\n");
        int j = 1;
        for (Pizza pizza : order.getOrderPizzaList()) {
            System.out.println(j + ".\n" + pizza.toString());
            j++;
        }
    }

    public static void saveCurrentOrder(Order order) {
        System.out.println("\nSaving order...");
        activeOrdersList.add(order);
        fileWriter.updateOrderFile(activeOrdersList,"ActiveOrders");
        System.out.println("Order Saved.");
    }
}
