package com.thoughtworks.tw101.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class MenuTest {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private BookCatalog bookCatalog;
    private Menu menu;
    private CatalogManager catalogManager;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        bookCatalog = mock(BookCatalog.class);
        catalogManager = mock(CatalogManager.class);
        menu = new Menu(printStream, bufferedReader, bookCatalog, catalogManager);
    }

    @Test
    public void shouldPrintOptionsWhenMenuIsPrinted(){
        menu.printMenu();

        verify(printStream).println(contains("List Books"));
        verify(printStream).println(contains("Checkout Book"));
    }

    @Test
    public void shouldPrintBookListWhenOptionOneIsSelected() throws IOException {
        menu.runSelectedOption("1");

        verify(bookCatalog).listBooks();
    }

    @Test
    public void shouldCheckOutABookWhenOptionTwoIsSelected(){
        menu.runSelectedOption("2");

        verify(catalogManager).checkOutBookByTitle();
    }

    @Test
    public void shouldDisplayInvalidMessageWhenInvalidInput() throws IOException {
        userWillSelectInvalidThenValidOption();
        menu.getValidUserInput();

        verify(printStream).println(contains("Select a valid option!"));
    }

    private void userWillSelectInvalidThenValidOption() throws IOException {
        when(bufferedReader.readLine()).thenReturn("Hey Nicolette").thenReturn("1");
    }

    @Test
    public void shouldStopAskingForUserInputWhenOptionQuitIsSelected() throws IOException {
        userSelectsQuitFromMenu();

        menu.runUserInput();

        verify(bufferedReader, times(1)).readLine();

    }

    private void userSelectsQuitFromMenu() throws IOException {
        when(bufferedReader.readLine()).thenReturn("0");
    }
}