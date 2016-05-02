package com.thoughtworks.tw101.biblioteca;

import org.junit.Test;
import org.mockito.Matchers;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.*;


/**
 * Created by krojas on 4/27/16.
 */
public class BookTest {

    @Test
    public void shouldPrintAuthorAndYearPublishedInDetails(){
        Book book = new Book("The Metamorphosis", "Franz Kafka", "1915");
        String bookDetails = book.details();
        assertTrue(bookDetails.contains("Franz Kafka"));
        assertTrue(bookDetails.contains("1915"));

    }

    @Test
    public void shouldMarkBookAsCheckedOutAfterBookIsCheckedOut() {
        Book book = new Book("The Metamorphosis", "Franz Kafka", "1915");

        book.checkOut();

        assertTrue(book.isCheckedOut());
    }

}