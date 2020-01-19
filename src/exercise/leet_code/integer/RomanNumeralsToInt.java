package exercise.leet_code.integer;

public class RomanNumeralsToInt {
    private static final String I = "I";
    private static final String V = "V";
    private static final String X = "X";
    private static final String L = "L";
    private static final String C = "C";
    private static final String D = "D";
    private static final String M = "M";

    public static void main(String[] args) {
        String input1 = "III";
        String input2 = "IV";
        String input3 = "IX";
        String input4 = "XIV";
        String input5 = "CMXCII";
        String input6 = "MCMXCIV";

        System.out.println(String.format("Roman: %s = %s", input1, romanToInt(input1)));
        System.out.println(String.format("Roman: %s = %s", input2, romanToInt(input2)));
        System.out.println(String.format("Roman: %s = %s", input3, romanToInt(input3)));
        System.out.println(String.format("Roman: %s = %s", input4, romanToInt(input4)));
        System.out.println(String.format("Roman: %s = %s", input5, romanToInt(input5)));
        System.out.println(String.format("Roman: %s = %s", input6, romanToInt(input6)));
    }

    private static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int value = 0;

        for (int i = 0; i < chars.length; i++) {
            String letter = Character.toString(chars[i]);
            int cur = getValue(letter);
            int next = 0;

            if (i + 1 < chars.length) {
                String nextLetter = Character.toString(chars[i + 1]);

                if (letter.equals(I) && nextLetter.equals(V)
                        || letter.equals(I) && nextLetter.equals(X)
                        || letter.equals(X) && nextLetter.equals(L)
                        || letter.equals(X) && nextLetter.equals(C)
                        || letter.equals(C) && nextLetter.equals(D)
                        || letter.equals(C) && nextLetter.equals(M)) {

                    next = getValue(nextLetter) + (cur * -2);
                    i++;
                }
            }

            value = value + cur + next;
        }

        return value;
    }

    private static int getValue(String s) {
        switch (s) {
            case I:
                return 1;
            case V:
                return 5;
            case X:
                return 10;
            case L:
                return 50;
            case C:
                return 100;
            case D:
                return 500;
            default:
                return 1000;
        }
    }
}
