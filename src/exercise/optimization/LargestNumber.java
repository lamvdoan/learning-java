package exercise.optimization;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{2,2,1,1,1,2,2}));
        System.out.println(largestNumber(new int[]{2,3,3}));
        System.out.println(largestNumber(new int[]{2,2,3}));
        System.out.println(largestNumber(new int[]{3}));
        System.out.println(largestNumber(new int[]{6,6,6,7,7}));
    }

    private static int largestNumber(int[] nums) {
        if (nums.length == 1) return nums[0];

        Arrays.sort(nums);
        int criteria = nums.length / 2;
        int count = 1;
        int candidate = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                if (++count > criteria) return nums[i];
            } else {
                count = 1;
                candidate = nums[i];
            }
        }

        return -1;
    }
}
