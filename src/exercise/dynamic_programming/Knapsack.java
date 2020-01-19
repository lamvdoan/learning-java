package exercise.dynamic_programming;

public class Knapsack {
    public static void main(String[] args) {
        System.out.println("220, " + knapsack(50, new int[]{10, 20, 30}, new int[]{60, 100, 120}, 3));
        System.out.println("220, " + knapsack(50, new int[]{10, 20, 30}, new int[]{60, 100, 120}, 3));

        System.out.println("220, " + knapSackSolution(50, new int[]{10, 20, 30}, new int[]{60, 100, 120}, 3));
        System.out.println("220, " + knapSackSolution(70, new int[]{10, 20, 30, 40}, new int[]{60, 100, 120, 110}, 4));
    }

    private static int knapsack(int maxWeight, int[] weight, int[] value, int n) {
        return 0;
    }

    private static int knapSackSolution(int maxWeight, int weight[], int value[], int n) {
        if (n == 0 || maxWeight == 0) return 0;

        if (weight[n - 1] > maxWeight) {
            return knapSackSolution(maxWeight, weight, value, n - 1);
        } else {
            return max(
                    knapSackSolution(maxWeight - weight[n - 1], weight, value, n - 1) + value[n - 1],
                    knapSackSolution(maxWeight, weight, value, n - 1)
            );
        }
    }

    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
