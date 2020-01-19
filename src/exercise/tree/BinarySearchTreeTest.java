package exercise.tree;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(9);
        tree.insert(8);
        tree.insert(10);
        tree.insert(4);
        tree.insert(13);
        tree.insert(0);
        tree.insert(90);

        System.out.println("true, " + tree.search(2));
        System.out.println("true, " + tree.search(10));
        System.out.println("false, " + tree.search(3));
        System.out.println("false, " + tree.search(99));
        System.out.println("true, " + tree.search(13));
        System.out.println("true, " + tree.search(0));
        System.out.println("true, " + tree.search(90));

        System.out.println("\nPre Order Traversal");
        tree.printTree(1);

        System.out.println("\nIn Order Traversal");
        tree.printTree(2);

        System.out.println("\nPost Order Traversal");
        tree.printTree(3);

        System.out.println("\nLevel Order Traversal");
        tree.printTree(4);
        // 5, 2, 7, 1, 9, 8
    }
}
