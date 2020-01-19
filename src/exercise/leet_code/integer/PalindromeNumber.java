package exercise.leet_code.integer;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println("true, " + isPalindrome(121));
        System.out.println("true, " + isPalindrome(0));
        System.out.println("true, " + isPalindrome(5));
        System.out.println("false, " + isPalindrome(10));
        System.out.println("false, " + isPalindrome(100));
        System.out.println("true, " + isPalindrome(1221));
        System.out.println("true, " + isPalindrome(12321));
        System.out.println("false, " + isPalindrome(1212));
        System.out.println("false, " + isPalindrome(1121));
    }

    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        } else if (x % 10 == 0) {
            return false;
        }

        int reversed = x % 10;

        while (x / 10 > reversed) {
            x /= 10;
            reversed = (reversed * 10) + (x % 10);
        }

        return x == reversed || x / 10 == reversed;
    }
}
