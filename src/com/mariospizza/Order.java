package com.mariospizza;

import java.util.ArrayList;

public class Order {
    Pizza pizza;
    ArrayList<Pizza> orderPizzaList = new ArrayList<>();
    ArrayList<Order> activeOrdersList = new ArrayList<>();


    public Order(Pizza pizza, ArrayList<Pizza> orderPizzaList, ArrayList<Order> activeOrdersList) {
        this.pizza = pizza;
        this.orderPizzaList = orderPizzaList;
        this.activeOrdersList = activeOrdersList;
    }

    public void addOrder(Pizza orderPizza) {
        orderPizzaList.add(orderPizza);
    }

    public void changeOrder() {

    }

    public void cancelOrder() {

    }

    public void checkActiveOrders() {

    }

    public void completeOrder() {

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

}
