package exercise.leet_code.binary_tree;

/*
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 *
 * NOTE:
 * 1) The number of nodes in the tree will be between 2 and 100.
 * 2) Each node has a unique integer value from 1 to 100.
 */

import exercise.utils.TreeUtils;
import exercise.z_data.TreeNode;

import java.util.Arrays;

public class CousinsInBinaryTree {
    public static void main(String[] args) {
        TreeNode tree = TreeUtils.generateTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        TreeUtils.printTree(tree);
        System.out.println("1,2 = false," + isCousins(tree, 1, 2));
        System.out.println("5,6 = true," + isCousins(tree, 5, 6));
        System.out.println("15,8 = true," + isCousins(tree, 15, 8));
        System.out.println("4,7 = true," + isCousins(tree, 4, 7));
        System.out.println("2,3 = false," + isCousins(tree, 2, 3));
        System.out.println("4,5 = false," + isCousins(tree, 4, 5));
        System.out.println("5,9 = false," + isCousins(tree, 9, 5));
        System.out.println("2,6 = false," + isCousins(tree, 2, 6));
    }

    private static boolean isCousins(TreeNode root, int x, int y) {
        return getDepth(root, x, 0) == getDepth(root, y, 0) && getParentValue(root, x) != getParentValue(root, y);
    }

    private static int getDepth(TreeNode tree, int val, int depth) {
        if (tree != null) {
            if (tree.val == val) {
                return depth;
            }

            depth++;
            return Math.max(getDepth(tree.left, val, depth), getDepth(tree.right, val, depth));
        }

        return 0;
    }

    private static int getParentValue(TreeNode tree, int child) {
        if (tree != null) {
            if ((tree.left != null && tree.left.val == child)
                    || (tree.right != null && tree.right.val == child)) {
                return tree.val;
            }

            return Math.max(getParentValue(tree.left, child), getParentValue(tree.right, child));
        }

        return 0;
    }
}
