package com.thoughtworks.tw101.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by richardlau on 4/29/16.
 */
public class CatalogManager {


    private BookCatalog bookCatalog;
    private BufferedReader bufferedReader;

    public CatalogManager(BookCatalog bookCatalog, BufferedReader bufferedReader) {
        this.bookCatalog = bookCatalog;
        this.bufferedReader = bufferedReader;
    }

    public void checkOutBookByTitle() {
        String bookTitle = getBufferedReaderInput();
        bookCatalog.checkOutBookByTitle(bookTitle);
    }

    private String getBufferedReaderInput() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
