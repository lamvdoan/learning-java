package exercise.optimization;

import java.util.HashSet;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(happyNumber(19));
        System.out.println(happyNumber(2));
        System.out.println(happyNumber(0));
    }

    private static boolean happyNumber(int n) {
        HashSet<Integer> set = new HashSet<>();
        int sum = n;

        while (set.add(sum)) {
            int remaining = sum;
            sum = 0;

            while (remaining > 0) {
                sum += (remaining % 10) * (remaining % 10);
                remaining /= 10;
            }

            if (sum == 1) return true;
        }

        return false;
    }
}
