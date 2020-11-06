package com.mariospizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Marios Pizza Menu POS for command line application
 * @author Frederik M., Jimmy, Kasper, Mads, Philip
 * @version 0.4
 */

public class Main {

    static MyFileReader fileReader = new MyFileReader();
    static ArrayList<Pizza> pizzaList = fileReader.loadPizzaMenu("PizzaMenuClean");

    public static String printSymbols(String symbol, String line, int formatLength) {
        String dotSpace = "";
        int dotLength = Math.abs(line.length()-formatLength);

        for(int i = 0; i < dotLength; i++) {
            dotSpace += symbol;
        }
        return dotSpace;
    }

    public static String formatPizzaHeader(double number) {
        if(number == 0) {
            return "";
        } else {
            String string = String.format("%.0f",number);
            return string;
        }
    }

    public static void formatPizzaMenu(ArrayList<Pizza> pizzaList) throws FileNotFoundException {

        for(int i = 0; i < pizzaList.size(); i++) {
            String pizzaID = formatPizzaHeader(pizzaList.get(i).getPizzaID());
            String pizzaName = pizzaList.get(i).getPizzaName();
            String pizzaDescription = pizzaList.get(i).getPizzaDescription();

            String priceNormal = formatPizzaHeader(pizzaList.get(i).getPriceNormal()) + " | ";
            String priceDeep = formatPizzaHeader(pizzaList.get(i).getPriceDeep()) + " | ";
            if(priceDeep.equals(" | ")) {
                priceDeep = "   | ";
            }
            String priceFamily = formatPizzaHeader(pizzaList.get(i).getPriceFamily());

            //String pizzaDots = printPizzaDots(pizzaList.get(i), 100);
            String pizzaLine = pizzaID+pizzaName+pizzaDescription+priceNormal+priceDeep+priceFamily;
            String pizzaDots = printSymbols(".", pizzaLine,100);
            /*System.out.println( pizzaID + ". " +
                    pizzaName + ", " +
                    pizzaDescription +
                    pizzaDots +
                    priceNormal);

             */

            if(pizzaID != "") {
                pizzaID += ". ";
                String pizzaIDSpace = printSymbols(" ",pizzaID,4); //TODO: include this in pizzaID instead, to reduce variables in the StringFormat
                System.out.printf("%s%s%s,%s%s%s%s%s\n",pizzaID,pizzaIDSpace,pizzaName,pizzaDescription,pizzaDots,priceNormal,priceDeep,priceFamily);
            } else {
                String titleLine = pizzaName + "alm | " + "deep | " + "fam";
                System.out.println("\n" + pizzaName + printSymbols(" ", titleLine,105)+"Alm |" + "Deep| " + "Fam");
            }
        }
    }

    public static void pizzaInfo(int i) {
        System.out.println(pizzaList.get(i).getPizzaID());
        System.out.println(pizzaList.get(i).getPizzaName());
        System.out.println(pizzaList.get(i).getPizzaDescription());
        System.out.println(pizzaList.get(i).getPriceNormal());
    }

    public static void main(String[] args) throws FileNotFoundException {
	// Program that lists a Pizza Menu,
    // can take orders and sort them chronologically based on time.
    // The system also needs to be able to delete an order once it has been retrieved and paid for.
       // Menus.mainMenu();
        formatPizzaMenu(pizzaList);


    }
}
