package exercise.string;

// Check if two strings are anagrams

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class String2 {
    public static void main(String[] args) {
        String stringOne = "Listen";
        String stringTwo = "Silent";

        System.out.println(stringOne + " and " + stringTwo + " is anagram? " + isAnagram1(stringOne, stringTwo));
        System.out.println(stringOne + " and " + stringTwo + " is anagram? " + isAnagram2(stringOne, stringTwo));
    }

    public static boolean isAnagram1(String stringOne, String stringTwo) {
        if (stringOne.length() != stringTwo.length()) {
            return false;
        }

        char[] charOne = stringOne.toLowerCase().toCharArray();
        char[] charTwo = stringTwo.toLowerCase().toCharArray();

        Arrays.sort(charOne);
        Arrays.sort(charTwo);

        return Arrays.equals(charOne, charTwo);
    }

    public static boolean isAnagram2(String stringOne, String stringTwo) {
        if (stringOne.length() != stringTwo.length()) {
            return false;
        }

        Map<Character, Integer> mapOne = stringToMap(stringOne);
        Map<Character, Integer> mapTwo = stringToMap(stringTwo);

        return mapOne.equals(mapTwo);
    }

    private static Map<Character, Integer> stringToMap(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : chars) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        return map;
    }
}
