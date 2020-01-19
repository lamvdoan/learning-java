package exercise.string;

// String reverse using recursion

import java.util.regex.Pattern;

public class String5 {
    public static void main(String[] args) {
        String word = "digits123";
        String word2 = "4321";

        System.out.println("Word: " + word + " -> " + doesStringContainOnlyDigits(word));
        System.out.println("Word: " + word2 + " -> " + doesStringContainOnlyDigits(word2));

        System.out.println();

        System.out.println("Word: " + word + " -> " + doesStringContainOnlyDigitsRegex(word));
        System.out.println("Word: " + word2 + " -> " + doesStringContainOnlyDigitsRegex(word2));
    }

    private static boolean doesStringContainOnlyDigits(String word) {
        char[] wordChar = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            if (Character.getNumericValue(wordChar[i]) > 9) {
                return false;
            }
        }

        return true;
    }

    private static boolean doesStringContainOnlyDigitsRegex(String word) {
        Pattern digitOnlyPattern = Pattern.compile("^[0-9]*$");
        return digitOnlyPattern.matcher(word).matches();
    }
}
