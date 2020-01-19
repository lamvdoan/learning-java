package exercise.cracking.ch2;

/*
 *  Remove Dupes: Write code to remove duplicates from an unsorted linked list.
 */

import exercise.z_data.LinkedListNode;
import exercise.z_data.Node;
import exercise.utils.RunTime;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedList1 {
    private static RunTime time1 = new RunTime();
    private static RunTime time2 = new RunTime();
    private static RunTime time3 = new RunTime();
    private static RunTime time4 = new RunTime();

    public static void main(String[] args) {
        System.out.println("Remove Dupes");
        System.out.println("*************\n");


        for (int i = 0; i < 10; i++) {
            executeTest(Arrays.asList(1, 2, 3, 4, 5));
            executeTest(Arrays.asList(5, 7, 3, 7, 2));
            executeTest(Arrays.asList(3, 1, 2, 4, 3));
        }

        System.out.println("// Lam's Solution");
        time1.getAverageElapsedTime();

        System.out.println("\n// Lam's solution using LinkedListNode");
        time2.getAverageElapsedTime();

        System.out.println("\n// Lam's solution with no buffer");
        time3.getAverageElapsedTime();

        System.out.println("\n// Book's solution");
        time4.getAverageElapsedTime();
    }

    private static void executeTest(List<Integer> numbers) {
        Node node = createLinkedListSet();
        LinkedListNode node2 = createLinkedListSet2(numbers);
        LinkedListNode node3 = createLinkedListSet2(numbers);
        LinkedListNode node4 = createLinkedListSet2(numbers);

        time1.start();
        removeDupes(node);
        time1.endAndPrintElapsedTime();
//        NodeUtils.printList(node);

        time2.start();
        removeDupes2(node2);
        time2.endAndPrintElapsedTime();
//        NodeUtils.printList(node2);

        time3.start();
        removeDupes3(node3);
        time3.endAndPrintElapsedTime();
//        NodeUtils.printList(node3);

        time4.start();
        removeDupes4(node4);
        time4.endAndPrintElapsedTime();
//        NodeUtils.printList(node4);

        System.out.println();
    }

    private static Node createLinkedListSet() {
        Node node = new Node(5);
        node.appendToTail(7);
        node.appendToTail(3);
        node.appendToTail(7);
        node.appendToTail(2);
        return node;
    }

    private static LinkedListNode createLinkedListSet2(List<Integer> numbers) {
        LinkedListNode node1 = new LinkedListNode(numbers.get(0));
        LinkedListNode node2 = new LinkedListNode(numbers.get(1));
        LinkedListNode node3 = new LinkedListNode(numbers.get(2));
        LinkedListNode node4 = new LinkedListNode(numbers.get(3));
        LinkedListNode node5 = new LinkedListNode(numbers.get(4));

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        return node1;
    }

    private static void removeDupes(Node head) {
        Node node = head;
        int[] numbers = new int[getNodeLength(node) - 1];
        int index = 0;

        Node prev = null;

        while (node != null) {
            if (isThereDuplicate(numbers, node.data)) {
                if (prev != null) {
                    prev.next = node.next;
                }
            } else {
                numbers[index] = node.data;
                index++;
            }

            prev = node;
            node = node.next;
        }
    }

    private static int getNodeLength(Node head) {
        Node node = head;
        int count = 0;

        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }

    private static boolean isThereDuplicate(int[] numbers, int target) {
        for (int number : numbers) {
            if (target == number) {
                return true;
            }
        }

        return false;
    }

    private static void removeDupes2(LinkedListNode head) {
        Set<Integer> numbers = new HashSet<>();
        LinkedListNode node = head;

        while (node != null) {

            if (numbers.contains(node.data)) {
                node.prev.next = node.next;

                if (node.next != null) {
                    node.next.prev = node.prev;
                }
            } else {
                numbers.add(node.data);
            }

            node = node.next;
        }
    }

    private static void removeDupes3(LinkedListNode head) {
        LinkedListNode node = head;

        while (node != null) {
            LinkedListNode duplicateNode = findDuplicateInNode(node.next, node.data);

            if (duplicateNode != null) {
                if (duplicateNode.next != null) {
                    duplicateNode.next.prev = duplicateNode.prev;
                }

                duplicateNode.prev.next = duplicateNode.next;
            }

            node = node.next;
        }
    }

    private static LinkedListNode findDuplicateInNode(LinkedListNode current, int target) {
        LinkedListNode node = current;

        while (node != null) {
            if (node.data == target) {
                return node;
            }

            node = node.next;
        }

        return null;
    }

    private static void removeDupes4(LinkedListNode head) {
        LinkedListNode current = head;

        while (current != null) {
            LinkedListNode runner = current;

            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;  // delete next node
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }
}
