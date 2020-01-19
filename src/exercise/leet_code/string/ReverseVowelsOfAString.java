package exercise.leet_code.string;

/*
 * Runtime: 2 ms, faster than 98.87% of Java online submissions for Reverse Vowels of a String.
 * Memory Usage: 37.7 MB, less than 100.00% of Java online submissions for Reverse Vowels of a String.
 */

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        System.out.println("holle, " + reverseVowels("hello"));
        System.out.println("leotcede, " + reverseVowels("leetcode"));
        System.out.println("uoiea, " + reverseVowels("aeiou"));
        System.out.println("aga, " + reverseVowels("aga"));
        System.out.println("bcdf, " + reverseVowels("bcdf"));
        System.out.println(", " + reverseVowels(""));
        System.out.println("aA, " + reverseVowels("Aa"));
    }

    public static String reverseVowels(String s) {
        if (s == null || s.isEmpty()) return "";

        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();

        while (left < right) {
            while (left < right && !containVowel(chars[left])) {
                left++;
            }

            while (left < right && !containVowel(chars[right])) {
                right--;
            }

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return String.valueOf(chars);
    }

    private static boolean containVowel(char c) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        for (char vowel : vowels) {
            if (c == vowel) return true;
        }

        return false;
    }
}
