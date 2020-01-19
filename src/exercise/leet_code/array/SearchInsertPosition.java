package exercise.leet_code.array;

/*
 * Given a sorted array and a target val, return the index if the target is found. If not, return the index where it
 * would be if it were inserted in order.  You may assume no duplicates in the array.
 */

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println("3, " + searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println("1, " + searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println("4, " + searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println("0, " + searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println("0, " + searchInsert(new int[]{3}, 2));
        System.out.println("0, " + searchInsert(new int[]{3}, 3));
        System.out.println("1, " + searchInsert(new int[]{3}, 5));
    }

    private static int searchInsert(int[] nums, int target) {
        if ((nums.length == 1 && target <= nums[0]) || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            } else if (target > nums[i]) {
                if ((i + 1) == nums.length || target < nums[i + 1]) {
                    return i + 1;
                }
            }
        }

        return 0;
    }
}
