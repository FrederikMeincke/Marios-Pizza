package com.mariospizza;

import java.util.NoSuchElementException;

import static com.mariospizza.PizzaMenu.pizzaList;

public class Menus {

    /**
     * Main Menu build - While loop, Switch and case.
     */
    public static void mainMenu() {
        String headerText = "Mario's Pizzabar:\n";
        String leadText = "Choose an option: ";
        String[] menuItems = {"Show Pizza menu", "Check active orders",
                              "Add new order", "Change Order" ,"Complete Order", "Cancel Order", "Find Oldest Order",
                              "Check Statistics", "Exit"};
        boolean menuRun = true;
        int menuChoice;

        while (menuRun) {
            GenericMenu mainGenericMenu = new GenericMenu(headerText, leadText, menuItems);
            mainGenericMenu.printMenu();
            menuChoice = mainGenericMenu.readChoice();

            switch (menuChoice) {

                case 1:
                    PizzaMenu.formatPizzaMenu(pizzaList);
                        break;
                case 2:
                    OrderSystem.checkActiveOrders();
                    break;
                case 3:
                    addNewOrderMenu();
                    break;
                case 4:
                    if(OrderSystem.activeOrdersList.size() != 0) {
                        OrderSystem.findOrder(Main.inputInt("Order ID: ")).changeOrder();
                    } else {
                        System.out.println("No orders available to change at this time. ");
                    }
                    break;
                case 5:
                    OrderSystem.completeOrder(OrderSystem.findOrder(Main.inputInt(
                            "What is the orderID of the Order to complete?: ")));
                    break;
                case 6:
                    OrderSystem.deleteOrder(OrderSystem.findOrder(Main.inputInt(
                            "What is the orderID of the Order to cancel?: ")));
                    break;
                case 7:
                    System.out.println("Find oldest order");
                    try {
                        System.out.println(OrderSystem.findOldestOrder().toString());
                    } catch (NoSuchElementException e) {
                        e.toString();
                    } catch (IndexOutOfBoundsException iob) {
                        iob.toString();
                    }
                    break;
                case 8:
                    System.out.println("Check statistics");
                    System.out.println(MyStats.stats.mostPizzasSold());
                    System.out.println(MyStats.stats.total());
                    break;
                case 9:
                    menuRun = false;
                    break;
                default:
                    System.out.println("\nInvalid input.\nPlease try Again!");
                    break;
            }
        }
    }

    /**
     * Method that shows a menu to add/remove pizza(s) to an order, display pizza(s) in current order or save current
     * order to the active orders list
     */
    public static void addNewOrderMenu() {
        String headerText = "Mario's Pizzabar add Order:\n";
        String leadText = "Choose an option: ";
        String[] menuItems = {"Add Pizza", "Remove Pizza",
                "List Current Order", "Save Order", "Main Menu"};
        boolean menuRun = true;
        int menuChoice;
        Order order = new Order();

        while (menuRun) {
            GenericMenu addOrderGenericMenu = new GenericMenu(headerText, leadText, menuItems);
            addOrderGenericMenu.printMenu();
            menuChoice = addOrderGenericMenu.readChoice();
            switch (menuChoice) {
                case 1:
                    OrderSystem.addPizzaToOrder(order);
                    break;
                case 2:
                    OrderSystem.removePizzaFromOrder(order);
                    break;
                case 3:
                    OrderSystem.listCurrentOrder(order);
                    break;
                case 4:
                    OrderSystem.saveCurrentOrder(order);
                    System.out.println("Returning to Main Menu...");
                    menuRun = false;
                    break;
                case 5:
                    menuRun = false;
                    break;
                default:
                    System.out.println("\nInvalid input.\nPlease try Again:");
                    break;
            }
        }
    }
}
