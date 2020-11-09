package com.mariospizza;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private int orderID; //unique id for every order
    static int counter = 0;
    private ArrayList<Pizza> orderPizzaList = new ArrayList<>();
    private LocalDateTime dateTime;
    private String dateTimeStr;

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
        dateTime = LocalDateTime.now();
        dateTimeStr = dateTime.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
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
     *  Makes a copy of the a pizza object in the pizzaList
     *
     * @param pizzaMenuChoice which pizza is wanted
     * @param pizzaSizeChoice the size of the pizza input by user
     */
    public void addPizza(int pizzaMenuChoice, int pizzaSizeChoice) {
        ArrayList<Pizza> pizzaList = PizzaMenu.pizzaList;
        Pizza newPizza = new Pizza();
        for(int i = 0; i < pizzaList.size(); i++) {
            if(pizzaList.get(i).getPizzaID() == pizzaMenuChoice) {
                newPizza.setPizzaID(pizzaList.get(i).getPizzaID());
                newPizza.setPizzaName(pizzaList.get(i).getPizzaName());
                newPizza.setPizzaDescription(pizzaList.get(i).getPizzaDescription());
                newPizza.setPizzaSize(pizzaSizeChoice);
                newPizza.setPriceNormal(pizzaList.get(i).getPriceNormal());
                newPizza.setPriceDeep(pizzaList.get(i).getPriceDeep());
                newPizza.setPriceFamily(pizzaList.get(i).getPriceFamily());
                //Pizza pizzaChoice = pizzaList.get(i);
                //pizzaChoice.setPizzaSize(pizzaSizeChoice);
                //orderPizzaList.add(pizzaChoice);
                orderPizzaList.add(newPizza);
            }
        }
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

    /**
     * Get order from out pizzalist
     * @return
     */
    public ArrayList<Pizza> getOrderPizzaList() {
        return orderPizzaList;
    }

    /**
     * Set order from the arraylist, to pizzalist
     * @param orderPizzaList
     */
    public void setOrderPizzaList(ArrayList<Pizza> orderPizzaList) {
        this.orderPizzaList = orderPizzaList;
    }

    /**
     * Get the order ID
     * @return
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * Set and orderID as an integer
     * @param orderID
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
