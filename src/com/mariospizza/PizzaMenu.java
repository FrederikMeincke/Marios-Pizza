package com.mariospizza;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PizzaMenu {
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

    public static String formatPizzaHeader(double number) { //TODO: refactor method name
        if(number == 0) {
            return "";
        } else {
            String string = String.format("%.0f",number);
            return string;
        }
    }

    public static void formatPizzaMenu(ArrayList<Pizza> pizzaList) {

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
            //String pizzaLine = pizzaID+pizzaName+pizzaDescription+priceNormal+priceDeep+priceFamily+;
            //String pizzaDots = printSymbols(".", pizzaLine,100);
            /*System.out.println( pizzaID + ". " +
                    pizzaName + ", " +
                    pizzaDescription +
                    pizzaDots +
                    priceNormal);
             */

            if(pizzaID != "") {
                pizzaID += ". ";
                String pizzaIDSpace = printSymbols(" ",pizzaID,4); // TODO: include this in pizzaID to reduce variables in StringFormat
                String pizzaLine = pizzaID+pizzaIDSpace+pizzaName+pizzaDescription+priceNormal+priceDeep+priceFamily;
                String pizzaDots = printSymbols(".", pizzaLine,100);
                System.out.printf("%s%s%s,%s%s%s%s%s\n",pizzaID,pizzaIDSpace,pizzaName,pizzaDescription,pizzaDots,priceNormal,priceDeep,priceFamily);
            } else {
                String titleLine = pizzaName + "alm | " + "deep | " + "fam";
                System.out.println("\n" + pizzaName + printSymbols(" ", titleLine,103)+ "Alm |" + "Deep| " + "Fam");
            }
        }
    }


    public static void run() {
        formatPizzaMenu(pizzaList);
    }
}
