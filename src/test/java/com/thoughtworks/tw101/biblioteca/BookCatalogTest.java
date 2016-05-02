package com.thoughtworks.tw101.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.AdditionalMatchers.not;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

/**
 * Created by toby on 4/26/16.
 */
public class BookCatalogTest {
    private PrintStream printStream;
    private List<Book> bookList;
    private BookCatalog bookCatalog;

    @Before
    public void setup(){
        bookList = new ArrayList<>();
        printStream = mock(PrintStream.class);
        bookCatalog = new BookCatalog(bookList, printStream);
    }

    @Test
    public void shouldPrintAllBookTitlesWhenMoreThanOneBookInLibrary() {

        Book book1 = mock(Book.class);
        when(book1.details()).thenReturn("Author1 Year1");
        Book book2 = mock(Book.class);
        when(book2.details()).thenReturn("Author2 Year2");

        bookList.add(book1);
        bookList.add(book2);
        bookCatalog.listBooks();

        verify(printStream).println(contains("Author1 Year1"));
        verify(printStream).println(contains("Author2 Year2"));
    }

    @Test
    public void shouldOnlyPrintHeaderWhenBookListIsEmpty(){

        bookCatalog.listBooks();
        verify(printStream).println(contains("|Title"));
        verifyNoMoreInteractions(printStream);
    }

    @Test
    public void shouldPrintAuthorColumn(){
        bookCatalog.listBooks();
        verify(printStream).println(contains("Author"));
    }

    @Test
    public void shouldPrintYearPublishedColumn(){
        bookCatalog.listBooks();
        verify(printStream).println(contains("Year Published"));
    }

    @Test
    public void shouldNotDisplayBookWhenBookIsCheckedOut(){
        Book checkedOutBook = mock(Book.class);
        Book notCheckedOutBook = mock(Book.class);
        when(checkedOutBook.isCheckedOut()).thenReturn(true);
        when(notCheckedOutBook.isCheckedOut()).thenReturn(false);
        when(checkedOutBook.details()).thenReturn("Book1 Details");
        when(notCheckedOutBook.details()).thenReturn("Book2 Details");

        bookList.add(checkedOutBook);
        bookList.add(notCheckedOutBook);

        bookCatalog.listBooks();

        verify(printStream).println(contains("Book2 Details"));
        verify(printStream).println(not(contains("Book2 Details")));
    }

    @Test
    public void shouldCheckOutBookWhenTitleIsGiven(){
        Book book = mock(Book.class);
        when(book.getTitle()).thenReturn("Book Title");

        bookList.add(book);

        bookCatalog.checkOutBookByTitle("Book Title");

        verify(book).checkOut();
    }

}