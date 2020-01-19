package exercise.optimization;

/*
 * Runtime: 1 ms, faster than 99.20% of Java online submissions for Jump Game.
 * Memory Usage: 37.5 MB, less than 100.00% of Java online submissions for Jump Game.
 */
public class JumpGame {
    public static void main(String[] args) {
        System.out.println("false, " + canJump(new int[]{0,1}));
        System.out.println("true, " + canJump(new int[]{1, 0}));
        System.out.println("true, " + canJump(new int[]{0}));
        System.out.println("true, " + canJump(new int[]{2,3,1,1,4}));
        System.out.println("false, " + canJump(new int[]{3,2,1,0,4}));
        System.out.println("true, " + canJump(new int[]{4,3,5,3,2,2,0,1,0}));
        System.out.println("false, " + canJump(new int[]{4,3,5,3,2,2,0,0,2,1,0}));
        System.out.println("false, " + canJump(new int[]{1,0,4,3,5,3,2,2,0,0,0,0,0,2,1,0}));
        System.out.println("false, " + canJump(new int[]{4,3,5,3,2,2,1,0,0}));
        System.out.println("false, " + canJump(new int[]{1,0,0,1,4}));
    }

    private static boolean canJump(int[] nums) {
        int maxIndex = nums.length - 1;
        int currentIndex = -1;
        int nextIndex = 0;
        int potentialMaxIndex = 0;

        while (currentIndex != nextIndex) {
            currentIndex = nextIndex;
            int limit = currentIndex + nums[currentIndex];

            if (limit >= maxIndex) return true;

            for (int i = currentIndex + 1; i <= limit; i++) {
                if (i + nums[i] >= potentialMaxIndex) { // find largest leap closest to last index
                    potentialMaxIndex = i + nums[i];
                    nextIndex = i;
                }
            }
        }

        return false;
    }
}
