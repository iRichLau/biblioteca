package com.thoughtworks.tw101.biblioteca;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by richardlau on 4/29/16.
 */
public class CatalogManagerTest {
    private BookCatalog bookCatalog;
    private CatalogManager catalogManager;
    private BufferedReader bufferedReader;

    @Test
    public void shouldCheckOutBookWhenUserInputsBookTitle() throws IOException {
        bookCatalog = mock(BookCatalog.class);
        bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("Book Title");
        catalogManager = new CatalogManager(bookCatalog, bufferedReader);

        catalogManager.checkOutBookByTitle();

        verify(bookCatalog).checkOutBookByTitle("Book Title");
    }
}