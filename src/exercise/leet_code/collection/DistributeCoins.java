package exercise.leet_code.collection;

/*
 * INCOMPLETE!
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the
 * fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * [1,2,5]
11
[2,5]
3
[1,2,5,10]
49
Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
 *
 */

import java.util.Arrays;

public class DistributeCoins {
    public static void main(String[] args) {
        int[] list1 = new int[]{1, 2, 5};
        int amount1 = 11;
        System.out.println(Arrays.toString(list1) + ", " + amount1 + ": 3, " + coinChange(list1, amount1));

        int[] list2 = new int[]{2, 5};
        int amount2 = 3;
        System.out.println(Arrays.toString(list2) + ", " + amount2 + ": -1, " + coinChange(list2, amount2));

        int[] list3 = new int[]{1, 2, 5, 10};
        int amount3 = 49;
        System.out.println(Arrays.toString(list3) + ", " + amount3 + ": 7, " + coinChange(list3, amount3));

        int[] list4 = new int[]{1, 2, 5};
        int amount4 = 6;
        System.out.println(Arrays.toString(list4) + ", " + amount4 + ": 2, " + coinChange(list4, amount4));

        int[] list5 = new int[]{186, 419, 83, 408};
        int amount5 = 6249;
        System.out.println(Arrays.toString(list5) + ", " + amount5 + ": 20, " + coinChange(list5, amount5));

        int[] list6 = new int[]{1, 5, 6, 13};
        int amount6 = 22;
        System.out.println(Arrays.toString(list6) + ", " + amount6 + ": 4, " + coinChange(list6, amount6));
    }

    private static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Arrays.sort(coins);

        for (int index = coins.length - 1; index >= 0; index--) {
            int currentIndex = index;
            int currentAmount = amount;
            int count = 0;

            while (true) {
                int result = currentAmount - coins[currentIndex];

                if (result > 0) {
                    currentAmount = result;
                    count++;
                } else if (result == 0) {
                    return ++count;
                } else if (result < 0) {
                    if (currentIndex > 0) {
                        currentIndex--;
                    } else {
                        break;
                    }
                }
            }
        }

        return -1;
    }


    public static int coinChange2(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private static int coinChange(int[] coins, int remaining, int[] count) {
        if (remaining < 0) return -1;
        if (remaining == 0) return 0;
        if (count[remaining - 1] != 0) return count[remaining - 1];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, remaining - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[remaining - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[remaining - 1];
    }
}
