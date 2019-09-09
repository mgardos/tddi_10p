package ar.net.mgardos.seller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Cart {
    static final String INVALID_BOOKS_NUMBER = "Invalid number of books: %d, number must be greater than 0.";
    static final String INVALID_PUBLISHER = "Invalid publisher, only books from Tus Libros can be added to the cart.";
    private List<Book> _books;
    private Set<String> _catalog;

    public Cart() {
        _books = new ArrayList<>();
    }

    public Cart(Set<String> catalog) {
        this();
        _catalog = catalog;
    }

    public Boolean isEmpty() {
        return _books.isEmpty();
    }

    public void add(Book aBook) {
        _books.add(aBook);
    }

    public void add(String isbn) {
        if (!_catalog.contains(isbn)) {
            throw new IllegalArgumentException(INVALID_PUBLISHER);
        }
        _books.add(new Book(isbn));
    }

    public void add(int booksCount, Book aBook) {
        if (booksCount <= 0) {
            throw new IllegalArgumentException(String.format(INVALID_BOOKS_NUMBER, booksCount));
        }

        for (int i = 0; i < booksCount; i++) {
            _books.add(aBook);
        }
    }

    public int size() {
        return _books.size();
    }

    public Boolean contains(Book aBook) {
        return _books.contains(aBook);
    }

    public Stream<Book> books() {
        return _books.stream();
    }
}
