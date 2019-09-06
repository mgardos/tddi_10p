package ar.net.mgardos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Cart {
    static final String INVALID_BOOKS_NUMBER = "Invalid number of books: %d, number must be greater than 0.";
    static final String INVALID_PUBLISHER = "Invalid publisher: %s, only books from Tus Libros can be added to the cart.";
    private List<Book> books;

    public Cart() {
        books = new ArrayList<>();
    }

    public Cart(Set<String> catalog) {
        books = new ArrayList<>();
    }

    public Boolean isEmpty() {
        return books.isEmpty();
    }

    public void add(Book aBook) {
        books.add(aBook);
    }

    public void add(String aBook) {

    }

    public void add(int booksCount, Book aBook) {
        if (booksCount <= 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < booksCount; i++) {
            books.add(aBook);
        }
    }

    public int size() {
        return books.size();
    }
}
