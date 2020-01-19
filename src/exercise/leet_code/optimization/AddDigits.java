package exercise.leet_code.optimization;

/*
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Digits.
 * Memory Usage: 33.4 MB, less than 6.67% of Java online submissions for Add Digits.
 */
public class AddDigits {
    public static void main(String[] args) {
    }

    public int addDigits(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;

            if (num == 0) {
                if (sum < 10) return sum;

                num = sum;
                sum = 0;
            }
        }

        return -1;
    }
}
