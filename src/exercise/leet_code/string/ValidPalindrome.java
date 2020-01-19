package exercise.leet_code.string;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println("" + isPalindrome(""));
        System.out.println("" + isPalindrome("A man, a plan, a canal: Panama"));
    }

    private static boolean isPalindrome(String s) {
        if (s == null) return false;
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return s.equals(new StringBuffer(s).reverse().toString());
    }


}
