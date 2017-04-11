package com.theironyard.charlotte;

public class Main {

    public static void main(String[] args) {
//        System.out.println(isPalindrome("racecar"));
//        System.out.println(isPalindrome("pants"));
//        System.out.println(isPalindrome("A santa AT NASA"));

        int[] numbers = new int[] { 10, 4, 8, 6, 12, 19, 35 };

        System.out.println(getSecondHighest(numbers));
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
}

