package ar.net.mgardos.seller;

public class Book {
    private String _isbn;

    public Book() {}
    public Book(String isbn) {
        _isbn = isbn;
    }

    @Override
    public String toString() {
        return _isbn;
    }
}
