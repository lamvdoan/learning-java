package exercise.cracking.ch2;

/*
 *  Partition: Write code to partition a linked list around a val x, such that all nodes less than x come before all
 *  nodes greater than or equal to x.  (IMPORTANT: The partition element x can appear anywhere in the "right partition";
 *  it does not need to appear between the left and right partitions.  The additional spacing the example below
 *  indicates the partition.)
  *
  * Example:
  * Input:  3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
  * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
  *
 */

import exercise.z_data.Node;
import exercise.utils.NodeUtils;
import exercise.utils.RunTime;

import java.util.Arrays;
import java.util.List;

public class LinkedList4 {
    private static RunTime time1 = new RunTime();
    private static RunTime time2 = new RunTime();
    private static RunTime time3 = new RunTime();

    public static void main(String[] args) {
        System.out.println("");
        System.out.println("*************\n");


        for (int i = 0; i < 10; i++) {
            executeTest(Arrays.asList(3, 5, 8, 5, 10, 2, 1), 5);
            executeTest(Arrays.asList(5, 8, 5, 10), 5);
            executeTest(Arrays.asList(3, 2, 1), 5);
        }

        System.out.println("// Lam's Solution with book design hint");
        time1.getAverageElapsedTime();

        System.out.println("\n// Lam's solution using LinkedListNode");
        time2.getAverageElapsedTime();

        System.out.println("\n// Book's solution");
        time3.getAverageElapsedTime();
    }

    private static void executeTest(List<Integer> numbers, int partition) {
        Node node1 = createNodeData(numbers);
        Node node2 = createNodeData(numbers);
        Node node3 = createNodeData(numbers);
        NodeUtils.printList(node1);

        time1.start();
        Node partitionedNode = partition(node1, partition);
        time1.endAndPrintElapsedTime();

        time2.start();
        Node partitionedNode2 = partition2(node2, partition);
        time2.endAndPrintElapsedTime();

        time3.start();
        Node partitionedNode3 = partition3(node3, partition);
        time3.endAndPrintElapsedTime();

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

    private static Node partition(Node node, int partition) {
        if (node == null) {
            return null;
        }

        Node lowHead = null;
        Node highHead = null;
        Node low = null;
        Node high = null;

        while (node != null) {
            if (node.data < partition) {
                if (lowHead == null) {
                    lowHead = new Node(node.data);
                    low = lowHead;
                } else {
                    low.next = new Node(node.data);
                    low = low.next;
                }
            } else {
                if (highHead == null) {
                    highHead = new Node(node.data);
                    high = highHead;
                } else {
                    high.next = new Node(node.data);
                    high = high.next;
                }
            }

            node = node.next;
        }


        if (lowHead != null) {
            low.next = highHead;
            return lowHead;
        } else {
            return highHead;
        }
    }

    private static Node partition2(Node node, int partition) {
        if (node == null) {
            return null;
        }

        Node lowHead = null;
        Node highHead = null;
        Node low = null;
        Node high = null;

        while (node != null) {
            Node next = node.next;
            node.next = null;

            if (node.data < partition) {
                if (lowHead == null) {
                    lowHead = node;
                    low = lowHead;
                } else {
                    low.next = node;
                    low = node;
                }
            } else {
                if (highHead == null) {
                    highHead = node;
                    high = highHead;
                } else {
                    high.next = node;  // setting val for next
                    high = node;  // setting current pointer for traversing
                }
            }

            node = next;
        }


        if (lowHead != null) {
            low.next = highHead;
            return lowHead;
        } else {
            return highHead;
        }
    }

    private static Node partition3(Node node, int partition) {
        Node head = node;
        Node tail = node;

        while (node != null) {
            Node next = node.next;

            if (node.data < partition) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }

            node = next;
        }

        tail.next = null;

        return head;
    }
}
