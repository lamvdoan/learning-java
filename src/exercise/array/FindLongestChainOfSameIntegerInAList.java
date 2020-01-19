package exercise.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Find the longest difference between 2 same integers in a list.
 *
 * E.g.
 * [2,2,2,2] will return 3
 * [1,2,4,6,6,2,4] will return 4
 * [1,2,3,6,6,4,7,8] will return 1
 */

public class FindLongestChainOfSameIntegerInAList {
    public static void main(String[] args) {
        int[] list1 = new int[] {1,2,3,6,6,4,7,8};
        int[] list2 = new int[] {1,2,4,6,6,2,4,1};
        int[] list3 = new int[] {1,2,4,6,6,2,4};
        int[] list4 = new int[] {2,2,2,2};
        int[] list5 = new int[] {1,2,3,4};

        System.out.println("1, " + getPattern(list1));
        System.out.println("7, " + getPattern(list2));
        System.out.println("4, " + getPattern(list3));
        System.out.println("3, " + getPattern(list4));
        System.out.println("0, " + getPattern(list5));
    }

    private static int getPattern(int[] list) {
        // Obtain set of duplicate numbers
        Set<Integer> occurrence = new HashSet<>();
        List<Integer> dupes = new ArrayList<>();

        // O(n)
        for (int number : list) {
            if (occurrence.contains(number)) {
                dupes.add(number);
            } else {
                occurrence.add(number);
            }
        }

        if (dupes.size() == 0) {
            return 0;
        }


        // Find the longest distance
        int max = 0;

        // O(n/2) max
        for (Integer number : dupes) {
            int start = 0;
            int end = list.length - 1;

            // Find leftmost occurrence of duplicate number
            while (list[start] != number && Math.abs(end - start) > max) {
                start++;
            }

            // Find rightmost occurrence of duplicate number
            while (list[end] != number && Math.abs(end - start) > max) {
                end--;
            }

            max = Math.max(max, Math.abs(end - start));
        }

        return max;
    }
}
