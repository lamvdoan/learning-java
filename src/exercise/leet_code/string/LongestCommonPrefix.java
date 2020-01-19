package exercise.leet_code.string;

/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 */

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println("d, " + longestCommonPrefix(new String[]{"d", "dog", "dog"}));
        System.out.println("fl, " + longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(" , " + longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println("f, " + longestCommonPrefix(new String[]{"flower","flower","f"}));
        System.out.println("test, " + longestCommonPrefix(new String[]{"test"}));
        System.out.println(" , " + longestCommonPrefix(new String[]{"", "car", "cars"}));
    }

    private static String longestCommonPrefix(String[] strs) {
        // only one word
        if (strs.length == 0 || strs == null) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }

        // find length of the shortest word
        int minLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
            }
        }

        // find if any word is ""
        if (minLength == 0) {
            return "";
        }

        // Each Letter
        StringBuilder sb = new StringBuilder("");
        for (int letterIndex = 0; letterIndex < minLength; letterIndex++) {
            char letter = strs[0].charAt(letterIndex); // always first word

            // Each String
            for (int elementNumber = 1; elementNumber < strs.length; elementNumber++) {
                if (letter != strs[elementNumber].charAt(letterIndex)) {
                    return sb.toString();
                }
            }

            sb.append(letter);
        }

        return sb.toString();
    }
}
