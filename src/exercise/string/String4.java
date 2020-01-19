package exercise.string;

// String reverse using recursion

public class String4 {
    public static void main(String[] args) {
        String word = "reverse";
        System.out.println(stringReverse(word));
        System.out.println(stringReverseRecursion(word));
    }

    private static String stringReverseRecursion(String word) {
        if (word.length() == 1) {
            return word;
        }

        return stringReverseRecursion(word.substring(1)) + word.charAt(0);
    }

    public static String stringReverse(String word) {
        String reversedWord = "";
        char[] wordChar = word.toCharArray();

        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord += String.valueOf(wordChar[i]);
        }

        return reversedWord;
    }
}
