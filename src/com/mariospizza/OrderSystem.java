package com.mariospizza;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class OrderSystem {
    static ArrayList<Order> activeOrdersList = new ArrayList<>();
    static ArrayList<Order> completedOrders = new ArrayList<>();
    static MyFileWriter fileWriter = new MyFileWriter();

    /**
     * Method for returning an Order from an orderID.
     * Useful for other methods so they can figure out which Order to manipulate
     *
     * @param orderID is the ID of a given order
     * @return Order in activeOrdersList if it matches orderID else returns null
     */
    public static Order findOrder(int orderID) {

        for (Order activeOrder : activeOrdersList) {
            if (activeOrder.getOrderID() == orderID) {
                return activeOrder;
            }
        }
        return null;
    }

    /**
     * Looks at the date & time for all orders and finds the oldest one. Useful for deciding which order to make next
     *
     * @return oldestOrder in the active orderList
     */
    static Order findOldestOrder() {
        Order oldestOrder;
        Order checkOrder;
        Order tmpOrder;
        LocalDateTime checkOrderTime;
        boolean isTmpOrderBefore;

        checkOrder = activeOrdersList.get(0);
        oldestOrder = checkOrder;

        for (int i = 1; i < activeOrdersList.size(); i++) {
            tmpOrder = activeOrdersList.get(i);

            checkOrderTime = checkOrder.getDateTime();

            isTmpOrderBefore = tmpOrder.getDateTime().isBefore(checkOrderTime); //is tmpOrder before CheckOrder?

            if (isTmpOrderBefore) {
                checkOrder = tmpOrder;
                oldestOrder = checkOrder;
            }
        }

        if (oldestOrder == null) {
            throw new NoSuchElementException();
        }

        return oldestOrder;
    }


    /**
     * Prints all elements in the active orders list
     */
    public static void checkActiveOrders() {
        for (Order order : activeOrdersList) {
            System.out.println("\n" + order.toString());
        }
    }

    /**
     * Deletes an order from the active orders list
     *
     * @param order the order to delete
     */
    public static void deleteOrder(Order order) {
        activeOrdersList.remove(order);
    }

    /**
     * puts the order in the completed orders list and then removes it from the active orders list
     *
     * @param orderToComplete order to add to completedOrders and remove from activeOrders
     */
    public static void completeOrder(Order orderToComplete) {
        completedOrders.add(orderToComplete);
        activeOrdersList.remove(orderToComplete);
        fileWriter.updateOrderFile(completedOrders, "CompletedOrders");
        fileWriter.updateOrderFile(activeOrdersList, "ActiveOrders");
    }

    /**
     * Menu option
     *
     * @param order
     */
    public static void addPizzaToOrder(Order order) {
        System.out.println("\nAdding a pizza to current order:");
        order.addPizza(Main.inputInt("Add pizza #"), Main.inputInt(
                "What size? 1: Normal, 2: Deep Pan, 3: Family:"));
    }

    /**
     * Menu option
     * Prints all active orders in OrderSystem with a number so you can input which one to remove
     *
     * @param order order to remove a pizza from
     */
    //This method looks like crap ngl should probably be rewritten
    public static void removePizzaFromOrder(Order order) {
        System.out.println("\nRemove a pizza from the current order:\n");

        listCurrentOrder(order);

        int userchoice = -1;
        userchoice = Main.inputInt("Type the number of the pizza you want to delete: ");

        order.getOrderPizzaList().remove(userchoice - 1);

    }

    /**
     * prints all pizzas in current order
     *
     * @param order The order that is gonna be printed
     */
    public static void listCurrentOrder(Order order) {
        System.out.println("\nListing pizzas on current order:\n");
        int j = 1;
        for (Pizza pizza : order.getOrderPizzaList()) {
            System.out.println(j + ".\n" + pizza.toString());
            j++;
        }
    }


    /**
     * saves current order to active orders list and puts it in the ActiveOrders.txt file
     *
     * @param order The order to save
     */
    public static void saveCurrentOrder(Order order) {
        System.out.println("\nSaving order...");
        activeOrdersList.add(order);
        fileWriter.updateOrderFile(activeOrdersList, "ActiveOrders");
        System.out.println("Order Saved.");
    }
}
