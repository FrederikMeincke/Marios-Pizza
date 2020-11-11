package com.mariospizza;

import java.util.ArrayList;

public class MyStats {

    static MyStats stats = new MyStats();

    /*
Metoder til at udregne mest pop pizza
Jeg skal vel have en getter. Getteren til at hente data som kan bruges til at lave statestik.



Pseudo 0.2
//Variables for overall Pizzas sold
Private int pizzaSoldToday;
Private int pizzaSoldThisWeek;
Private int pizzaSoldInAMonth;
Private int pizzaSoldThisYear;
Private int allThePizzaSoldForNow;
// Variables for the most popular pizzas
Private string mostPopularPizza1;
Private string mostPopularPizza2;
Private string mostPopularPizza3;
Private String mostPopularPizza4;
// Temporarily variables
int allMyPizzasForToday;
int allMyPizzasThisWeek;
int allMyPizzasThisMonth;
int allThePizzas;
String MyBestChoice1;
String MyBestChoice2;
String MyBestChoice3;
String MyBestChoice4;
// Equation for setting the private ints
pizzaSoldToday = allMyPizzasForToday;
pizzaSoldThisWeek = allMyPizzasThisWeek;
pizzaSoldInAMonth = allMyPizzasThisMonth;
pizzaSoldThisYear = allMyPizzasThisYear;
allThePizzaSoldForNow = allThePizzas;
mostPopularPizza1 = MyBestChoice1;
mostPopularPizza2 = MyBestChoice2;
mostPopularPizza3 = MyBestChoice3;
mostPopularPizza4 = MyBestChoice4;



// Getters for temporaries
 public Pizza getPizzaToday() {
        return allMyPizzasForToday;
    }
     public Pizza getPizzaThisWeek() {
        return allMyPizzasThisWeek;
    }
     public Pizza getPizzaThisMonth() {
        return allMyPizzasThisMonth;
    }
 public Pizza getPizzaThisYear() {
        return allMyPizzasThisYear;
    }
 public Pizza getAllOfThePizzas() {
        return allThePizzas;
    }

//Get the 4 biggest quantity of pizzas in a while loop
public PizzaPop getArrayOfMostSoldPizza

// Set the values for String variables. Example: Manisa, Kokken’s special, Olimpos, Vegatar.
String MyBestChoice1
String MyBestChoice2
String MyBestChoice3
String MyBestChoice4



 //TODO: Kigge på nogle beregninger til statistik
     */

    ArrayList<Order> completedOrders = OrderSystem.completedOrders;
    int[] numbersOfPizzaSold;

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
                int currentPizzaID = currentPizza.getPizzaID(); //TODO: FIX
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

    public void numbersOfPizzaSoldArraySetup() {
        numbersOfPizzaSold = new int[OrderSystem.completedOrders.size()];
    }

    // Top three?
    public String mostPizzasSold() {
        //
        System.out.println("Start: 1");
        for(int i = 0; i < OrderSystem.completedOrders.size(); i++) {
            for(int j = 1; j <= OrderSystem.completedOrders.get(i).getOrderPizzaList().size(); j++) {
                if(OrderSystem.completedOrders.get(i).getOrderPizzaList().get(j).getPizzaID() == j) {
                    numbersOfPizzaSold[j]++;
                }
            }
        }

        System.out.println("next: 2");
        int numberMostPizzaSold = -1;
        String nameMostPizzaSold = "";
        for(int i = 1; i <= numbersOfPizzaSold.length; i++) {
            if(numbersOfPizzaSold[i] > numberMostPizzaSold) {
                numberMostPizzaSold = numbersOfPizzaSold[i];
                nameMostPizzaSold = scanPizzaMenu(i);
            }
        }
        System.out.println("Final: 3");
        String jabatheHut = "Most sold: " + nameMostPizzaSold + " Amount: " + numberMostPizzaSold;
        return jabatheHut;
    }

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
