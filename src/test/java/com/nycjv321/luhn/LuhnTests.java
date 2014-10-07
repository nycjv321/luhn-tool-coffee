package com.nycjv321.luhn;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by Javier L. Velasquez on 10/6/2014.
 */
public class LuhnTests {

    @Test
    public void testValidAccountNumber() {
        assertTrue(Luhn.isValid(79927398713l));
    }

    @Test
    public void testInValidAccountNumber() {
        assertFalse(Luhn.isValid(79927398710l));
    }

    @Test
    public void testGetCheckDigitExisting() {
        assertEquals(Luhn.getCheckDigit(79927398710l, true), 3l);
    }

    @Test
    public void testGetCheckDigitNonExistingImplicit() {
        assertEquals(Luhn.getCheckDigit(7992739871l), 3l);
    }

    @Test
    public void testGetCheckDigitNonExisting() {
        assertEquals(Luhn.getCheckDigit(7992739871l, false), 3l);
    }


}
