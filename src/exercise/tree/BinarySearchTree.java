package exercise.tree;

/*
 *  Binary Search Tree
 *
 *  Includes:
 *  - insert
 *  - search
 *  - print trees based on 4 traversal methods
 *
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private Node root;

    private class Node {
        Node left, right;
        int value;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    public void insert(int value) {
        root = addToNode(root, value);
    }

    private Node addToNode(Node node, int value) {
        if (node == null) {
            return new Node(value);
        } else if (value <= node.value) {
            node.left = addToNode(node.left, value);
        } else {
            node.right = addToNode(node.right, value);
        }

        return node;
    }

    // pre-order traversal
    public boolean search(int value) {
        return search(root, value);
    }

    private boolean search(Node node, int value) {
        boolean found = false;

        if (node != null) {
            if (value == node.value) {
                return true;
            } else if (value < node.value) {
                found = search(node.left, value);
            } else {
                found = search(node.right, value);
            }
        }

        return found;
    }

    public void printTree(int treeType) {

        switch(treeType) {
            case 1:
                preOrderTraversal(root);
                break;
            case 2:
                inOrderTraversal(root);
                break;
            case 3:
                postOrderTraversal(root);
                break;
            case 4:
                levelOrderTraversal();
                break;
        }

        System.out.println();
    }

    private void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.value + " ");
            inOrderTraversal(node.right);
        }
    }

    private void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.value + " ");
        }
    }

    private void levelOrderTraversal() {
        Queue<Node> queue = new LinkedList<>();
        Node node = root;
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.remove();
            System.out.print(node.value + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
