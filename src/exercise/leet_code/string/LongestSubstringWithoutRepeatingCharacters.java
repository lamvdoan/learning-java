package exercise.leet_code.string;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println("3, " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("2, " + lengthOfLongestSubstring("au"));
        System.out.println("3, " + lengthOfLongestSubstring("pwwkew"));
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        for (int i = s.length(); i > 1; i--) {
            for (int j = 0; j + i <= s.length(); j++) {
                String n = s.substring(j, i + j);

                if (isStringUnique(n)) {
                    return n.length();
                }
            }
        }

        return 1;
    }

    private static boolean isStringUnique(String s) {
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (set.contains(c)) {
                return false;
            } else {
                set.add(c);
            }
        }

        return true;
    }
}
