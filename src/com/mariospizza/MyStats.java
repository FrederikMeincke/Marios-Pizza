package com.mariospizza;

import java.util.ArrayList;

public class MyStats {

    static MyStats stats = new MyStats();

    ArrayList<Order> completedOrders = OrderSystem.completedOrders;
    ArrayList<PizzaStat> statList = new ArrayList<>();

    /**
     * We needed a new object to store the counter information.
     */
    public class PizzaStat {
        int id = -1;
        int counter = 0;

        public void setId(int id) {
            this.id = id;
        }
        public PizzaStat(int id) {
            this.id = id;
        }
    }

    /**
     * TRIPLE FOR LOOP LET'S GOOOOO
     */
    public double total() {
        double revenue = 0;
        for(int i = 0; i < completedOrders.size(); i++) {
            Order currentOrder = completedOrders.get(i);

            for(int j = 0; j < currentOrder.getOrderPizzaList().size(); j++) {
                Pizza currentPizza = currentOrder.getOrderPizzaList().get(j);

                double pizzaPrice = 0;

                int currentPizzaSize = currentPizza.getPizzaSize();
                if(currentPizzaSize == 1) {
                    pizzaPrice = currentPizza.getPriceNormal();
                } else if(currentPizzaSize == 2) {
                    pizzaPrice = currentPizza.getPriceDeep();
                } else if(currentPizzaSize == 3) {
                    pizzaPrice = currentPizza.getPriceFamily();
                }
                revenue += pizzaPrice;
            }
        }
        return revenue;
    }

    /**
     * Makes sure our statList is the same size as our PizzaMenu.pizzaList
     */
    public void setupStatList() {
        statList.clear();
        statList.add(new PizzaStat(0));
        for(int i = 1; i <= PizzaMenu.pizzaList.size(); i++) {
           statList.add(new PizzaStat(i));
        }
    }

    /**
     * Runs through our ArrayList and checks what pizza has been most popular in terms of unit sales.
     * @return
     */
    public String mostPizzasSold() {
        setupStatList();
        for(int i = 0; i < completedOrders.size(); i++) {
            System.out.println("son of a b");
            for(int j = 0; j < completedOrders.get(i).getOrderPizzaList().size(); j++) {
                System.out.println("what");
                for(int y = 1; y < PizzaMenu.pizzaList.size(); y++) {
                    if(completedOrders.get(i).getOrderPizzaList().get(j).getPizzaID() == PizzaMenu.pizzaList.get(y).getPizzaID()) {
                        System.out.println("why");
                        statList.get(y).counter++;
                    }
                }
            }
        }

        int numberMostPizzaSold = -1;
        String nameMostPizzaSold = "";
        for(int i = 1; i < statList.size(); i++) {
            if(statList.get(i).counter > numberMostPizzaSold) {
                numberMostPizzaSold = statList.get(i).counter;
                nameMostPizzaSold = scanPizzaMenu(i);
            }
        }

        String mostSold = "Most sold: " + nameMostPizzaSold + " Amount: " + numberMostPizzaSold;
        return mostSold;
    }

    /**
     * Finds the pizzaName in the PizzaMenu.pizzaList from the pizzaID.
     * @param pizzaID
     * @return
     */
    public String scanPizzaMenu(int pizzaID) {
        ArrayList<Pizza> pizzaList = PizzaMenu.pizzaList;
        for(int i = 0; i < pizzaList.size(); i++) {
            if(pizzaList.get(i).getPizzaID() == pizzaID) {
                return pizzaList.get(i).getPizzaName();
            }
        }
        return null;
    }


}
