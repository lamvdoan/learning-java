package exercise.dynamic_programming;

/*
 *  0,1,1,2,3,5,8,13,21,34,55
 */

public class fibinocciSolution {
    public static void main(String[] args) {
        System.out.println("0: 0, " + fibinocci(0));
        System.out.println("1: 1, " + fibinocci(1));
        System.out.println("4: 3, " + fibinocci(4));
        System.out.println("8: 21, " + fibinocci(8));

        System.out.println();

        System.out.println("0: 0, " + fibinocciDp(0));
        System.out.println("1: 1, " + fibinocciDp(1));
        System.out.println("4: 3, " + fibinocciDp(4));
        System.out.println("8: 21, " + fibinocciDp(8));

        System.out.println();

        System.out.println("0: 0, " + fibinocciBottomUp(0));
        System.out.println("1: 1, " + fibinocciBottomUp(1));
        System.out.println("4: 3, " + fibinocciBottomUp(4));
        System.out.println("8: 21, " + fibinocciBottomUp(8));

        System.out.println();

        System.out.println("0: 0, " + fibinocciFewVariables(0));
        System.out.println("1: 1, " + fibinocciFewVariables(1));
        System.out.println("4: 3, " + fibinocciFewVariables(4));
        System.out.println("8: 21, " + fibinocciFewVariables(8));
    }

    private static int fibinocci(int n) {
        if (n == 0 || n == 1) return n;

        return fibinocci(n - 1) + fibinocci(n - 2);
    }

    private static int fibinocciDp(int n) {
        return fibinocciDp(n, new int[n + 1]);
    }

    private static int fibinocciDp(int n, int[] memo) {
        if (n == 0 || n == 1) return n;

        if (memo[n] == 0) {
            memo[n] = fibinocciDp(n - 1, memo) + fibinocciDp(n - 2, memo);
        }

        return memo[n];
    }

    private static int fibinocciBottomUp(int n) {
        if (n < 2) return n;

        int[] memo = new int[n + 1];

        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i < n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n - 1] + memo[n - 2];
    }

    private static int fibinocciFewVariables(int n) {
        if (n < 2) return n;

        int a = 0;
        int b = 1;

        for (int i = 2; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return a + b;
    }
}
