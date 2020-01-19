package exercise.leet_code.binary_tree;

/*
 * Given a sorted array and a target val, return the index if the target is found. If not, return the index where it
 * would be if it were inserted in order.  You may assume no duplicates in the array.
 */

import exercise.utils.TreeUtils;
import exercise.z_data.TreeNode;

import java.util.Arrays;

public class MaxDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode tree = TreeUtils.generateTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
        System.out.println("3, " + maxDepth(tree));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getDepth(root, 1);
    }

    private static int getDepth(TreeNode root, int current) {
        int leftDepth = current;
        int rightDepth = current;

        if (root.left != null) {
            leftDepth = getDepth(root.left, ++leftDepth);
        }

        if (root.right != null) {
            rightDepth = getDepth(root.right, ++rightDepth);
        }

        return Math.max(leftDepth, rightDepth);
    }
}
