package exercise.optimization;

import java.util.HashMap;

public class FirsUniqueCharacter {
    public static void main(String[] args) {
        System.out.println("0," + firstUniqChar("leetcode"));
        System.out.println("2," + firstUniqChar("loveleetcode"));
        System.out.println("1," + firstUniqChar("abcdea"));
        System.out.println("0," + firstUniqChar("abcdef"));
        System.out.println("2," + firstUniqChar("eeoiau"));
    }

    private static int firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            map.put(c, map.containsKey(c));
        }

        for (int i = 0; i < s.length(); i++) {
            if (!map.get(s.charAt(i)) ) {
                return i;
            }
        }

        return -1;
    }
}
