package exercise.cracking.ch2;

/*
 *  UNFINISHED
 *
 *  Loop Detection: Given a linked list which might contain a loop, implement an algorithm that returns the node at the
 *  beginning of the loop (if one exists).
 *
 *  EXAMPLE
 *  Input:  A -> B -> C -> D -> E -> C [the same C as earlier]
 *  Output: C
 *
 *  Hints: 50, 69, 83, 90
 */

import exercise.z_data.LinkedListNode;
import exercise.z_data.Node;
import exercise.utils.NodeUtils;
import exercise.utils.RunTime;

import java.util.Arrays;
import java.util.List;

public class LinkedList8 {
    private static RunTime time1 = new RunTime();
    private static RunTime time2 = new RunTime();
    private static RunTime time3 = new RunTime();

    public static void main(String[] args) {
        System.out.println("");
        System.out.println("*************\n");


        for (int i = 0; i < 1; i++) {
            executeTest(Arrays.asList(1, 2, 3, 4, 5));
//            executeTest(Arrays.asList(1, 2, 3, 4, 5));
        }

//        System.out.println("// Lam's Solution");
//        time1.getAverageElapsedTime();
//
//        System.out.println("\n// Lam's solution using LinkedListNode");
//        time2.getAverageElapsedTime();
//
//        System.out.println("\n// Book's solution");
//        time3.getAverageElapsedTime();
    }

    private static void executeTest(List<Integer> numbers) {
        LinkedListNode node1 = createLinkedListNodeData(numbers);
//        LinkedListNode node2 = createLinkedListNodeData(numbers);
//        LinkedListNode node3 = createLinkedListNodeData(numbers);
//        WeightedNode node1 = createNodeData(numbers);
//        WeightedNode node2 = createNodeData(numbers);
//        WeightedNode node3 = createNodeData(numbers);
        NodeUtils.printList(node1);

        time1.start();
        renameFunction(node1);
        time1.endAndPrintElapsedTime();

//        time2.start();
//        removeDupes2(node2);
//        time2.endAndPrintElapsedTime();
//
//        time3.start();
//        removeDupes3(node3);
//        time3.endAndPrintElapsedTime();

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

    private static LinkedListNode createLinkedListNodeData(List<Integer> numbers) {
        LinkedListNode node = new LinkedListNode(numbers.get(0));
        LinkedListNode current = node;

        if (numbers.size() > 1) {
            for (int i = 1; i < numbers.size(); i++) {
                current.setNext(new LinkedListNode(numbers.get(i)));
                current = current.next;
            }
        }

        return node;
    }

    private static void renameFunction(LinkedListNode head) {
        LinkedListNode node = head;
    }

    private static void renameFunction(Node head) {
        Node node = head;
    }
}
