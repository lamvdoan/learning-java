package exercise.cracking.ch1;

// Check if a string is a permutation of the other

import exercise.utils.RunTime;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayAndString2 {
    private static RunTime time1 = new RunTime();
    private static RunTime time2 = new RunTime();
    private static RunTime time3 = new RunTime();

    public static void main(String[] args) {
        System.out.println("String permutation");
        System.out.println("*********************\n");

        for (int i = 0; i < 10; i++) {
            executeTest("fdSa", "ad s f");
            executeTest("fesa", "adsf");
            executeTest("test", "tests");
        }

        System.out.println("// Lam's Solution");
        time1.getAverageElapsedTime();

        System.out.println("\n// Book's Sorting solution");
        time2.getAverageElapsedTime();

        System.out.println("\n// Book's Map solution");
        time3.getAverageElapsedTime();
    }

    private static void executeTest(String s1, String s2) {
        System.out.println(String.format("Word: %s, %s", s1, s2));

        time1.start();
        System.out.println(areBothWordsAPermutation(s1, s2));
        time1.endAndPrintElapsedTime();

        time2.start();
        System.out.println(areBothWordsAPermutation2(s1, s2));
        time2.endAndPrintElapsedTime();

        time3.start();
        System.out.println(areBothWordsAPermutation3(s1, s2));
        time3.endAndPrintElapsedTime();

        System.out.println();
    }

    private static boolean areBothWordsAPermutation(String s1, String s2) {
        s1 = sanitizeString(s1);
        s2 = sanitizeString(s2);

        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> stringMapOne = getLetterCountMap(s1);
        Map<Character, Integer> stringMapTwo = getLetterCountMap(s2);

        return stringMapOne.equals(stringMapTwo);
    }

    private static Map<Character, Integer> getLetterCountMap(String s) {
        Map<Character, Integer> stringMap = new HashMap<>();

        char[] stringChars = s.toLowerCase().toCharArray();
        for (char c : stringChars) {
            stringMap.put(c, stringMap.containsKey(c) ? stringMap.get(c) + 1 : 1);
        }

        return stringMap;
    }

    private static boolean areBothWordsAPermutation2(String s1, String s2) {
        s1 = sanitizeString(s1);
        s2 = sanitizeString(s2);

        return s1.length() == s2.length() && sorts(s1).equals(sorts(s2));
    }

    private static String sorts(String string) {
        char[] stringChars = string.toCharArray();
        Arrays.sort(stringChars);
        return new String(stringChars);
    }

    private static boolean areBothWordsAPermutation3(String s1, String s2) {
        s1 = sanitizeString(s1);
        s2 = sanitizeString(s2);

        if (s1.length() != s2.length()) {
            return false;
        }

        final int ASCII_LETTERS = 256;
        int[] letters = new int[ASCII_LETTERS];

        char[] stringOneChars = s1.toCharArray();
        for (char c : stringOneChars) {
            letters[c]++;
        }

        char[] stringTwoChars = s2.toCharArray();
        for (char c : stringTwoChars) {
            letters[c]--;

            if (letters[c] < 0) {
                return false;
            }
        }

        return true;
    }

    private static String sanitizeString(String s) {
        return s.toLowerCase().replace(" ", "");
    }
}
