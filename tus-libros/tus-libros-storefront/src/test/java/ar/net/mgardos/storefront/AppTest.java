package ar.net.mgardos.storefront;

import ar.net.mgardos.seller.Book;
import org.junit.Test;

import java.util.Map;
import java.util.stream.Stream;

import static ar.net.mgardos.storefront.App.INVALID_IDENTIFICATION;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void test_createCartWhenClientIdInvalid() {
        test_createCartWhenIdentificationInvalid("", "password");
    }

    @Test
    public void test_createCartWhenPasswordInvalid() {
        test_createCartWhenIdentificationInvalid("0123456789", "");
    }

    @Test
    public void test_createCart() {
        App tusLibrosApp = new App();
        String clientId = "0123456789";
        String password = "password";

        Long cartId = tusLibrosApp.createCart(clientId, password);
        Stream<Book> books = tusLibrosApp.listCart(cartId);

        assertEquals(0, books.count());
    }

    @Test
    public void test_addBookToCart() {
        App tusLibrosApp = new App();
        String clientId = "0123456789";
        String password = "password";
        Long cartId = tusLibrosApp.createCart(clientId, password);

        String isbn = "ISBN-2-Tus Libros";
        Integer quantity = 1;
        tusLibrosApp.addToCart(cartId, isbn, quantity);

        Stream<Book> books = tusLibrosApp.listCart(cartId);

        assertEquals(1, books.count());
    }

    private void test_createCartWhenIdentificationInvalid(String clientId, String password) {
        App tusLibrosApp = new App();

        try {
            tusLibrosApp.createCart(clientId, password);
            fail();
        } catch (Exception e) {
            assertEquals(INVALID_IDENTIFICATION, e.getMessage());
        }
    }
}
