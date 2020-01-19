package exercise.leet_code.optimization;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(productExceptSelf(new int[]{7,1,5,3,6,4}));
        System.out.println(productExceptSelf(new int[]{7,6,4,3,1}));
        System.out.println(productExceptSelf(new int[]{7,3,2,2,2,2}));
        System.out.println(productExceptSelf(new int[]{2,4,1}));

    }

    private static int productExceptSelf(int[] prices) {
        if (prices.length < 2) return 0;

        int maxProfit = 0;
        int min = prices[0];

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }

        return maxProfit;
    }
}
