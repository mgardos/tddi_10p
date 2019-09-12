package ar.net.mgardos.merchant;

import org.junit.Test;

import static ar.net.mgardos.merchant.Merchant.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MerchantTest {
    @Test
    public void test_debitWhenMerchantDown() {
        Merchant theMerchant = createMerchantDown();
        Card aCard = new Card();

        try {
            theMerchant.debit(aCard, 0d);
            fail();
        } catch (Exception e) {
            assertEquals(NOT_AVAILABLE, e.getMessage());
        }
    }

    @Test
    public void test_debitWhenAmountZero() {
        test_debitWhenAmountZeroOrLess(0d);
    }

    @Test
    public void test_debitWhenAmountLessThanZero() {
        test_debitWhenAmountZeroOrLess(-1d);
    }

    @Test
    public void test_debitWhenCardInvalid() {
        Merchant theMerchant = createMerchantCheckValidCard();
        Card aCard = createExpiredCard();

        try {
            theMerchant.debit(aCard, 0d);
            fail();
        } catch (Exception e) {
            assertEquals(INVALID_CARD, e.getMessage());
        }
    }

    public void test_debitWhenAmountZeroOrLess(Double amount) {
        Merchant theMerchant = createMerchantCheckValidAmount();
        Card aCard = new Card();

        try {
            theMerchant.debit(aCard, amount);
            fail();
        } catch (Exception e) {
            assertEquals(INVALID_AMOUNT, e.getMessage());
        }
    }

    private Merchant createMerchantDown() {
        return (card, amount) -> {throw new IllegalStateException(NOT_AVAILABLE);};
    }

    private Merchant createMerchantCheckValidAmount() {
        return (card, amount) -> {if (amount <= 0) throw new IllegalArgumentException(INVALID_AMOUNT);};
    }

    private Merchant createMerchantCheckValidCard() {
        return (card, amount) -> {if (!card.isValid()) throw new IllegalArgumentException(INVALID_CARD);};
    }

    private Card createExpiredCard() {
        return new Card();
    }
}
