package exercise.z_learning;

import java.util.Arrays;

/*
 * Runtime: 3 ms, faster than 48.46% of Java online submissions for Single Number.
 * Memory Usage: 38.8 MB, less than 98.52% of Java online submissions for Single Number.
 */

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(singleNumber(new int[]{2, 2, 1}));
    }

    private static int singleNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i = i + 2) {
            if (i + 1 == nums.length || nums[i] != nums[i + 1]) return nums[i];
        }

        return 0;
    }
}
