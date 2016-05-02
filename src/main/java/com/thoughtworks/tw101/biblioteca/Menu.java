package com.thoughtworks.tw101.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Menu {

    public static final String LIST_BOOK_OPTION = "1";
    public static final String QUIT_OPTION = "0";
    public static final String CHECKOUT_BOOK = "2";
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
        printStream.println("0. Quit");
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
        while(!validUserInput.equals(QUIT_OPTION)) {
            runSelectedOption(validUserInput);
            printMenu();
            validUserInput = getValidUserInput();
        }

    }

    private String getValidUserInput() {
        String userInput = getBufferedReaderInput();

        while (!isValidUserInput(userInput)) {
            printStream.println("Select a valid option!");
            userInput = getBufferedReaderInput();
        }

        return userInput;
    }

    private boolean isValidUserInput(String userInput) {
        return userInput.equals(LIST_BOOK_OPTION) || userInput.equals(QUIT_OPTION) ||
                userInput.equals(CHECKOUT_BOOK);
    }

    private void runSelectedOption(String userInput) {
        if(userInput.equals(LIST_BOOK_OPTION)) {
            bookCatalog.listBooks();

        }
        else if(userInput.equals(CHECKOUT_BOOK)) {
            printStream.println("Enter book title: ");
            catalogManager.checkOutBookByTitle();
            printStream.println("Book has successfully been checked out.");
        }
    }
}
