package ar.net.mgardos.storefront;

import ar.net.mgardos.seller.Book;
import ar.net.mgardos.seller.Cart;

import java.util.*;
import java.util.stream.Stream;

public class App {
    static final String INVALID_IDENTIFICATION = "The identification information is not valid";

    private Map<Long, Cart> carts;
    private Set<String> catalog;

    public App() {
        carts = new HashMap<>();

        catalog = new HashSet<>();
        catalog.add("ISBN-1-Tus Libros");
        catalog.add("ISBN-2-Tus Libros");
        catalog.add("ISBN-3-Tus Libros");
    }

    public Long createCart(String clientId, String password) {
        Boolean validIdentification = !"".equals(clientId);
        validIdentification &= !"".equals(password);

        if (!validIdentification) {
            throw new IllegalArgumentException(INVALID_IDENTIFICATION);
        }

        Long cartId = 0l;
        carts.put(cartId, new Cart(catalog));

        return cartId;
    }

    public Stream<Book> listCart(Long cartId) {
        return carts.get(cartId).books();
    }

    public void addToCart(Long cartId, String isbn, Integer quantity) {
        for (int i = 0; i < quantity; i++) {
            carts.get(cartId).add(isbn);
        }
    }
}
