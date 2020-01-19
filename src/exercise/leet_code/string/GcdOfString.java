package exercise.leet_code.string;

/*
 *  str1 = "ABABAB", str2 = "ABAB", output = "AB"
 *  str1 = "ABCABC", str2 = "ABC", output = "ABC"
 *  str1 = "LEET", str2 = "CODE", output = ""
 *
 *  1) we start with the shorter string as it can slightly save the time.
 *  2) iteratively get the substring, we can skip all the substrings that totalLength % sub.length != 0
 *  because it is not the divisor for sure.
 *  3) then use replaceAll() to check
 *
 */

public class GcdOfString {
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
        System.out.println(gcdOfStrings("LEET", "CODE"));
    }

    public static String gcdOfStrings(String s1, String s2) {
        String shorter = s1.length() < s2.length() ? s1 : s2; // 1)
        int shorterLength = shorter.length();
        for (int divisor = 1; divisor <= shorterLength; divisor++) {
            if (shorterLength % divisor != 0) continue;  // 2)
            String gcd = shorter.substring(0, shorterLength / divisor);
            if (s1.replaceAll(gcd, "").equals("") && s2.replaceAll(gcd, "").equals("")) { // 3)
                return gcd;
            }
        }
        return "";
    }
}
