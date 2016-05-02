package com.thoughtworks.tw101.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Biblioteca {

    private PrintStream printStream;
    private Menu menu;

    public Biblioteca(PrintStream printStream, Menu menu) {
        this.printStream = printStream;
        this.menu = menu;
    }

    public void start() {
        printWelcomeMessage();
        menu.printMenu();
        menu.runUserInput();
    }

    private void printWelcomeMessage() {
        printStream.println("Welcome");
    }

}
