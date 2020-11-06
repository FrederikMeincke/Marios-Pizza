package com.mariospizza;

import java.util.ArrayList;

public class OrderSystem {
    static ArrayList<Order> activeOrdersList = new ArrayList<>();
    static ArrayList<Order> completedOrders = new ArrayList<>();

    /**
     * Arraylist containing activeorderlist and completedorders.
     * @param activeOrdersList
     * @param completedOrders
     */
    public OrderSystem(ArrayList<Order> activeOrdersList, ArrayList<Order> completedOrders) {
        this.activeOrdersList = activeOrdersList;
        this.completedOrders = completedOrders;
    }

    /**
     * Method that adds an oder containing pizza(s) to the order system
     */
    public static void addOrder() {
        String headerText = "Mario's Pizzabar add Order:\n";
        String leadText = "Choose an option: ";
        String[] menuItems = {"Add Pizza", "Remove Pizza",
                "List Current Order", "Exit"};
        boolean menuRun = true;
        int menuChoice = -1;

        while (menuRun) {
            GenericMenu addOrderGenericMenu = new GenericMenu(headerText, leadText, menuItems);
            addOrderGenericMenu.printMenu();
            menuChoice = addOrderGenericMenu.readChoice();
                switch (menuChoice) {
                    case 1:
                        System.out.println("Add Pizza");
                        break;
                    case 2:
                        System.out.println("Remove Pizza");
                        break;
                    case 3:
                        System.out.println("List Current Order");
                        break;
                    case 4:
                        menuRun = false;
                        break;
                    default:
                        System.out.println("\nInvalid input.\nPlease try Again!");
                        break;
                }

            }
        }//TODO: invalid input creates infinite loop - fix this

    /**
     * Method for returning an Order from an orderID.
     * Useful for other methods so they can figure out which Order to manipulate
     *
     * @param orderID
     * @return Order in activeOrdersList if it matches orderID else returns null
     */
    public Order findOrder(int orderID) {
        Order order = null;

        for (Order activeOrder: activeOrdersList) {
            if (activeOrder.getOrderID() == orderID) {
                return activeOrder;
            }
        }
        return null; //TODO: Maybe add an exception for Order not found?
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
     * @param orderToRemove this should be found out by inputing the orderID into the findOrder method
     */
    public void cancelOrder(Order orderToRemove) {
        deleteOrder(orderToRemove);
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
