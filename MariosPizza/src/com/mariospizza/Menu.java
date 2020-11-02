package com.mariospizza;
import java.util.Scanner;

public class Menu {
    private String menuHeader;
    private String leadText;
    private String[] menuItems;


    /**
     * constructor
     *
     * @param menuHeader The title for the menu
     * @param menuItems An String array that contains all the menu options
     * @param leadText Prompt for user input
     */
    public Menu(String menuHeader, String leadText, String[] menuItems) {
        this.menuHeader = menuHeader;
        this.leadText = leadText;
        this.menuItems = menuItems;
    }


    /**
     * reads user input. Validates for positive integers
     *
     * @return int < 0 input by user
     */
    int readUserInput() {
        boolean runFlag = true;
        int tempInput;
        int input = -1;

        //Scanner obj
        Scanner scn = new Scanner(System.in);

        do {
            if (scn.hasNextInt()) {
                tempInput = scn.nextInt();

                if (tempInput >= 0) {
                    input = tempInput;
                    runFlag = false;
                } else {
                    System.out.println("Please input a non-negative integer");
                    scn.nextLine();
                }
            } else {
                System.out.println("Please input an integer");
                scn.nextLine();
            }
        } while (runFlag);

        return input;
    }


    /**
     * Prints menu in the following format:
     *
     *      menuHeader
     *
     *      Menu item 1:
     *      Menu item 2:
     *      Menu item 3:
     *      .
     *      .
     *      .
     *
     *      leadText
     */
    void printMenu() {
        System.out.println("\n" + menuHeader + "\n");

        for (String menuItems : menuItems) {
            System.out.println(menuItems);
        }
        System.out.println();

        System.out.print(leadText);
    }
}
