package com.mariospizza;
import java.util.Scanner;

public class GenericMenu {
    private String menuHeader;
    private String leadText;
    private String[] menuItems;

    /**
     * Array to keep track on different parts of the menu
     * @param menuHeader
     * @param leadText
     * @param menuItems
     */
    public GenericMenu(String menuHeader, String leadText, String[] menuItems) {
        this.menuHeader = menuHeader;
        this.leadText = leadText;
        this.menuItems = menuItems;
    }

    /**
     * Printing out menu
     */
    public void printMenu() {
        String printString = menuHeader + "\n";

        for (int i = 1; i <= menuItems.length; i++) {
            printString += i + ". " + menuItems[i - 1] + "\n";
        }
        System.out.println("\n" + printString);
    }

    /**
     * Dictates the users choice navigating the menu
     * @return
     */
    public int readChoice() {
        Scanner scanner = new Scanner(System.in);
        boolean validChoice = false;
        int choice = -1;

        while (! validChoice) {
            System.out.print(leadText);
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                validChoice = true;
            } else {
                scanner.nextLine();
            }
        }
        return choice;
    }
}


