package exercise.leet_code.array;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        List<String> list1 = letterCombinations("321");

        for (String item : list1) {
            System.out.print(item + ",");
        }
    }

    private static List<String> letterCombinations(String digits) {
        List<String> combos = new ArrayList<>();

        if (digits == null || digits.length() == 0) return combos;

        combos.add("");
        String[] letters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        for (int i = 0; i < digits.length(); i++) {
            int number = (digits.charAt(i) - '0');
            combos = combine(combos, letters[number]);
        }

        return combos;
    }

    private static List<String> combine(List<String> combos, String currentLetters) {
        if (currentLetters.length() == 0) return combos;
        List<String> newCombos = new ArrayList<>();

        for (String combo : combos) {
            char[] currentLettersChars = currentLetters.toCharArray();

            for (char letter : currentLettersChars) {
                newCombos.add(combo + letter);
            }
        }

        return newCombos;
    }
}
