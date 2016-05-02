package com.thoughtworks.tw101.biblioteca;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by toby on 4/26/16.
 */
public class BookCatalog {
    private List<Book> bookList;
    private PrintStream printStream;

    public BookCatalog(List<Book> bookList, PrintStream printStream) {
        this.bookList = bookList;
        this.printStream = printStream;
    }


    public void listBooks() {
        String header = String.format("|%1$-15s |%2$-15s |%3$-15s", "Title", "Author", "Year Published");

        printStream.println(header);
        for(Book curBook : bookList) {
            if(!curBook.isCheckedOut()) {
                printStream.println(curBook.details());
            }
        }
    }

    public void checkOutBookByTitle(String bookTitle) {
        for(Book book : bookList){
            if (book.getTitle().equals(bookTitle)){
                book.checkOut();
            }
        }
    }
}
