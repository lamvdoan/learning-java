package exercise.cracking.ch1;

/*
 *  Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome. A
 *  palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of
 *  letters. The palindrome does not need to be limited to just dictionary words.
 */

import exercise.utils.RunTime;

import java.util.HashMap;

public class ArrayAndString4 {
    private static RunTime time1 = new RunTime();
    private static RunTime time2 = new RunTime();
    private static RunTime time3 = new RunTime();

    public static void main(String[] args) {
        System.out.println("Palindrome permutation");
        System.out.println("*********************\n");

        for (int i = 0; i < 10; i++) {
            executeTest("level");
            executeTest("Tact Coa");
            executeTest("gazelle");
        }

        System.out.println("// Lam's Solution using arrays");
        time1.getAverageElapsedTime();

        System.out.println("\n// Lam's solution using Hashmaps");
        time2.getAverageElapsedTime();

        System.out.println("\n// Book's solution");
        time3.getAverageElapsedTime();
    }

    private static void executeTest(String s) {
        System.out.println(String.format("Word: %s", s));

        time1.start();
        System.out.println(isPermutationPalindrome(s));
        time1.endAndPrintElapsedTime();

        time2.start();
        System.out.println(isPermutationPalindrome2(s));
        time2.endAndPrintElapsedTime();

        time3.start();
        System.out.println(isPermutationPalindrome3(s));
        time3.endAndPrintElapsedTime();

        System.out.println();
    }

    private static boolean isPermutationPalindrome(String s) {
        s = s.toLowerCase().replace(" ", "");

        if (s.length() == 1) {
            return true;
        } else if (s.length() == 0) {
            return false;
        }

        int[] letters = buildLettersTable(s);
        return doesLettersContainMaxOneOdd(letters);
    }

    private static int[] buildLettersTable(String s) {
        char[] stringChars = s.toCharArray();

        final int ASCII_LETTERS = 128;
        int[] letters = new int[ASCII_LETTERS];

        for (char c : stringChars) {
            letters[c]++;
        }
        return letters;
    }

    private static boolean doesLettersContainMaxOneOdd(int[] letters) {
        boolean foundOdd = false;

        for (int count : letters) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }

                foundOdd = true;
            }
        }

        return true;
    }

    private static boolean isPermutationPalindrome2(String s) {
        s = s.toLowerCase().replace(" ", "");

        if (s.length() == 1) {
            return true;
        } else if (s.length() == 0) {
            return false;
        }

        HashMap<Character, Integer> letters = buildLettersHashTable(s);
        return doesLettersContainMaxOneOdd(letters);
    }

    private static HashMap<Character, Integer> buildLettersHashTable(String string) {
        char[] stringChars = string.toCharArray();
        HashMap<Character, Integer> letters = new HashMap<>();

        for (char c : stringChars) {
            letters.put(c, letters.containsKey(c) ? letters.get(c) + 1 : 1);
        }
        return letters;
    }

    private static boolean doesLettersContainMaxOneOdd(HashMap<Character, Integer> letters) {
        boolean foundOdd = false;
        for (Integer value : letters.values()) {
            if (value % 2 == 1) {
                if (foundOdd) {
                    return false;
                }

                foundOdd = true;
            }
        }

        return true;
    }

    private static boolean isPermutationPalindrome3(String s) {
        if (s.length() == 1) {
            return true;
        } else if (s.length() == 0) {
            return false;
        }

        char[] stringChars = s.toCharArray();
        final int NUMBER_OF_LETTERS = 26;
        int[] letters = new int[NUMBER_OF_LETTERS];

        int countOfOddLetters = 0;

        for (char c : stringChars) {
            int valueOfC = getNumericalValue(c);

            if (valueOfC != -1) {
                letters[valueOfC]++;

                if (letters[valueOfC] % 2 == 1) {
                    countOfOddLetters++;
                } else {
                    countOfOddLetters--;
                }
            }
        }

        return countOfOddLetters <= 1;
    }

    private static int getNumericalValue(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int valueOfC = Character.getNumericValue(c);

        if ((a <= valueOfC) && (valueOfC <= z)) {
            return valueOfC - a;
        } else {
            return -1;
        }
    }
}
