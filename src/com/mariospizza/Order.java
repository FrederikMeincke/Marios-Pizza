package com.mariospizza;

import java.util.ArrayList;

public class Order {
    int orderID; //unique id for every order
    static int counter = 0;
    Pizza pizza;
    ArrayList<Pizza> orderPizzaList = new ArrayList<>();
    static ArrayList<Order> activeOrdersList = new ArrayList<>();
    static ArrayList<Order> completedOrders = new ArrayList<>();


    public Order(int orderID, Pizza pizza, ArrayList<Pizza> orderPizzaList, ArrayList<Order> activeOrdersList) {
        this.pizza = pizza;
        this.orderPizzaList = orderPizzaList;

        //counter for unique id for every order
        counter++;
        this.orderID = counter;
    }

    @Override
    public String toString() {
        String pizzaString = "";

        for (Pizza pizza: orderPizzaList) {
            pizzaString += pizza.toString() + "\n";
        }
        return "OrderID:" + orderID +
                "\nList of all pizzas in this order:\n" + pizzaString;
    }

    /**
     *  adds an order to the active order list
     *
     * @param orderPizza
     */
    public void addOrder(Pizza orderPizza) {
        orderPizzaList.add(orderPizza);
    }


    public void changeOrder(int orderID) {
        int whatToChange = -1; // int input by user to indicate what they want changed. Initialized as -1 for compiler
        //Order is reference type. so if i make a variable of it and change that variable they will both change?
        Order orderToChange = activeOrdersList.get(orderID);
        //TODO: menu here for what needs to be changed about the order

        String menuHeader = "CHANGE YOUR ORDER";
        String leadText = "choose option";
        String[] menuItems = {"option 1", "option 2", "option 3", "option 4", "option 5"};
        GenericMenu orderChangeMenu = new GenericMenu(menuHeader, leadText, menuItems);

        //prints the menu and uses user choice to select an option for switch
        orderChangeMenu.printMenu();
        switch (orderChangeMenu.readChoice()) {
            case 1:
                //System.out.println("add some extra salami");
                break;
            case 2:
                //System.out.println("make deep pan");
                break;
            case 3:
                //System.out.println("i want an extra pizza");
                break;
            case 4:
                //System.out.println("add some extra extra salami");
                break;
            case 5:
                //System.out.println("I want some disgusting pineapple on my pizza. Yikes cringe bro");
                break;
            default:
                System.out.println("invalid option");
                break;
        }
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
            } //TODO: maybe add an expection for this "no such order found"
        }
    }


    /**
     * Prints all the orders in the active orders list
     */
    public void checkActiveOrders() {
        for (Order order: activeOrdersList) {
            order.toString();
        }
    }

    /**
     * puts the order in the completed orders list and then removes it from the active orders list
     *
     * @param orderToComplete
     */
    public void completeOrder(Order orderToComplete) {
        completedOrders.add(orderToComplete);
        activeOrdersList.remove(orderToComplete);
    }

    /**
     * Deletes an active order
     *
     * @param order
     */
    public void deleteOrder(Order order) {
        activeOrdersList.remove(order);
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public ArrayList<Pizza> getOrderPizzaList() {
        return orderPizzaList;
    }

    public void setOrderPizzaList(ArrayList<Pizza> orderPizzaList) {
        this.orderPizzaList = orderPizzaList;
    }

    public ArrayList<Order> getActiveOrdersList() {
        return activeOrdersList;
    }

    public void setActiveOrdersList(ArrayList<Order> activeOrdersList) {
        this.activeOrdersList = activeOrdersList;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}
