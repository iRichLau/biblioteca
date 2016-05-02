package com.thoughtworks.tw101.biblioteca;

/**
 * Created by richardlau on 5/2/16.
 */
public class ListBookCommand implements Command {


    private BookCatalog bookCatalog;

    public ListBookCommand(BookCatalog bookCatalog) {
        this.bookCatalog = bookCatalog;
    }

    @Override
    public void run() {
        bookCatalog.listBooks();
    }
}
