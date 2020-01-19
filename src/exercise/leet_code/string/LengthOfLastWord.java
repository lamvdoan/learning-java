package exercise.leet_code.string;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("Hello"));
        System.out.println(lengthOfLastWord(""));
        System.out.println(lengthOfLastWord(null));
        System.out.println(lengthOfLastWord(" "));
    }

    private static int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) return 0;

        String[] split = s.split(" ");

        return split.length == 0 ? 0 : split[split.length - 1].length();
    }
}
