package exercise.cracking.ch2;

/*
 *  Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 *  Original List : ->1->2->8->3->7->0->4
 *  Output : 3rd Element from the end is : 7
 */

import exercise.z_data.Node;
import exercise.utils.RunTime;

import java.util.Arrays;
import java.util.List;

public class LinkedList2 {
    private static RunTime time1 = new RunTime();
    private static RunTime time2 = new RunTime();

    public static void main(String[] args) {
        System.out.println("Kth to Last");
        System.out.println("*************\n");

        for (int i = 0; i < 10; i++) {
            executeTest(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7), 3);
            executeTest(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7), 1);
            executeTest(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7), 8);
        }

        System.out.println("// Lam's Solution");
        time1.getAverageElapsedTime();

        System.out.println("\n// Book's solution");
        time2.getAverageElapsedTime();
    }

    private static void executeTest(List<Integer> numbers, int kTh) {
        Node node1 = createNodeData(numbers);
        Node node2 = createNodeData(numbers);

        time1.start();
        System.out.println(getKthElement(node1, kTh));
        time1.endAndPrintElapsedTime();

        time2.start();
        getKthElement2(node2, kTh);
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

    private static int getKthElement(Node head, int kThElement) {
        if (head == null) {
            return 0;
        }

        Node node = head;
        int length = getLength(node);

        for (int i = 0; i < length; i++) {
            if (i == length - kThElement) {
                return node.data;
            } else {
                node = node.next;
            }
        }

        return 0;
    }

    private static int getLength(Node head) {
        Node node = head;
        int length = 0;

        while (node != null) {
            length++;

            if (node.next == null) {
                break;
            } else {
                node = node.next;
            }
        }
        return length;
    }

    private static int getKthElement2(Node head, int kThElement) {
        if (head == null) {
            return 0;
        }

        int index = getKthElement2(head.next, kThElement) + 1;

        if (index == kThElement) {
            System.out.println(head.data);
        }

        return index;
    }
}
