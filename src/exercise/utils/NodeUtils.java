package exercise.utils;

import exercise.z_data.LinkedListNode;
import exercise.z_data.Node;

public class NodeUtils {
    public static Node deleteNode(Node head, int data) {
        Node node = head;

        if (node.data == data) {
            return head.next; // move head
        }

        while (node.next != null) {
            if (node.next.data == data) {
                node.next = node.next.next;
                return head;  // head didn't change
            }

            node = node.next;
        }

        return head;
    }

    public static int getNodeLength(Node head) {
        Node node = head;
        int count = 0;

        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }

    public static void printList(Node head) {
        Node n = head;

        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }

        System.out.println();
    }

    public static void printList(LinkedListNode head) {
        LinkedListNode n = head;

        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }

        System.out.println();
    }
}
