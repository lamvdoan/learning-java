package exercise.cracking.ch1;

// Find unique letters

import exercise.utils.RunTime;

public class ArrayAndString1 {
    private static RunTime time1 = new RunTime();

    public static void main(String[] args) {
        System.out.println("Unique characters only");
        System.out.println("**********************\n");

        for (int i = 0; i < 2; i++) {
            executeTest("tempo");
            executeTest("tempest");

            System.out.println();
        }

        time1.getAverageElapsedTime();
    }

    private static void executeTest(String s) {
        System.out.println(String.format("Word: %s:", s));

        time1.start();
        System.out.println(isUnique(s));
        time1.endAndPrintElapsedTime();
    }

    private static boolean isUnique(String word) {
        final int MAX_ASCII_CHARS = 256;
        boolean[] letters = new boolean[MAX_ASCII_CHARS];

        for (int i=0; i<word.length(); i++) {
            int value = word.charAt(i);

            if (letters[value]) {
                return false;
            }

            letters[value] = true;
        }

        return true;
    }
}
