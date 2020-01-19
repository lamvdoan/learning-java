package exercise.cracking.ch2;

/*
 *  Delete Middle WeightedNode: Implement an algorithm to delete a node in the middle (i.e., any node but the first and last
 *  node, not necessarily the exact middle) of a singly linked list, given only access to that node.
 */

import exercise.z_data.Node;
import exercise.utils.RunTime;

import java.util.Arrays;
import java.util.List;

public class LinkedList3 {
    private static RunTime time1 = new RunTime();
    private static RunTime time2 = new RunTime();
    private static RunTime time3 = new RunTime();

    public static void main(String[] args) {
        System.out.println("Delete Middle WeightedNode");
        System.out.println("*************\n");


        for (int i = 0; i < 10; i++) {
            executeTest(Arrays.asList(1, 2, 3, 4, 5));
            executeTest(Arrays.asList(1, 2, 3, 4, 5, 6));
            executeTest(Arrays.asList(1, 2, 3));
        }

        System.out.println("// Lam's Solution");
        time1.getAverageElapsedTime();
    }

    private static void executeTest(List<Integer> numbers) {
        Node node1 = createNodeData(numbers);

        time1.start();
        deleteMiddleNode(node1);
        time1.endAndPrintElapsedTime();
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

    private static void deleteMiddleNode(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node node = head;
        Node runner = head;
        Node prev = head;

        while (runner.next != null) {
            prev = node;
            node = node.next;
            runner = runner.next;

            if (runner.next != null) {
                runner = runner.next;
            }

            if (runner.next == null) {
                break;  // will always exit while loop here
            }
        }

        prev.next = node.next;  // delete middle node
    }
}
