package exercise.cracking.ch1;

/*
 *  String Rotation: Assume you have a method isSubstring which checks if one word is a substring of another.
 *  Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
 *  [e.g., "waterbottle" is a rotation of 'erbottlewat").
 */

import exercise.utils.RunTime;

public class ArrayAndString9 {
    private static RunTime time1 = new RunTime();
    private static RunTime time2 = new RunTime();
    private static RunTime time3 = new RunTime();

    public static void main(String[] args) {
        System.out.println("Rotate Matrix");
        System.out.println("*************\n");

        for (int i = 0; i < 1; i++) {
            executeTest("waterbottle", "waterbottle"); // exact same
            executeTest("waterbottle", "ewaterbottl"); // all but one letter rotated
            executeTest("waterbottle", "aterbottlew"); // one letter rotated
            executeTest("waterbottle", "esbottlewat"); // rotating, but different afterwards
            executeTest("waterbottle", "waterbottel"); // different at the end

            executeTest("waterbottle", "waterbottle"); // exact same
            executeTest("ewaterbottl", "waterbottle"); // all but one letter rotated
            executeTest("aterbottlew", "waterbottle"); // one letter rotated
            executeTest("esbottlewat", "waterbottle"); // rotating, but different afterwards
            executeTest("waterbottel", "waterbottle"); // different at the end
        }

        System.out.println("// Lam's Solution");
        time1.getAverageElapsedTime();

//        System.out.println("\n// Books's solution with Lam's for loops");
//        time2.getAverageElapsedTime();
//
//        System.out.println("\n// Books's solution");
//        time3.getAverageElapsedTime();
    }

    private static void executeTest(String s1, String s2) {
        System.out.println(String.format("Word: %s, %s", s1, s2));

        time1.start();
        System.out.println(isSubString(s1, s2));
        time1.endAndPrintElapsedTime();

//        time2.start();
//        time2.endAndPrintElapsedTime();
//
//        time3.start();
//        time3.endAndPrintElapsedTime();

        System.out.println();
    }

    private static boolean isSubString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        for (int i = 0; i < c2.length; i++) {
            if (String.valueOf(c1).equals(String.valueOf(c2))) {
                return true;
            } else {
                c2 = rotateOneCharacter(c2);
            }
        }

        return false;
    }

    private static char[] rotateOneCharacter(char[] oldChars) {
        char[] newChars = new char[oldChars.length];
        newChars[0] = oldChars[oldChars.length - 1];

        System.arraycopy(oldChars, 0, newChars, 1, oldChars.length - 1);
        return newChars;
    }
}
