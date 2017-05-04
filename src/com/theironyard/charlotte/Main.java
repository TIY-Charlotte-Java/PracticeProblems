package com.theironyard.charlotte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static int rosebud(String input) {
        Pattern p = Pattern.compile("rosebud(!+)1");
        Matcher m = p.matcher(input);

        if (!m.matches()) {
            return 0;
        }

        return m.group(1).length();
//        int dollaCount = 0;
//
//        if (input.startsWith("rosebud") && input.endsWith("1")) {
//            int idx = input.indexOf("!");
//            if (idx != -1) {
//                // we've found an exclamation point
//                while (input.charAt(idx) == '!') {
//                    dollaCount++;
//                    idx++;
//                }
//            }
//        }
//
//        return dollaCount;
    }

    public static int sevenUp(int sevenInput) {
//        System.out.println("The value of SevenInput:\n " + sevenInput);

        // base case
        if (sevenInput == 0) {
            return 0;
        }

        // find the last 7 in the number
        boolean found = (sevenInput % 10) == 7;

        return (found ? 1 : 0) + sevenUp(sevenInput / 10);

//        if (found) {
//            return 1 + sevenUp(sevenInput / 10);
//        } else {
//            return sevenUp(sevenInput / 10);
//        }

        //        Pattern p = Pattern.compile("(7)");
//        Matcher m = p.matcher(String.valueOf(sevenInput));
//
//        int found = 0;
//        while (m.find()) {
//            found++;
//        }
//
//        return found;

        //return String.valueOf(sevenInput).replaceAll("[^7]", "").length();
    }

    public static String headerliner(String input) {
        // we expect to manipulate the string, so we use a string builder
        StringBuilder sb = new StringBuilder(input);

        // this is a boolean that will tell us if the next thing
        // should be capitalized

        // setting this to true indicates the first letter
        // we come across should be capitalized
        boolean shouldbeCapitalized = true;


        for (int i = 0;i < sb.length();i++) {
            Character currentCharacter = sb.charAt(i);

            if (shouldbeCapitalized) {
                sb.setCharAt(i, Character.toTitleCase(currentCharacter));
            } else {
                sb.setCharAt(i, Character.toLowerCase(currentCharacter));
            }

            // This:
//            if (Character.isSpaceChar(currentCharacter)) {
//                shouldbeCapitalized = true;
//            } else {
//                shouldbeCapitalized = false;
//            }

            // Equivalent:
            shouldbeCapitalized = Character.isSpaceChar(currentCharacter);
        }

        return sb.toString();
    }

    public static int maxBlock(String word) {
        Pattern p = Pattern.compile("(.)\\1*");
        Matcher m = p.matcher(word);

        int maxLength = 0;

        while (m.find()) {
            int matchLength = m.group(0).length();

            if (matchLength > maxLength) {
                maxLength = matchLength;
            }
        }

        return maxLength;
    }

    public static String weave(String word, int xcount) {
        StringBuilder sb = new StringBuilder(word);

        // use this for loop to replace some characters
        // with the letter 'x'.
        for (int i = 0;i < sb.length();i++) {
            if (i % xcount == 0) {
                sb.setCharAt(i, 'x');
            }
        }

        // return the string value of the stringbuilder
        return sb.toString();
    }

    public static int desirable(String houseBlocks) {
        int desirableCount = 0;

        for (int i = 0;i < houseBlocks.length();i++) {
            if (houseBlocks.charAt(i) == 'H') {
                // we're looking to the left
                if ((i > 0 && houseBlocks.charAt(i - 1) == 'R') ||
                    (i > 1 && houseBlocks.charAt(i - 2) == 'R')) {
                    desirableCount++;
                }

                // now we need to look to the right of the 'H'
                // we're going to check charAt(i + 1) and charAt(i + 2);
                else {
                    int idx1 = i + 1 < houseBlocks.length() ? i + 1 : houseBlocks.length() - 1;
                    int idx2 = i + 2 < houseBlocks.length() ? i + 2 : houseBlocks.length() - 1;

                    if (houseBlocks.charAt(idx1) == 'R' || houseBlocks.charAt(idx2) == 'R') {
                        desirableCount++;
                    }
                }
            }
        }

        return desirableCount;
    }
}

