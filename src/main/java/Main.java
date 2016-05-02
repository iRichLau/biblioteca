import com.thoughtworks.tw101.biblioteca.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Ender", "Orson", "1990"));
        bookList.add(new Book("The Jungle Book", "Some Person", "1967"));
        BookCatalog bookCatalog = new BookCatalog(bookList, System.out);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        CatalogManager catalogManager = new CatalogManager(bookCatalog, bufferedReader);
        Map<String, Command> libraryCommands = new HashMap<>();
        libraryCommands.put("0", new QuitCommand());
        libraryCommands.put("1", new ListBookCommand(bookCatalog));
        libraryCommands.put("2", new CheckoutBookCommand(bookCatalog));
        Menu menu = new Menu(System.out, bufferedReader, libraryCommands);
        Biblioteca biblioteca = new Biblioteca(System.out, menu);
        biblioteca.start();
    }
}
