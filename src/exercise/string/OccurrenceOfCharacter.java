package exercise.string;

import java.util.HashMap;
import java.util.Map;

public class OccurrenceOfCharacter {

    public static Map<String, Integer> getOccurrenceOfLetters(String string) {
        Map<String, Integer> occurrenceOfCharacters = new HashMap<>();

        // Strip all numbers, space, special characters from the string
        String sanitizedString = string.replaceAll("[^a-zA-Z -]", "").replaceAll(" ", "").toLowerCase();

        for (int i = 0; i < sanitizedString.length(); i++) {
            String letter = String.valueOf(sanitizedString.charAt(i));

            if (occurrenceOfCharacters.containsKey(letter)) {
                int newCount = occurrenceOfCharacters.get(letter) + 1;
                occurrenceOfCharacters.put(letter, newCount);
            } else {
                occurrenceOfCharacters.put(letter, 1);
            }
        }

        return occurrenceOfCharacters;
    }
}
