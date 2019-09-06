package ar.net.mgardos;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
        // assert contains aBook
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
        // assert contains books
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
        // assert contains same aBook
    }

    @Test
    public void test_addPositiveNumberOfBooksToCart() {
        Cart aCart = new Cart();
        Book aBook = new Book();
        aCart.add(5, aBook);
        assertEquals(aCart.size(), 5);
    }

    // refactor with next
    @Test
    public void test_addNegativeNumberOfBooksToCartNotAllowed() {
        Cart aCart = new Cart();
        Book aBook = new Book();
        int booksNumber = -2;

        try {
            aCart.add(-2, aBook);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(String.format(Cart.INVALID_BOOKS_NUMBER, booksNumber), e.getMessage());
            assertEquals(aCart.size(), 0);
        }
    }

    // refactor with previous
    @Test
    public void test_addZeroNumberOfBooksToCartNotAllowed() {
        Cart aCart = new Cart();
        Book aBook = new Book();
        int booksNumber = -2;

        try {
            aCart.add(0, aBook);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(String.format(Cart.INVALID_BOOKS_NUMBER, booksNumber), e.getMessage());
            assertEquals(aCart.size(), 0);
        }
    }

    @Test
    public void test_cartOnlyContainsBooksFromSamePublisher() {
        Set<String> catalog = new HashSet<>();
        catalog.add("Book 1 from Tu Libros");
        catalog.add("Book 2 from Tu Libros");
        catalog.add("Book 3 from Tu Libros");

        Cart aCart = new Cart(catalog);
        String publisherName = "Publisher";
        String aBook = "Book 1 from other " + publisherName;

        try {
            aCart.add(aBook);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(String.format(Cart.INVALID_PUBLISHER, publisherName), e.getMessage());
            assertEquals(aCart.size(), 3);
        }
    }
}
