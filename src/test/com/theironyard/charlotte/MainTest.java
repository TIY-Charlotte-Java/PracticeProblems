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

    @Test
    public void rosebudReturnsTheAppropriateMoneys() {
        assertEquals(3, Main.rosebud("rosebud!!!1"));
        assertEquals(0, Main.rosebud("r!!ose!bud!!1"));
        assertEquals(0, Main.rosebud("pants"));
        assertEquals(5, Main.rosebud("rosebud!!!!!1"));
        assertEquals(0, Main.rosebud("rosebud!!pants!!1"));
    }

    @Test
    public void sevenUpTestsNumberOfSevensInInt() {
        assertEquals(0, Main.sevenUp(123));
        assertEquals(1, Main.sevenUp(700));
        assertEquals(2, Main.sevenUp(177));
        assertEquals(3, Main.sevenUp(43700707));
    }

    @Test
    public void titleCaseAppropriatelyCasesWords() {
        assertEquals("San Diego", Main.headerliner("sAN DIEGO"));
        assertEquals("Where The Red Fern Grows", Main.headerliner("where the red fern grows"));
        assertEquals("Chicken Pot Pie", Main.headerliner("chicken POT PIE"));
    }
}