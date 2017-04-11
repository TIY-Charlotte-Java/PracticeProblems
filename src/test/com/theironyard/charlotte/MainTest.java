package com.theironyard.charlotte;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
}