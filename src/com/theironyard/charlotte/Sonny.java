package com.theironyard.charlotte;

import java.util.List;

/**
 *
 */
public class Sonny extends Robot {
    public Sonny() {
        version = "2.0";
    }

    /**
     *
     * @return
     */
    @Override
    public List<String> getLaws() {
        // we shouldn't just re-print the four laws instead
        // of the previous 3. We should retrieve the laws
        // that ALL robots have, and add one to it.
        List<String> laws = super.getLaws();

        laws.add("A robot may not harm humanity, or, by inaction, allow humanity to come to harm.");
        return laws;
    }
}
