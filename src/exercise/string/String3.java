package exercise.string;

import java.util.*;

// Print first non repeated character

public class String3 {
    public static void main(String[] args) {
        System.out.println(firstNonRepeatedCharacter1( "Duplicate Characters"));
        System.out.println(firstNonRepeatedCharacter1( "Swiss"));
        System.out.println(firstNonRepeatedCharacter2( "Duplicate Characters"));
        System.out.println(firstNonRepeatedCharacter2( "Swiss"));
    }

    public static String firstNonRepeatedCharacter1(String string) {
        char[] stringChars = string.replace(" ", "").toLowerCase().toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();

        for (char c : stringChars) {
            charMap.put(c, charMap.containsKey(c) ? charMap.get(c) + 1 : 1);
        }

        for (char c : stringChars) {
            if (charMap.get(c) == 1) {
                return String.valueOf(c);
            }
        }

        return null;
    }

    public static String firstNonRepeatedCharacter2(String string) {
        Set<String> repeatingCharacters = new HashSet<>();
        List<String> nonRepeatingCharacters = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            String letter = String.valueOf(string.charAt(i)).toLowerCase();

            if (repeatingCharacters.contains(letter)) {

            } else if (nonRepeatingCharacters.contains(letter)) {
                nonRepeatingCharacters.remove(letter);
                repeatingCharacters.add(letter);
            } else {
                nonRepeatingCharacters.add(letter);
            }
        }

        return nonRepeatingCharacters.get(0);
    }
}
