package ar.net.mgardos.seller;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static ar.net.mgardos.seller.Cart.INVALID_BOOKS_NUMBER;
import static ar.net.mgardos.seller.Cart.INVALID_PUBLISHER;
import static org.junit.Assert.*;

public class CartTest {
    @Test
    public void test_createEmptyCart() {
        Cart aCart = new Cart();
        assertEquals(Boolean.TRUE, aCart.isEmpty());
    }

    @Test
    public void test_cartNotEmptyAfterAddingOneBook() {
        Cart aCart = new Cart();
        Book aBook = new Book();
        aCart.add(aBook);
        assertEquals(Boolean.FALSE, aCart.isEmpty());
    }

    @Test
    public void test_cartContainsOneBookAfterAddingOneBookToCart() {
        Cart aCart = new Cart();
        Book aBook = new Book();
        aCart.add(aBook);
        assertEquals(aCart.size(), 1);
        assertTrue(aCart.contains(aBook));
    }

    @Test
    public void test_cartContainsSeveralBooksAfterAddingSeveralBooksToCart() {
        Cart aCart = new Cart();
        Book bookOne = new Book();
        aCart.add(bookOne);
        Book bookTwo = new Book();
        aCart.add(bookTwo);
        Book bookThree = new Book();
        aCart.add(bookThree);
        assertEquals(aCart.size(), 3);
        assertTrue(aCart.contains(bookOne));
        assertTrue(aCart.contains(bookTwo));
        assertTrue(aCart.contains(bookThree));
        assertFalse(aCart.contains(new Book()));
    }

    @Test
    public void test_cartContainsSeveralEqualBooksAfterAddingSeveralEqualBooksToCart() {
        Cart aCart = new Cart();
        Book aBook = new Book();
        aCart.add(aBook);
        aCart.add(aBook);
        aCart.add(aBook);
        aCart.add(aBook);
        assertEquals(aCart.size(), 4);
        assertTrue(aCart.contains(aBook));
        assertFalse(aCart.contains(new Book()));
    }

    @Test
    public void test_addPositiveNumberOfBooksToCart() {
        Cart aCart = new Cart();
        Book aBook = new Book();
        aCart.add(5, aBook);
        assertEquals(aCart.size(), 5);
    }

    @Test
    public void test_addNegativeNumberOfBooksToCartNotAllowed() {
        int booksNumber = -2;

        test_invalidNumberOfBooks(booksNumber);
    }

    @Test
    public void test_addZeroNumberOfBooksToCartNotAllowed() {
        int booksNumber = 0;

        test_invalidNumberOfBooks(booksNumber);
    }

    private void test_invalidNumberOfBooks(int booksNumber) {
        Cart aCart = new Cart();
        Book aBook = new Book();

        try {
            aCart.add(booksNumber, aBook);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(String.format(INVALID_BOOKS_NUMBER, booksNumber), e.getMessage());
            assertTrue(aCart.isEmpty());
        }
    }

    @Test
    public void test_cartNotAllowBooksFromOtherPublishers() {
        Set<String> catalog = new HashSet<>();
        catalog.add("Book 1 from Tu Libros");
        catalog.add("Book 2 from Tu Libros");
        catalog.add("Book 3 from Tu Libros");

        Cart aCart = new Cart(catalog);
        String publisherName = "Publisher";
        String aBookFromOtherPublisher = "Book 1 from other " + publisherName;

        try {
            aCart.add(aBookFromOtherPublisher);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(INVALID_PUBLISHER, e.getMessage());
            assertTrue(aCart.isEmpty());
        }
    }

    @Test
    public void test_cartOnlyContainsBooksFromSamePublisher() {
        Set<String> catalog = new HashSet<>();
        catalog.add("ISBN-1-Tus Libros");
        catalog.add("ISBN-2-Tus Libros");
        catalog.add("ISBN-3-Tus Libros");

        Cart aCart = new Cart(catalog);
        String aBookFromTusLibros = "ISBN-2-Tu Libros";

        aCart.add(aBookFromTusLibros);
        assertEquals(aCart.size(), 1);
        // assert contains same book
    }

    @Test
    public void test_accessBooksAsStreamWhenCartEmpty() {
        Book aBook = new Book();
        Cart aCart = new Cart();

        Stream<Book> books = aCart.books();
        assertEquals(0, books.count());
    }

    @Test
    public void test_accessBooksInCartAsStream() {
        Book aBook = new Book();
        Cart aCart = new Cart();
        aCart.add(aBook);
        aCart.add(aBook);

        Stream<Book> books = aCart.books();
        assertEquals(2, books.count());
    }
}
