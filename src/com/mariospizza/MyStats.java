package com.mariospizza;

import java.util.ArrayList;

public class MyStats {


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

    /**
     * TRIPLE FOR LOOP LET'S GOOOOO
     */
    public void total() {
        for(int i = 0; i < completedOrders.size(); i++) {
            Order currentOrder = completedOrders.get(i);

            for(int j = 0; j < currentOrder.getOrderPizzaList().size(); j++) {
                Pizza currentPizza = currentOrder.getOrderPizzaList().get(j);
                int currentPizzaID = currentPizza.getPizzaID();
                int currentPizzaSize = currentPizza.getPizzaSize();

            }
        }
    }
}
