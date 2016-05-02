import com.thoughtworks.tw101.biblioteca.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Ender", "Orson", "1990"));
        bookList.add(new Book("The Jungle Book", "Some Person", "1967"));
        BookCatalog bookCatalog = new BookCatalog(bookList, System.out);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        CatalogManager catalogManager = new CatalogManager(bookCatalog, bufferedReader);
        Menu menu = new Menu(System.out, bufferedReader, bookCatalog, catalogManager);
        Biblioteca biblioteca = new Biblioteca(System.out, menu);
        biblioteca.start();
    }
}
