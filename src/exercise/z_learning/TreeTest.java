package exercise.z_learning;

import exercise.utils.TreeUtils;
import exercise.z_data.TreeNode;

public class TreeTest {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(2);

        addTree(tree.left);
        TreeUtils.printTree(tree);

        tree.left = addTree(tree.left);
        TreeUtils.printTree(tree);
    }

    private static TreeNode addTree(TreeNode tree) {
        tree = new TreeNode(4);

        return tree;
    }
}
