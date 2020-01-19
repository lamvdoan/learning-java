package exercise.z_learning;

import exercise.z_data.Node;
import exercise.z_data.Point;
import exercise.z_data.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MethodChangeObjects {
    public static void main(String[] args) {
        System.out.println("ArrayList");
        ArrayList<Integer> numberA = new ArrayList<>(Arrays.asList(5,6,7,8,9));
        printNumbers(numberA);
        add88ToArrayList(numberA);
        printNumbers(numberA);
        System.out.println();


        System.out.println("Primitive int Array");
        int[] numberB = new int[5];
        numberB[0] = 1;
        numberB[1] = 2;
        numberB[2] = 3;
        numberB[3] = 4;
        printNumbers(numberB);
        changeArrayElementTo99(numberB);
        printNumbers(numberB);
        System.out.println();


        System.out.println("Primitive String Array");
        String[] strings = new String[] {"a", "b", "c"};
        print(strings);
        changeArrayElementToD(strings);
        print(strings);
        System.out.println();


        System.out.println("String");
        String word = "sentence";
        System.out.println(word);
        appendToString(word);
        System.out.println(word);
        System.out.println();


        System.out.println("int");
        int a = 5;
        System.out.println(a);
        changeInt(a);
        System.out.println(a);
        System.out.println();


        System.out.println("WeightedNode");
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        printNumbers(node);
        changeNodeValue(node);
        printNumbers(node);
        System.out.println();


        System.out.println("Object");
        Point p = new Point(1, 2);
        System.out.println(p.x + " " + p.y);
        changePoint(p);
        System.out.println(p.x + " " + p.y);
        System.out.println();


        System.out.println("Array and variable");
        int[] numberC = new int[5];
        numberC[3] = 4;
        int intC = numberC[3];
        Integer integerC = numberC[3];
        numberC[3] = 9;
        System.out.println(intC);
        System.out.println(integerC);
        System.out.println();


        System.out.println("Array<WeightedNode>");
        ArrayList<Node> nodes = new ArrayList<>(Collections.singletonList(new Node(5)));
        System.out.println(nodes.get(0).data);
        Node n = nodes.get(0);
        n.data = 99;
        System.out.println(nodes.get(0).data);
        System.out.println();
    }


    private static void changeInt(int a) {
        a = 7;
    }

    private static void changePoint(Point p) {
        p.y = 50;
    }

    private static void changeNodeValue(TreeNode node) {
        node.left = new TreeNode(60);
    }

    private static void add88ToArrayList(ArrayList<Integer> a) {
        ArrayList<Integer> b = a;
        b.add(88);
    }

    private static void changeArrayElementTo99(int[] b) {
        b[4] = 99;
    }

    private static void changeArrayElementToD(String[] s) {
        s[1] = "D";
    }

    private static void appendToString(String word) {
        word = "asdfasdf";
    }

    private static void printNumbers(ArrayList<Integer> a) {
        for (int number : a) {
            System.out.print(number + " ");
        }

        System.out.println();
    }

    private static void printNumbers(int[] b) {
        for (int number : b) {
            System.out.print(number + " ");
        }

        System.out.println();
    }

    private static void print(String[] strings) {
        for (String s : strings) {
            System.out.print(s + " ");
        }

        System.out.println();
    }

    private static void printNumbers(TreeNode node) {
        System.out.println(String.format("%s, %s, %s", node.getVal(), node.left.getVal(), node.right.getVal()));
    }
}
