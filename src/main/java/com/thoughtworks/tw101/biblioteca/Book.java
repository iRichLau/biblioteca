package com.thoughtworks.tw101.biblioteca;

/**
 * Created by toby on 4/26/16.
 */
public class Book {

    private final String title;
    private final String author;
    private final String yearPublished;
    private boolean checkedOut;

    public Book(String title, String author, String yearPublished) {

        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        checkedOut = false;
    }

    public String details(){
        String detailString = String.format("|%1$-15s |%2$-15s |%3$-15s", title, author, yearPublished);
        return detailString;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public String getTitle() {
        return title;
    }
}
