package com.mariospizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericMenuTest {
    String headerText = "test:\n";
    String leadText = "test an test: ";
    String[] menuItems = {"Show test menu", "Check test test ",
            "test tset", "123" ,"123 123", "4125 412", "61512", "uwu"};

    GenericMenu testMenu = new GenericMenu(headerText, leadText, menuItems);


    @Test
    void printMenu() {
        testMenu.printMenu();
    }

    @Test
    void readChoice() { //requires user input. cant be tested
        //testMenu.readChoice();
    }
}
