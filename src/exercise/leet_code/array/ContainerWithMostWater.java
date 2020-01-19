package exercise.leet_code.array;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println("49, " + maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println("56, " + maxArea(new int[]{8,1,6,2,5,4,8,3,7}));
        System.out.println("0, " + maxArea(new int[]{0,0,0}));
        System.out.println("2, " + maxArea(new int[]{1,1,1}));
        System.out.println("2, " + maxArea(new int[]{1,2,3}));
        System.out.println("2, " + maxArea(new int[]{3,2,1}));
    }
    private static int maxArea(int[] height) {
        int maxArea = 0;

        for (int i = height.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (i-j));
            }
        }

        return maxArea;
    }
}
