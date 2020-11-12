package com.mariospizza;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class Order {
    private int orderID; //unique id for every order
    static int counter = 0;
    private ArrayList<Pizza> orderPizzaList = new ArrayList<>();
    private final LocalDateTime dateTime;
    private String dateTimeStr;
    private String dateTimePickupStr;

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
        dateTimePickupStr = dateTime.plusHours(1).format(DateTimeFormatter.ofPattern("hh:mm:ss"));
    }

    @Override
    public String toString() {
        String pizzaString = "";

        for (Pizza pizza: orderPizzaList) {
            pizzaString += pizza.toString() + "\n";
        }
        return "OrderID:" + orderID +
                "\nPick-Up Time: " + dateTimePickupStr +
                "\nList of all pizzas in this order:\n" + pizzaString;
    }

    /**
     *  Adds an order to the active order list
     *  Makes a copy of the a pizza object in the pizzaList
     *
     * @param pizzaMenuChoice which pizza is wanted
     * @param pizzaSizeChoice the size of the pizza input by user
     */
    public void addPizza(int pizzaMenuChoice, int pizzaSizeChoice) {
        ArrayList<Pizza> pizzaList = PizzaMenu.pizzaList;
        for(int i = 0; i < pizzaList.size(); i++) {
            if(pizzaList.get(i).getPizzaID() == pizzaMenuChoice) {
                int pizzaID = pizzaList.get(i).getPizzaID();
                String pizzaName = pizzaList.get(i).getPizzaName();
                String pizzaDescription = pizzaList.get(i).getPizzaDescription();
                double priceNormal = pizzaList.get(i).getPriceNormal();
                double priceDeep = pizzaList.get(i).getPriceDeep();
                double priceFamily = pizzaList.get(i).getPriceFamily();

                Pizza newPizza = new Pizza(pizzaID,pizzaName,pizzaDescription,priceNormal,priceDeep,priceFamily);
                newPizza.setPizzaSize(pizzaSizeChoice);
                getOrderPizzaList().add(newPizza);
            }
        }
    }

    /**
     * Menu for changing an order. Adding more pizzas or removing pizzas
     *
     */
    public void changeOrder() {
        String menuHeader = "CHANGE YOUR ORDER";
        String leadText = "choose option";
        String[] menuItems = {"Add a pizza", "Remove a pizza"};
        GenericMenu orderChangeMenu = new GenericMenu(menuHeader, leadText, menuItems);

        //prints the menu and uses user choice to select an option for switch
        orderChangeMenu.printMenu();
        switch (orderChangeMenu.readChoice()) {
            case 1:
                addPizza(Main.inputInt("Pizza number? "),Main.inputInt("Pizza size? "));
                break;
            case 2:
                OrderSystem.removePizzaFromOrder(this);
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTimeStr(String dateTimeStr) {
        this.dateTimeStr = dateTimeStr;
    }

    public String getDateTimeStr() {
        return dateTimeStr;
    }

    public String getDateTimePickupStr() {
        return dateTimePickupStr;
    }

    public void setDateTimePickupStr(String dateTimePickupStr) {
        this.dateTimePickupStr = dateTimePickupStr;
    }
}
