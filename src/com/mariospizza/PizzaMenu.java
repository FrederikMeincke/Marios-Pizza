package com.mariospizza;

import java.util.ArrayList;

public class PizzaMenu {
    static MyFileReader fileReader = new MyFileReader();
    static ArrayList<Pizza> pizzaList = fileReader.loadPizzaMenu("PizzaMenuClean");

    /**
     * Returns a String with a finite number of String symbol, depending on the length of String line and the desired int formatLength
     * @param symbol
     * @param line
     * @param formatLength
     * @return
     */
    public static String printSymbols(String symbol, String line, int formatLength) {
        String dotSpace = "";
        int dotLength = Math.abs(line.length()-formatLength);

        for(int i = 0; i < dotLength; i++) {
            dotSpace += symbol;
        }
        return dotSpace;
    }

    /**
     * Formats the printed menu line from our PizzaMenu ArrayList<Pizza> so that no number is displayed in front of headers
     * and the correct number without decimals in front of pizzas. Headers are stored with a "0" in front of their name.
     * @param number
     * @return
     */
    public static String formatPizzaHeader(double number) { //TODO: refactor method name
        if(number == 0) {
            return "";
        } else {
            String string = String.format("%.0f",number);
            return string;
        }
    }

    /**
     * Taking the information from each Pizza object in the ArrayList<Pizza> and formats it into something readable
     * and presentable. It is formatted to resemble a "physical" pizza menu.
     * @param pizzaList
     */
    public static void formatPizzaMenu(ArrayList<Pizza> pizzaList) {
        int menuNumberLength = 4;
        int menuPizzaLineLength = 100;
        int menuHeaderLineLength = 103;

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

            if(pizzaID != "") {
                pizzaID += ". ";
                String pizzaIDSpace = printSymbols(" ",pizzaID,menuNumberLength); // TODO: include this in pizzaID to reduce variables in StringFormat
                String pizzaLine = pizzaID+pizzaIDSpace+pizzaName+pizzaDescription+priceNormal+priceDeep+priceFamily;
                String pizzaDots = printSymbols(".", pizzaLine,menuPizzaLineLength);
                System.out.printf("%s%s%s,%s%s%s%s%s\n",pizzaID,pizzaIDSpace,pizzaName,pizzaDescription,pizzaDots,priceNormal,priceDeep,priceFamily);
            } else {
                String titleLine = pizzaName + "alm | " + "deep | " + "fam";
                System.out.println("\n" + pizzaName + printSymbols(" ", titleLine,menuHeaderLineLength)+ "Alm |" + "Deep| " + "Fam");
            }
        }
    }
}
