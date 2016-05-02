package com.thoughtworks.tw101.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class MenuTest {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private BookCatalog bookCatalog;
    private Menu menu;
    private CatalogManager catalogManager;
    private Map<String,Command> libraryCommand;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        libraryCommand = mock(Map.class);
        menu = new Menu(printStream, bufferedReader, libraryCommand);
    }

    @Test
    public void shouldPrintOptionsWhenMenuIsPrinted(){
        menu.printMenu();

        verify(printStream).println(contains("List Books"));
        verify(printStream).println(contains("Checkout Book"));
    }

    @Test
    public void shouldPrintBookListWhenOptionOneIsSelected() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("0");

        menu.runUserSelection();

        verify(bookCatalog).listBooks();
    }

    @Test
    public void shouldCheckOutABookWhenOptionTwoIsSelected() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2").thenReturn("0");

        menu.runUserSelection();

        verify(catalogManager).checkOutBookByTitle();
    }

    @Test
    public void shouldDisplayInvalidMessageWhenInvalidInput() throws IOException {
        userWillSelectInvalidThenValidOption();

        menu.runUserSelection();

        verify(printStream).println(contains("Select a valid option!"));
    }

    private void userWillSelectInvalidThenValidOption() throws IOException {
        when(bufferedReader.readLine()).thenReturn("Hey Nicolette").thenReturn("1").thenReturn("0");
    }

    @Test
    public void shouldStopAskingForUserInputWhenOptionQuitIsSelected() throws IOException {
        userSelectsQuitFromMenu();

        menu.runUserSelection();

        verify(bufferedReader, times(1)).readLine();

    }

    @Test
    public void shouldPromptForOptionWhenUserInputIsNotQuit() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "0");



    }

    private void userSelectsQuitFromMenu() throws IOException {
        when(bufferedReader.readLine()).thenReturn("0");
    }
}