package exercise.cracking.ch8;

/*
 *  Solution only, did not implement this.
 */
public class TripleStep {
    public static void main(String[] args) {
        System.out.println(countWays(4));
        System.out.println(countWays(5));
        System.out.println(countWaysMemoize(4));
        System.out.println(countWaysMemoize(5));
    }

    /*
     *  1) 3 1
     *  2) 2 2
     *  3) 1 3
     *  4) 1 1 2
     *  5) 1 2 1
     *  6) 2 1 1
     *  7) 1 1 1 1

    /*
     *  1) 3 2
     *  2) 3 1 1
     *  3) 2 3
     *  4) 2 2 1
     *  5) 2 1 2
     *  6) 2 1 1 1
     *  7) 1 3 1
     *  8) 1 1 3
     *  9) 1 2 2
     * 10) 1 2 1 1
     * 11) 1 1 2 1
     * 12) 1 1 1 2
     * 13) 1 1 1 1 1
     */

    private static int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }

    private static int countWaysMemoize(int n) {
        int[] memo = new int[n + 1];
        return countWaysMemoize(n, memo);
    }

    private static int countWaysMemoize(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] != 0) {
            return memo[n];
        } else {
            memo[n] = countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
            return memo[n];
        }
    }
}
