package exercise.cracking.ch1;

// Check if a string is contained in the other

import exercise.utils.RunTime;

public class ArrayAndStringX {
    private static RunTime time1 = new RunTime();
    private static RunTime time2 = new RunTime();
    private static RunTime time3 = new RunTime();

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            executeTest("tempo", "tempest");
            executeTest("because", "cause");
            executeTest("Genius", "gorilla");
            executeTest("good", "good");
            executeTest("good", "glad");
            executeTest("duc", "misconduct");
        }

        System.out.println("// Lam's solution after reviewing 7 exercises");
        time1.getAverageElapsedTime();

        System.out.println("\n// Lam's solution after reviewing 2 exercises");
        time2.getAverageElapsedTime();

        System.out.println("\n// Lam's solution after reviewing 7 exercises");
        time3.getAverageElapsedTime();
    }

    private static void executeTest(String s1, String s2) {
        System.out.println(String.format("Word: %s | %s", s1, s2));

        time1.start();
        System.out.println(isThereAMatchBetweenTwoWords1(s1, s2));
        time1.endAndPrintElapsedTime();

        time2.start();
        System.out.println(isThereAMatchBetweenTwoWords2(s1, s2));
        time2.endAndPrintElapsedTime();

        time3.start();
        System.out.println(isThereAMatchBetweenTwoWords3(s1, s2));
        time3.endAndPrintElapsedTime();

        System.out.println();
    }

    private static boolean isThereAMatchBetweenTwoWords1(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return s1.equals(s2);
        }

        String shorterString = s1.length() > s2.length() ? s2 : s1;
        String longerString = s1.length() > s2.length() ? s1 : s2;

        for (int i = 0; i <= longerString.length() - shorterString.length(); i++) {
            if (longerString.substring(i, i + shorterString.length()).equals(shorterString)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isThereAMatchBetweenTwoWords2(String word1, String word2) {
        String word1LowerCased = word1.toLowerCase();
        String word2LowerCased = word2.toLowerCase();

        return doesFirstWordContainTheSecondWord(word1LowerCased, word2LowerCased)
                || doesFirstWordContainTheSecondWord(word2LowerCased, word1LowerCased);
    }

    private static boolean doesFirstWordContainTheSecondWord(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return s1.equals(s2);
        } else if (s1.length() < s2.length()) {
            return false;
        }

        char[] containerArray = s1.toCharArray();
        char[] containeeArray = s2.toCharArray();
        int index = 0;

        for (char c : containerArray) {
            index = (c == containeeArray[index]) ? ++index : 0;

            // see if the shorter word is done iterating over
            if (index == s2.length()) {
                return true;
            }
        }

        return false;
    }

    private static boolean isThereAMatchBetweenTwoWords3(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return s1.equals(s2);
        }

        String shorterString = s1.length() > s2.length() ? s2 : s1;
        String longerString = s1.length() > s2.length() ? s1 : s2;

        char[] shorterChars = shorterString.toCharArray();
        char[] longerChars = longerString.toCharArray();
        int index = 0;

        for (int i = 0; i < longerString.length(); i++) {
            index = shorterChars[index] == longerChars[i] ? ++index : 0;

            if (index == shorterChars.length) {
                return true;
            }
        }

        return false;
    }
}
