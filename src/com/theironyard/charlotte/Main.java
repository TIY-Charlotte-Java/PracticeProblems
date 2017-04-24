package com.theironyard.charlotte;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        System.out.println(isPalindrome("racecar"));
//        System.out.println(isPalindrome("pants"));
//        System.out.println(isPalindrome("A santa AT NASA"));

//        int[] numbers = new int[] { 10, 4, 8, 6, 12, 19, 35 };
//
//        System.out.println(getSecondHighest(numbers));
    }

    public static int getSecondHighest(int[] numbers) {
        int secondLargest = -1;
        int largest = -1;

//      for (int i = 0;i < numbers.length;i++) {
//          int current = numbers[i];

        for (int current : numbers) {
            if (current > largest) {
                secondLargest = largest;
                largest = current;
            }
        }

        return secondLargest;
    }

    public static boolean isPalindrome(String input) {
        input = input.replaceAll("\\s", "");

        StringBuilder sb = new StringBuilder(input);

        return input.equalsIgnoreCase(sb.reverse().toString());
    }

    public static boolean balanced(String word, char letter) {
        int matchCount = 0;
        int notMatch = 0;

        for (int i = 0;i < word.length();i++) {
            if (word.charAt(i) == letter) {
                matchCount++;
            } else {
                notMatch++;
            }
        }

        return matchCount == notMatch;
    }

    /**
     * Divisibles: Return an array of numbers from `first` where
     * each number is divisible by all of the numbers in `second.`
     * @param first the `first` array
     * @param second the `second` array
     * @return New array that is all the numbers from `first` that
     * are divisible by all numbers in `second`.
     */
    public static int[] divisibles(int[] first, int[] second) {
        int denominator = 1;

        // this is what we will return. we can't use
        // an array here since we don't yet know how
        // many numbers will pass the test.
        ArrayList<Integer> resultsList = new ArrayList<>();

        // any number divisible by a, and divisible by b,
        // is divisible by a * b. If we calculate the
        // denominator we save ourselves from a nested
        // `for` loop
        for (int number : second) {
            denominator *= number;
        }

        for (int number : first) {
            // we use the modulus operator to determine
            // divisibility
            if (number % denominator == 0) {
                resultsList.add(number);
            }
        }

        // convert arraylist back to array (messy)
        // we have to do this since we have int primitives
        // and without streams there's no great way to
        // do this.
        int[] results = new int[resultsList.size()];

        for (int i = 0;i < results.length;i++) {
            results[i] = resultsList.get(i);
        }

        return results;
    }


    /**
     * See definition in "divisibles"
     * @param first
     * @param second
     * @return
     */
    public static int[] divisiblesStreams(int[] first, int[] second) {
        // reduction operation to create the denominator.
        int denominator = Arrays.stream(second).reduce(1, (a, b) -> a * b);

        // this is where the magic happens.
        // if we think about it, this is an extremely concise
        // version of what we want to accomplish. For loops
        // are a byproduct of us having to use the language
        // to accomplish this task.
        return Arrays.stream(first)
                     .filter(num -> num % denominator == 0)
                     .toArray();
    }

    public static int longx(String inputString) {
        int max = 0;

        // perform calculations to update "max"
        int xcount = 0;

        // take a gander at every character in the string
        for (int i = 0;i < inputString.length();i++) {
            // character at index 'i'
            char currentChar = inputString.charAt(i);

            if (currentChar == 'x') {
                // yay we found an x
                // increment xcount.
                xcount++;

                // if xcount > max
                // update max
                if (xcount > max) {
                    max = xcount;
                }
            }

            // we didn't find an x. :(
            else if (xcount > 0) {
                xcount = 0;
            }
        }

        return max;
    }
}

