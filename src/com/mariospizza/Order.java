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

    //adds an order to the active orders list
    public void addOrder(Pizza orderPizza) {
        orderPizzaList.add(orderPizza);
    }

    public void changeOrder() {

    }

    public void cancelOrder(int orderNumber) {
        for (int i = 0; i < activeOrdersList.size(); i++) {
            if (orderNumber == activeOrdersList.get(i).getOrderID()) {
                //deleteOrder(orderToCancel);

            }
        }
    }

    public void checkActiveOrders() {

    }

    public void completeOrder(Order orderToComplete) {
        completedOrders.add(orderToComplete);
    }

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
