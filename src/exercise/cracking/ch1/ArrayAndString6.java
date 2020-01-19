package exercise.cracking.ch1;

/*
 *  String Compression: Implement a method to perform basic string compression using the counts of repeated characters.
 *  For example, the string aabcccccaaa would become a2blc5a3, If the "compressed" string would not become smaller than
 *  the original string, your method should return the original string. You can assume the string has only uppercase
 *  and lowercase letters (a - z).
 */

import exercise.utils.RunTime;

public class ArrayAndString6 {
    private static RunTime time1 = new RunTime();
    private static RunTime time2 = new RunTime();
    private static RunTime time3 = new RunTime();
    private static RunTime time4 = new RunTime();

    public static void main(String[] args) {
        System.out.println("String Compression");
        System.out.println("******************\n");

        for (int i = 0; i < 2; i++) {
            executeTest("aabcccccaaa");  // returns a2b1c5a3
            executeTest("aaa"); // returns a1
            executeTest("abcd"); // returns abcd

            System.out.println();
        }

        System.out.println("// Lam's Solution");
        time1.getAverageElapsedTime();

        System.out.println("\n// Books's solution");
        time2.getAverageElapsedTime();

        System.out.println("\n// Books's solution with Lam's twisted optimal cut off");
        time3.getAverageElapsedTime();

        System.out.println("\n// Books's optimal solution for shorter characters");
        time4.getAverageElapsedTime();
    }

    private static void executeTest(String s) {
        System.out.println(String.format("Word: %s", s));

        time1.start();
        System.out.println(stringCompression(s));
        time1.endAndPrintElapsedTime();

        time2.start();
        System.out.println(stringCompression2(s));
        time2.endAndPrintElapsedTime();

        time3.start();
        System.out.println(stringCompression3(s));
        time3.endAndPrintElapsedTime();

        time4.start();
        System.out.println(stringCompression4(s));
        time4.endAndPrintElapsedTime();

        System.out.println();
    }

    private static String stringCompression(String s) {
        StringBuilder compressedString = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count++;

            if (i == s.length() - 1) {
                // looking for last iteration and perform tasks if so
                compressedString.append(String.valueOf(c)).append(count);
            } else if (c == s.charAt(i + 1)) {
                // next character is sequential
            } else {
                // next character is not sequential, so reset count and append to compression string
                compressedString.append(String.valueOf(c)).append(count);
                count = 0;
            }
        }

        return compressedString.length() > s.length() ? s : compressedString.toString();
    }

    private static String stringCompression2(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count++;

            if ((i >= s.length() - 1) || (s.charAt(i) != s.charAt(i + 1))) {
                sb.append(String.valueOf(s.charAt(i))).append(count);

                count = 0;
            }
        }

        return sb.length() > s.length() ? s : sb.toString();
    }

    private static String stringCompression3(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count++;

            if ((i >= s.length() - 1) || (s.charAt(i) != s.charAt(i + 1))) {
                sb.append(String.valueOf(s.charAt(i))).append(count);

                if (sb.length() > s.length()) {
                    return s;
                }

                count = 0;
            }
        }

        return sb.length() > s.length() ? s : sb.toString();
    }

    private static String stringCompression4(String s) {
        int finalLength = getCompressionLength(s);

        if (finalLength > s.length()) {
            return s;
        }

        StringBuilder sb = new StringBuilder(finalLength);
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count++;

            if ((i >= s.length() - 1) || (s.charAt(i) != s.charAt(i + 1))) {
                sb.append(String.valueOf(s.charAt(i))).append(count);
                count = 0;
            }
        }

        return sb.toString();
    }

    private static int getCompressionLength(String s) {
        int countCompressionLength = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count++;

            if ((i >= s.length() - 1) || (s.charAt(i) != s.charAt(i + 1))) {
                countCompressionLength += String.valueOf(count).length();
                count = 0;
            }
        }

        return countCompressionLength;
    }
}
