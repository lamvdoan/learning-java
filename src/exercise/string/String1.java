package exercise.string;

import java.util.HashMap;
import java.util.Map;

// Check for duplicate characters

public class String1 {
    public static void main(String[] args) {
        String string = "Duplicate Characters";
        char[] stringChars = string.replace(" ", "").toLowerCase().toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();

        for (char c : stringChars) {
            charMap.put(c, charMap.containsKey(c) ? charMap.get(c) + 1 : 1);
        }

        charMap.entrySet().stream().filter(map -> map.getValue() > 1).forEach(map -> {
            System.out.println(map.getKey() + ": " + map.getValue());
        });
    }
}
