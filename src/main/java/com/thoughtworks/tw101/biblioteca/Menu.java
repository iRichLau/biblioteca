package com.thoughtworks.tw101.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Menu {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private BookCatalog bookCatalog;
    private CatalogManager catalogManager;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, BookCatalog bookCatalog, CatalogManager catalogManager) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.bookCatalog = bookCatalog;
        this.catalogManager = catalogManager;
    }

    public void printMenu() {
        printStream.println("Select Option:");
        printStream.println("1. List Books");
        printStream.println("2. Checkout Book");
    }

    private String getBufferedReaderInput() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void runUserInput() {
        String validUserInput = getValidUserInput();
        while(!validUserInput.equals("0")) {
            runSelectedOption(validUserInput);
            validUserInput = getValidUserInput();
        }
    }

    public String getValidUserInput() {
        String userInput = getBufferedReaderInput();

        while (!isValidUserInput(userInput)) {
            printStream.println("Select a valid option!");
            userInput = getBufferedReaderInput();
        }

        return userInput;
    }

    private boolean isValidUserInput(String userInput) {
        return userInput.equals("1") || userInput.equals("0") ||
                userInput.equals("2");
    }

    public void runSelectedOption(String userInput) {
        if(userInput.equals("1")) {
            bookCatalog.listBooks();
        }
        else if(userInput.equals("2")) {
            catalogManager.checkOutBookByTitle();
        }
    }
}
