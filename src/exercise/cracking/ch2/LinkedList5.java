package exercise.cracking.ch2;

/*
 *  Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit.  The digits
 *  are stored in reverse order, such that the 1's digit is at the head of the list.  Write a function that adds the
 *  two numbers and returns the sum as a linked list.  (You are not allowed to "cheat" and just convert the linked
 *  list to an integer.)
 *
 *  EXAMPLE
 *  Input:  (7 -> 1 -> 6) + (5 -> 9 -> 2).  That is, 617 + 295.
 *  Output: 2 -> 1 -> 9.  That is, 912.
 *
 *  FOLLOW UP:
 *  Suppose the digits are stored in forward order.  Repeat the above problem.
 *
 *  EXAMPLE
 *  Input:  (6 -> 1 -> 7) + (2 -> 9 -> 5).  That is, 617 + 295.
 *  Output: 9 -> 1 -> 2.  That is, 912
 *
 *  Hints: 7, 30, 71, 95, 109
 */

import exercise.z_data.Node;
import exercise.utils.NodeUtils;
import exercise.utils.RunTime;

import java.util.Arrays;
import java.util.List;

public class LinkedList5 {
    private static RunTime time1 = new RunTime();
    private static RunTime time2 = new RunTime();

    public static void main(String[] args) {
        System.out.println("Sum Lists");
        System.out.println("*************\n");


        for (int i = 0; i < 1; i++) {
            executeTest(Arrays.asList(7, 1, 6), Arrays.asList(5, 9, 2));
            executeTest(Arrays.asList(7, 1, 6), Arrays.asList(5, 9));
        }

        System.out.println("// Lam's Solution");
        time1.getAverageElapsedTime();

        System.out.println("\n// Book's solution using recursion");
        time2.getAverageElapsedTime();
    }

    private static void executeTest(List<Integer> list1, List<Integer> list2) {
        Node node1a = createNodeData(list1);
        Node node1b = createNodeData(list2);

        time1.start();
        Node node1 = sumList(node1a, node1b);
        time1.endAndPrintElapsedTime();
        NodeUtils.printList(node1);

        node1a = createNodeData(list1);
        node1b = createNodeData(list2);

        time2.start();
        sumList2(node1a, node1b);
        time2.endAndPrintElapsedTime();

        System.out.println();
    }

    private static Node createNodeData(List<Integer> numbers) {
        Node node = new Node(numbers.get(0));

        if (numbers.size() > 1) {
            for (int i = 1; i < numbers.size(); i++) {
                node.appendToTail(numbers.get(i));
            }
        }

        return node;
    }

    private static Node sumList(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return null;
        } else if (node1 == null) {
            return node2;
        } else if (node2 == null) {
            return node1;
        }

        Node sum = null;
        Node current = null;
        Node next1 = null;
        Node next2 = null;
        int carry = 0;

        while (node1 != null || node2 != null) {
            if (node1 != null) {
                next1 = node1.next;
                node1.next = null;
            }

            if (node2 != null) {
                next2 = node2.next;
                node2.next = null;
            }

            int result;
            if (node1 != null && node2 != null) {
                result = node1.data + node2.data + carry;
            } else if (node2 == null) {
                result = node1.data + carry;
            } else {
                result = node2.data + carry;
            }

            carry = result / 10;
            Node node = new Node(result % 10);

            if (sum == null) {
                sum = node;  // head node
                current = node;  //  current is node traverser for sum
            } else {
                current.next = node;  //  set the currently pointing next's node = the newly created node
                current = node;  // move pointer "current" to newly created node
            }

            node1 = next1;
            node2 = next2;
        }

        return sum;
    }

    private static Node sumList2(Node node1, Node node2) {
        return sumList2(node1, node2, 0);
    }

    private static Node sumList2(Node node1, Node node2, int carry) {
        if (node1 == null & node2 == null && carry == 0) {
            return null;
        }

        int value = carry;
        if (node1 != null) {
            value += node1.data;
        }

        if (node2 != null) {
            value += node2.data;
        }

        Node result = new Node(value % 10);

        if (node1 != null || node2 != null) {
            result.next = sumList2(
                    node1 == null ? null : node1.next,
                    node2 == null ? null : node2.next,
                    value >= 10 ? 1 : 0);
        }

        return result;
    }
}
