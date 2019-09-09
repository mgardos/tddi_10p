package ar.net.mgardos.seller;

import java.util.Map;

import static java.util.stream.Collectors.summingDouble;

public class Cashier {
    static final String INVALID_CART = "Unable to checkout empty Cart.";

    private Cart _cart;
    private Map<String, Float> _priceList;

    public Cashier(Cart aCart, Map<String, Float> priceList) {
        if (aCart.isEmpty()) {
            throw new IllegalArgumentException(INVALID_CART);
        }
        _cart = aCart;
        _priceList = priceList;
    }

    public Float checkout() {
        Double totalCost = _cart.books().collect(summingDouble(book -> _priceList.get(book.toString())));
        return totalCost.floatValue();
    }
}
