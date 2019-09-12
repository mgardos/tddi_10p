package ar.net.mgardos.merchant;

@FunctionalInterface
public interface Merchant {
    static final String NOT_AVAILABLE = "Merchant is not available";
    static final String INVALID_AMOUNT = "The amount to debit must be greater than 0";
    static final String INVALID_CARD = "The card is not valid for making the debit";

    void debit(Card card, Double amount);
}
