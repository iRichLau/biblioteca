package com.thoughtworks.tw101.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

public class Menu {


    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Map<String, Command> libraryCommands;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, Map<String, Command> LibraryCommands) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        libraryCommands = LibraryCommands;
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


    public void runUserSelection() {
        String userInput = getBufferedReaderInput();

        while (!libraryCommands.containsKey(userInput)) {
            printStream.println("Select a valid option!");
            userInput = getBufferedReaderInput();
        }

            libraryCommands.get(userInput).run();
            printMenu();
            runUserSelection();

    }
}
