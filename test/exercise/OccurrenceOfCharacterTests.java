package exercise;

import exercise.string.OccurrenceOfCharacter;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class OccurrenceOfCharacterTests {
    @Test
    public void countOfMultipleTypeOfLetters() {
        String string = "This is a String";

        Map<String, Integer> expectedOccurrenceOfLetters = new HashMap<>();
        expectedOccurrenceOfLetters.put("t", 2);
        expectedOccurrenceOfLetters.put("h", 1);
        expectedOccurrenceOfLetters.put("i", 3);
        expectedOccurrenceOfLetters.put("s", 3);
        expectedOccurrenceOfLetters.put("a", 1);
        expectedOccurrenceOfLetters.put("r", 1);
        expectedOccurrenceOfLetters.put("n", 1);
        expectedOccurrenceOfLetters.put("g", 1);

        Map<String, Integer> actualOccurrenceOfLetters = OccurrenceOfCharacter.getOccurrenceOfLetters(string);
        Assert.assertEquals(
                "count of letters are off",
                expectedOccurrenceOfLetters,
                actualOccurrenceOfLetters);
    }

    @Test
    public void countOfOneTypeOfLetter() {
        String string = "zzzZzZz";

        Map<String, Integer> expectedOccurrenceOfLetters = new HashMap<>();
        expectedOccurrenceOfLetters.put("z", 7);

        Map<String, Integer> actualOccurrenceOfLetters = OccurrenceOfCharacter.getOccurrenceOfLetters(string);
        Assert.assertEquals(
                "Number of Z's are off: " + expectedOccurrenceOfLetters.get("z"),
                expectedOccurrenceOfLetters,
                actualOccurrenceOfLetters);
    }

    @Test
    public void countWhenStringSizeIsOne() {
        String string = "y";

        Map<String, Integer> expectedOccurrenceOfLetters = new HashMap<>();
        expectedOccurrenceOfLetters.put("y", 1);

        Map<String, Integer> actualOccurrenceOfLetters = OccurrenceOfCharacter.getOccurrenceOfLetters(string);
        Assert.assertEquals(
                "Number of Y's is off: " +  expectedOccurrenceOfLetters.get("y"),
                expectedOccurrenceOfLetters,
                actualOccurrenceOfLetters);
    }

    @Test
    public void countWhenStringIsEmpty() {
        String string = "";

        Map<String, Integer> expectedOccurrenceOfLetters = new HashMap<>();

        Map<String, Integer> actualOccurrenceOfLetters = OccurrenceOfCharacter.getOccurrenceOfLetters(string);
        Assert.assertEquals(
                "Should have been an empty string: ",
                expectedOccurrenceOfLetters,
                actualOccurrenceOfLetters);
    }

    @Test
    public void countWhenStringContainsNumbersAndSpecialCharacters() {
        String string = "as df1234!@#$";

        Map<String, Integer> expectedOccurrenceOfLetters = new HashMap<>();
        expectedOccurrenceOfLetters.put("a", 1);
        expectedOccurrenceOfLetters.put("s", 1);
        expectedOccurrenceOfLetters.put("d", 1);
        expectedOccurrenceOfLetters.put("f", 1);

        Map<String, Integer> actualOccurrenceOfLetters = OccurrenceOfCharacter.getOccurrenceOfLetters(string);
        Assert.assertEquals(
                "count of letters are off",
                expectedOccurrenceOfLetters,
                actualOccurrenceOfLetters);
    }
}
