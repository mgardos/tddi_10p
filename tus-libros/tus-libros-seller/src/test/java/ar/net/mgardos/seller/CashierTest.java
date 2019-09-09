package ar.net.mgardos.seller;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static ar.net.mgardos.seller.Cashier.INVALID_CART;
import static org.junit.Assert.*;

public class CashierTest {
    @Test
    public void test_noCheckoutWhenCartEmpty() {
        Cart aCart = new Cart();
        Map<String, Float> aPriceList = new HashMap<>();

        try {
            new Cashier(aCart, aPriceList);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(INVALID_CART, e.getMessage());
        }
    }

    @Test
    public void test_checkoutProceedWhenCartHasOneOrMoreBooks() {
        Cart aCart = new Cart();
        aCart.add(new Book());

        Map<String, Float> aPriceList = new HashMap<>();

        Cashier aCashier = new Cashier(aCart, aPriceList);
        assertNotNull(aCashier);
    }

    @Test
    public void test_totalCostCheckoutSameAsTotalPriceBooksInCart() {
        Set<String> catalog = new HashSet<>();
        catalog.add("ISBN-1-Tus Libros");
        catalog.add("ISBN-2-Tus Libros");
        catalog.add("ISBN-3-Tus Libros");

        Cart aCart = new Cart(catalog);
        Map<String, Float> aPriceList = new HashMap<>();
        aPriceList.put("ISBN-1-Tus Libros", 2.3f);
        aPriceList.put("ISBN-2-Tus Libros", 5.67f);
        aPriceList.put("ISBN-3-Tus Libros", 8.991f);

        catalog.forEach(book -> aCart.add(book));
        Float expectedTotalCost = aPriceList.values().stream().reduce(0f, (subtotal, price) -> subtotal + price);
        Cashier aCashier = new Cashier(aCart, aPriceList);

        Float actualTotalCost = aCashier.checkout();
        assertEquals(expectedTotalCost, actualTotalCost, 0.01f);
    }
}
