package exercise.string;

// Count vowels

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class String7 {
    public static void main(String[] args) {
        String word = "Sentence";
        String word2 = "ED-409";

        System.out.println("Word: " + word + " -> " + getCountOfVowelsRegex(word));
        System.out.println("Word: " + word2 + " -> " + getCountOfVowelsRegex(word2));

        System.out.println("Word: " + word);
        System.out.println("Word: " + word + " -> " + getCountOfVowels(word));
        System.out.println("Word: " + word2 + " -> " + getCountOfVowels(word2));
        System.out.println("Word: " + word);
    }

    private static int getCountOfVowelsRegex(String word) {
        Pattern vowelsOnlyPattern = Pattern.compile("[aeiou]");
        Matcher matcher = vowelsOnlyPattern.matcher(word.toLowerCase());

        String vowelsFound = "";

        while (matcher.find()) {
            vowelsFound += matcher.group(0);
        }

        return vowelsFound.length();
    }

    private static int getCountOfVowels(String word) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        char[] letters = word.toLowerCase().toCharArray();
        int vowelCount = 0;

        for (char character : letters) {
            if (vowels.contains(character)) {
                vowelCount++;
            }
        }

        return vowelCount;
    }
}
