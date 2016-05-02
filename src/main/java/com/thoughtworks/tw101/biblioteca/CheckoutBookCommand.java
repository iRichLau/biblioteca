package com.thoughtworks.tw101.biblioteca;

/**
 * Created by richardlau on 5/2/16.
 */
public class CheckoutBookCommand implements Command {

    private BookCatalog bookCatalog;

    public CheckoutBookCommand(BookCatalog bookCatalog){

        this.bookCatalog = bookCatalog;
    }
    @Override
    public void run(String bookTitle) {
        bookCatalog.checkOutBookByTitle(bookTitle);
    }
}
