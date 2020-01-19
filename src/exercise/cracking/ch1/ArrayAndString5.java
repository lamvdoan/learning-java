package exercise.cracking.ch1;

/*
 *  One Away: There are three types of edits that can be performed on strings: insert a character, remove a character,
 *  or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
 */

import exercise.utils.RunTime;

public class ArrayAndString5 {
    private static RunTime time1 = new RunTime();
    private static RunTime time2 = new RunTime();
    private static RunTime time3 = new RunTime();
    private static RunTime time4 = new RunTime();

    public static void main(String[] args) {
        System.out.println("One Edit Away");
        System.out.println("*************\n");

        for (int i = 0; i < 10; i++) {
            executeTest("pale", "ple");
            executeTest("pale", "pales");
            executeTest("pale", "bale");
            executeTest("pale", "bake");
        }

        System.out.println("// Lam's Solution");
        time1.getAverageElapsedTime();

        System.out.println("\n// Books's solution with Lam's for loops");
        time2.getAverageElapsedTime();

        System.out.println("\n// Books's solution");
        time3.getAverageElapsedTime();

        System.out.println("\n// Books's optimal solution");
        time4.getAverageElapsedTime();
    }

    private static void executeTest(String s1, String s2) {
        System.out.println(String.format("Word: %s, %s", s1, s2));

        time1.start();
        System.out.println(isOneEditAway(s1, s2));
        time1.endAndPrintElapsedTime();

        time2.start();
        System.out.println(isOneEditAway2(s1, s2));
        time2.endAndPrintElapsedTime();

        time3.start();
        System.out.println(isOneEditAway3(s1, s2));
        time3.endAndPrintElapsedTime();

        time4.start();
        System.out.println(isOneEditAway4(s1, s2));
        time4.endAndPrintElapsedTime();

        System.out.println();
    }

    private static boolean isOneEditAway(String s1, String s2) {
        // Length check
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }

        // Get shorter and longer string
        String shorterString = s1.length() < s2.length() ? s1 : s2;
        String longerString = s1.length() < s2.length() ? s2 : s1;

        int mismatchCount = 0;

        for (int i = 0; i < shorterString.length(); i++) {
            if (shorterString.charAt(i) != longerString.charAt(i)) {
                if (mismatchCount >= 2) {
                    break;
                }

                mismatchCount++;
            }
        }

        if (mismatchCount <= 1) {
            return true;
        }

        int nextIndex = 0;

        for (int i = 0; i < shorterString.length(); i++) {
            if (shorterString.charAt(i) != longerString.charAt(i + nextIndex)) {
                if (nextIndex == 1) {
                    return false;
                }

                nextIndex = 1;
                i--;
            }
        }

        return true;
    }

    private static boolean isOneEditAway2(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return isEditReplaced(s1, s2);
        } else if (s1.length() - 1 == s2.length()) {
            return isEditInserted(s1, s2);
        } else if (s1.length() + 1 == s2.length()) {
            return isEditInserted(s2, s1);
        }

        return false;
    }

    private static boolean isEditReplaced(String s1, String s2) {
        boolean mismatchFound = false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (mismatchFound) {
                    return false;
                }

                mismatchFound = true;
            }
        }

        return true;
    }

    private static boolean isEditInserted(String s1, String s2) {
        int nextIndex = 0;

        for (int i = 0; i < s2.length(); i++) {
            if (s1.charAt(i + nextIndex) != s2.charAt(i)) {
                if (nextIndex == 1) {
                    return false;
                }

                nextIndex = 1;
                i--;
            }
        }

        return true;
    }

    private static boolean isOneEditAway3(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return isEditReplaced(s1, s2);
        } else if (s1.length() - 1 == s2.length()) {
            return isEditInserted2(s2, s1);
        } else if (s1.length() + 1 == s2.length()) {
            return isEditInserted2(s1, s2);
        }

        return false;
    }

    private static boolean isEditInserted2(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;

        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }

            } else {
                index1++;
            }

            index2++;
        }

        return true;
    }

    private static boolean isOneEditAway4(String s1, String s2) {
        // Length check
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }

        // Get shorter and longer string
        String shorterString = s1.length() < s2.length() ? s1 : s2;
        String longerString = s1.length() < s2.length() ? s2 : s1;

        int indexShorterString = 0;
        int indexLongerString = 0;
        boolean foundDifference = false;

        while (indexShorterString < shorterString.length() && indexLongerString < longerString.length()) {
            if (shorterString.charAt(indexShorterString) != longerString.charAt(indexLongerString)) {
                if (foundDifference) {
                    return false;
                }

                foundDifference = true;

                // On replaceEdit, move short pointer
                if (shorterString.length() == longerString.length()) {
                    indexShorterString++;
                }
            } else {
                // If there is a match, let's move on to the next character
                indexShorterString++;
            }

            // Always move to the next character
            indexLongerString++;
        }

        return true;
    }
}
