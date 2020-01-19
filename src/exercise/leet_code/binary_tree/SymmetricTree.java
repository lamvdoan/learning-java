package exercise.leet_code.binary_tree;

/*
 *     Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *     For example, this binary tree [1,2,2,3,4,4,3] is symmetric
 */

import exercise.z_data.TreeNode;
import exercise.utils.TreeUtils;

import java.util.Arrays;
import java.util.List;


// 1,2; 4,5; 3,6; 7,14; 8,13; 9,12; 10,11;

public class SymmetricTree {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,2,3,4,4,3);
        TreeNode tree = TreeUtils.generateTree(list);
        TreeUtils.printTree(tree);
        System.out.println(symmetricTree(tree));
    }

    private static boolean sameBranches(TreeNode root) {
        return compareBranches(root.left, root.right);
    }

    private static boolean compareBranches(TreeNode left, TreeNode right) {
        if ((left == null && right != null) || (left != null && right == null)) {
            System.out.println("one node is null");
            return false;
        } else if (left == null) {
            return true;
        }

        if (left.val != right.val) {
            System.out.println("Values are different");
            return false;
        } else {
            return compareBranches(left.left, right.left) && compareBranches(left.right, right.right);
        }
    }

    private static boolean symmetricTree(TreeNode root) {
        return root == null || compareSymmetricBranch(root.left, root.right);

    }

    private static boolean compareSymmetricBranch(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }

        return left.val == right.val
                && compareSymmetricBranch(left.left, right.right)
                && compareSymmetricBranch(left.right, right.left);
    }
}
