package exercise.utils;

import exercise.leet_code.binary_tree.MaxDepthBinaryTree;
import exercise.z_data.TreeNode;

import java.util.List;

public class TreeUtils {
    public static TreeNode generateTree(List<Integer> list) {
        if (list.size() == 0) {
            return null;
        }

        TreeNode t = new TreeNode();
        t = insertLevelOrder(t, list, 0);

        return t;
    }

    /*
                          1
                       /     \
                     2         3
                   /   \     /   \
                 4      5   6      7
               /  \    / \ / \    / \
              8    9 10 11 12 13 14  15
     */
    private static TreeNode insertLevelOrder(TreeNode tree, List<Integer> list, int i) {
        if (i < list.size()) {
            tree = new TreeNode(list.get(i));

            tree.left = insertLevelOrder(tree.left, list, 2 * i + 1);
            tree.right = insertLevelOrder(tree.right, list, 2 * i + 2);
        }
        return tree;
    }

    public static void printTree(TreeNode root) {
        int depth = MaxDepthBinaryTree.maxDepth(root);

        for (int level = 0; level < depth; level++) {
            printTree(root, level);
        }

        System.out.println();
    }

    private static void printTree(TreeNode root, int level) {
        if (root != null) {
            if (level == 0) {
                print(root);
            } else if (level > 0) {
                printTree(root.left, level - 1);
                printTree(root.right, level - 1);
            }
        }
    }

    private static void print(TreeNode node) {
        System.out.print(node.val + " ");
    }
}
