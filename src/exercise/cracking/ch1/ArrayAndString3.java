package exercise.cracking.ch1;

/*
 *  URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient
 *  space at the end to hold the additional characters, and that you are given the "true" length of the string.
 *  (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
 */

import exercise.utils.RunTime;

public class ArrayAndString3 {
    private static RunTime time1 = new RunTime();
    private static RunTime time2 = new RunTime();

    public static void main(String[] args) {
        System.out.println("URLify spaces to %20");
        System.out.println("********************\n");

        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("Word: %s", "Mr John Smith"));
            time1.start();
            System.out.println(urlify("Mr John Smith"));
            time1.endAndPrintElapsedTime();

            System.out.println("Word: MrEjohn");
            time1.start();
            System.out.println(urlify("MrEjohn"));
            time1.endAndPrintElapsedTime();


            time2.start();
            char[] stringChars = new char[17];
            stringChars[0] = 'M';
            stringChars[1] = 'r';
            stringChars[2] = ' ';
            stringChars[3] = 'J';
            stringChars[4] = 'o';
            stringChars[5] = 'h';
            stringChars[6] = 'n';
            stringChars[7] = ' ';
            stringChars[8] = 'S';
            stringChars[9] = 'm';
            stringChars[10] = 'i';
            stringChars[11] = 't';
            stringChars[12] = 'h';

            System.out.println(stringChars);
            urlify2(stringChars, 13);
            System.out.println(stringChars);
            time2.endAndPrintElapsedTime();


            time2.start();
            char[] stringChars2 = new char[7];
            stringChars2[0] = 'M';
            stringChars2[1] = 'r';
            stringChars2[2] = 'E';
            stringChars2[3] = 'j';
            stringChars2[4] = 'o';
            stringChars2[5] = 'h';
            stringChars2[6] = 'n';

            System.out.println(stringChars2);
            urlify2(stringChars2, 7);
            System.out.println(stringChars2);
            time2.endAndPrintElapsedTime();

            System.out.println();
        }

        System.out.println("// Lam's Solution");
        time1.getAverageElapsedTime();

        System.out.println("\n// Book's solution");
        time2.getAverageElapsedTime();
    }

    private static String urlify(String s) {
        char[] stringChars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char c : stringChars) {
            sb.append(c == ' ' ? "%20" : c);
        }

        return sb.toString();
    }

    private static void urlify2(char[] stringChars, int trueLength) {
        if (stringChars.length == trueLength) {
            return;
        }

        int newLength = trueLength;
        for (char c : stringChars) {
            if (c == ' ') {
                newLength += 2;
            }
        }

        int index = newLength - 1;

        for (int i = trueLength - 1; i >= 0; i--) {
            char letter = stringChars[i];

            if (letter == ' ') {
                stringChars[index] = '0';
                stringChars[--index] = '2';
                stringChars[--index] = '%';
            } else {
                stringChars[index] = letter;
            }

            index--;
        }
    }
}
