package com.theironyard.charlotte;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ben on 4/11/17.
 */
public class MainTest {

    @Test
    public void balancedReturnsWhetherLettersThatMatchEqualThoseThatDont() {
        assertFalse(Main.balanced("creek", 'e'));
        assertTrue(Main.balanced("prrt", 'r'));
        assertTrue(Main.balanced("wowx", 'w'));
    }

    @Test
    public void divisiblesReturnsElementsOfFirstArrayDivisibleByAllOfSecond() {
        assertArrayEquals(new int[] { 18 }, Main.divisibles(new int[] { 10, 4, 18, 11, 91 }, new int[] { 2, 9 }));
    }

    @Test
    public void longXReturnsTheAppropriateNumberOfXs() {
        assertEquals(1, Main.longx("xoxoxoxoxo"));
        assertEquals(4, Main.longx("asdxxxxf"));
        assertEquals(5, Main.longx("xxpxxxxxp"));
    }
}