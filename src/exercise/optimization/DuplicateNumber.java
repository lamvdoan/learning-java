package exercise.optimization;

import java.util.HashSet;

public class DuplicateNumber {
    public static void main(String[] args) {
        System.out.println("false, " + duplicateNumber(new int[]{1,2,3}));
        System.out.println("false, " + duplicateNumber(new int[]{0}));
        System.out.println("false, " + duplicateNumber(new int[]{4,-2,1,2,0}));
        System.out.println("true, " + duplicateNumber(new int[]{1,2,1,3}));
        System.out.println("true, " + duplicateNumber(new int[]{1,2,3,2,1}));
    }

    private static boolean duplicateNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) return true;
        }

        return false;
    }
}
