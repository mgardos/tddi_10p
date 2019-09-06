package roman.numbers;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumberTextRepresentationTest {
    @Test
    public void testZeroNotAllowed() {
        try {
            RomanNumberTextRepresentation.of(0);
            fail();
        } catch (Exception e) {
            assertEquals("Zero not allowed.", e.getMessage());
        }
    }

    @Test
    public void test001() {
        assertEquals("I", RomanNumberTextRepresentation.of(1));
    }

    @Test
    public void test002() {
        assertEquals("II", RomanNumberTextRepresentation.of(2));
    }

    @Test
    public void test003() {
        assertEquals("III", RomanNumberTextRepresentation.of(3));
    }

    @Test
    public void test004() {
        assertEquals("IV", RomanNumberTextRepresentation.of(4));
    }

    @Test
    public void test005() {
        assertEquals("V", RomanNumberTextRepresentation.of(5));
    }

    @Test
    public void test006() {
        assertEquals("VI", RomanNumberTextRepresentation.of(6));
    }

    @Test
    public void test007() {
        assertEquals("VII", RomanNumberTextRepresentation.of(7));
    }

    @Test
    public void test008() {
        assertEquals("VIII", RomanNumberTextRepresentation.of(8));
    }

    @Test
    public void test009() {
        assertEquals("IX", RomanNumberTextRepresentation.of(9));
    }

    @Test
    public void test010() {
        assertEquals("X", RomanNumberTextRepresentation.of(10));
    }

    @Test
    public void test011() {
        assertEquals("XI", RomanNumberTextRepresentation.of(11));
    }

    @Test
    public void test012() {
        assertEquals("XII", RomanNumberTextRepresentation.of(12));
    }

    @Test
    public void test013() {
        assertEquals("XIII", RomanNumberTextRepresentation.of(13));
    }

    @Test
    public void test014() {
        assertEquals("XIV", RomanNumberTextRepresentation.of(14));
    }

    @Test
    public void test015To18() {
        assertEquals("XV", RomanNumberTextRepresentation.of(15));
        assertEquals("XVI", RomanNumberTextRepresentation.of(16));
        assertEquals("XVII", RomanNumberTextRepresentation.of(17));
        assertEquals("XVIII", RomanNumberTextRepresentation.of(18));
    }

    @Test
    public void test019() {
        assertEquals("XIX", RomanNumberTextRepresentation.of(19));
    }

    @Test
    public void test020To29() {
        assertEquals("XX", RomanNumberTextRepresentation.of(20));
        assertEquals("XXVI", RomanNumberTextRepresentation.of(26));
        assertEquals("XXVII", RomanNumberTextRepresentation.of(27));
        assertEquals("XXVIII", RomanNumberTextRepresentation.of(28));
        assertEquals("XXIX", RomanNumberTextRepresentation.of(29));
    }

    @Test
    public void test030To39() {
        assertEquals("XXX", RomanNumberTextRepresentation.of(30));
        assertEquals("XXXVI", RomanNumberTextRepresentation.of(36));
        assertEquals("XXXVII", RomanNumberTextRepresentation.of(37));
        assertEquals("XXXVIII", RomanNumberTextRepresentation.of(38));
        assertEquals("XXXIX", RomanNumberTextRepresentation.of(39));
    }

    @Test
    public void test040To49() {
        assertEquals("XL", RomanNumberTextRepresentation.of(40));
        assertEquals("XLI", RomanNumberTextRepresentation.of(41));
        assertEquals("XLII", RomanNumberTextRepresentation.of(42));
        assertEquals("XLIII", RomanNumberTextRepresentation.of(43));
        assertEquals("XLIX", RomanNumberTextRepresentation.of(49));
    }

    @Test
    public void test050To89() {
        assertEquals("L", RomanNumberTextRepresentation.of(50));
        assertEquals("LI", RomanNumberTextRepresentation.of(51));
        assertEquals("LII", RomanNumberTextRepresentation.of(52));
        assertEquals("LIII", RomanNumberTextRepresentation.of(53));
        assertEquals("LIX", RomanNumberTextRepresentation.of(59));
        assertEquals("LX", RomanNumberTextRepresentation.of(60));
        assertEquals("LXV", RomanNumberTextRepresentation.of(65));
        assertEquals("LXX", RomanNumberTextRepresentation.of(70));
        assertEquals("LXXVI", RomanNumberTextRepresentation.of(76));
        assertEquals("LXXXVIII", RomanNumberTextRepresentation.of(88));
        assertEquals("LXXXIX", RomanNumberTextRepresentation.of(89));
    }

    @Test
    public void test090() {
        assertEquals("XC", RomanNumberTextRepresentation.of(90));
    }
}