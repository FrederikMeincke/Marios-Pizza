package com.mariospizza;

import java.util.ArrayList;

public class Order {
    private int orderID; //unique id for every order
    static int counter = 0;
    private ArrayList<Pizza> orderPizzaList = new ArrayList<>();

    /**
     * Constructor
     *
     *  orderID          Unique id for every order so we can differentiate between orders
     *
     *  orderPizzaList   A list of all the pizzas in the current order.
     *                   a customer might want a salami pizza and Hawaii pizza. these would both be contained
     *                   in the list
     */
    public Order() {
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
    public void addPizza(Pizza orderPizza) {
        orderPizzaList.add(orderPizza);
    }


    /**
     * Menu for changing an order.
     * unsure what these changes could be maybe adding an additional pizza or changing toppings?
     *
     * @param orderID
     */
    public void changeOrder(int orderID) {
        int whatToChange = -1; // int input by user to indicate what they want changed. Initialized as -1 for compiler
        //Order is reference type. so if i make a variable of it and change that variable they will both change?
        Order orderToChange = OrderSystem.activeOrdersList.get(orderID);
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
                //System.out.println("I want some disgusting pineapple on my pizza. Yikes bro that's cringe af");
                break;
            default:
                System.out.println("invalid option");
                break;
        }
    }

    public ArrayList<Pizza> getOrderPizzaList() {
        return orderPizzaList;
    }

    public void setOrderPizzaList(ArrayList<Pizza> orderPizzaList) {
        this.orderPizzaList = orderPizzaList;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}
