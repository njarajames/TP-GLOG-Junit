package fr.emse.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyBagTest {

    private Money f12CHF;
    private Money f14CHF;
    private Money f7USD;
    private Money f21USD;
    private MoneyBag fMB1;
    private MoneyBag fMB2;

    @Before
    public void setUp() {
        f12CHF = new Money(12, "CHF");
        f14CHF = new Money(14, "CHF");
        f7USD = new Money(7, "USD");
        f21USD = new Money(21, "USD");
        fMB1 = new MoneyBag(f12CHF, f7USD);
        fMB2 = new MoneyBag(f14CHF, f21USD);
    }

    @Test
    public void testBagEquals() {
        assertFalse(fMB1.equals(null));
        assertEquals(fMB1, fMB1);
        assertNotEquals(fMB1, f12CHF);
        assertNotEquals(f12CHF, fMB1);
        assertNotEquals(fMB1, fMB2);
    }

    @Test
    public void testMixedSimpleAdd() {
        // [12 CHF] + [7 USD] == {[12 CHF][7 USD]}
        Money[] bag = {f12CHF, f7USD};
        MoneyBag expected = new MoneyBag(bag);
        assertEquals(expected, f12CHF.add(f7USD));
    }

    @Test
    public void testBagSimpleAdd() {
        // [12 CHF] + {[14 CHF][21 USD]} == {[12 CHF][14 CHF][21 USD]}
        MoneyBag bag = new MoneyBag(f14CHF, f21USD);
        MoneyBag expected = new MoneyBag(new Money(12, "CHF"), f14CHF, f21USD);
//        assertEquals(expected, f12CHF.add(bag));
    }

    @Test
    public void testSimpleBagAdd() {
        // {[12 CHF][7 USD]} + [14 CHF] == {[12 CHF][14 CHF][7 USD]}
        MoneyBag bag = new MoneyBag(f14CHF);
        MoneyBag expected = new MoneyBag(new Money(12, "CHF"), f14CHF, f7USD);
        assertEquals(expected, fMB1.add(f14CHF));
    }

    @Test
    public void testBagBagAdd() {
        // {[12 CHF][7 USD]} + {[14 CHF][21 USD]} == {[12 CHF][14 CHF][28 USD]}
        MoneyBag expected = new MoneyBag(new Money(12, "CHF"), f14CHF, new Money(28, "USD"));
        assertEquals(expected, fMB1.add(fMB2));
    }
}