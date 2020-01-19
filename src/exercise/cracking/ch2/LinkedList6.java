package exercise.cracking.ch2;

/*
 *  Palindrome: Implement a function to check if a linked list is a palindrome.
 *
 *  Hints: 5, 13, 29 ,51, 101
 */

import exercise.z_data.MyStack;
import exercise.z_data.Node;
import exercise.utils.NodeUtils;
import exercise.utils.RunTime;

import java.util.Arrays;
import java.util.List;

public class LinkedList6 {
    private static RunTime time1 = new RunTime();
    private static RunTime time2 = new RunTime();
    private static RunTime time3 = new RunTime();

    public static void main(String[] args) {
        System.out.println("");
        System.out.println("*************\n");


        for (int i = 0; i < 10; i++) {
            executeTest(Arrays.asList(1, 2, 3, 2, 1));
            executeTest(Arrays.asList(1, 2, 3, 3, 2, 1));
            executeTest(Arrays.asList(1, 2, 3, 4, 2, 1));
            executeTest(Arrays.asList(1, 2, 3, 3, 1));
        }

        System.out.println("// Lam's Solution using hints");
        time1.getAverageElapsedTime();

        System.out.println("\n// Book's solution using reverse and isEqual methods");
        time2.getAverageElapsedTime();

        System.out.println("\n// Book's solution using stack");
        time3.getAverageElapsedTime();
    }

    private static void executeTest(List<Integer> numbers) {
        Node node1 = createNodeData(numbers);
        Node node2 = createNodeData(numbers);
        Node node3 = createNodeData(numbers);
        NodeUtils.printList(node1);

        time1.start();
        System.out.println(isPalindrome(node1));
        time1.endAndPrintElapsedTime();

        time2.start();
        System.out.println(isPalindrome2(node2));
        time2.endAndPrintElapsedTime();

        time3.start();
        isPalindrome3(node3);
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


    private static boolean isPalindrome2(Node head) {
        Node reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    private static Node reverseAndClone(Node node) {
        Node head = null;

        while (node != null) {
            Node clone = new Node(node.data);
            clone.next = head;
            head = clone;
            node = node.next;
        }

        return head;
    }

    private static boolean isEqual(Node one, Node two) {
        while (one != null && two != null) {
            if (one.data != two.data) {
                return false;
            }

            one = one.next;
            two = two.next;
        }

        return one == null && two == null;
    }

    private static boolean isPalindrome(Node head) {
        if (head == null) {
            return false;
        } else if (head.next == null) {
            return true;
        }

        Node node = head;
        MyStack<Integer> stack = new MyStack<>();

        int nodeLength = NodeUtils.getNodeLength(head);
        int halfway = (nodeLength + 1) / 2;

        // Get first half of numbers into stack
        int loop = 0;
        while (loop != halfway) {
            stack.push(node.data);
            node = node.next;
            loop++;
        }


        // No need to compare middle number if the list contains odd number of elements
        if (nodeLength % 2 != 0) {
            stack.pop();
        }


        // Compare the 2nd half of numbers against the 1st half of the numbers
        while (node != null) {
            if (node.data != stack.pop()) {
                return false;
            }

            node = node.next;
        }

        return true;
    }

    private static boolean isPalindrome3(Node head) {
        Node fast = head;
        Node slow = head;

        MyStack<Integer> stack = new MyStack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.pop() != slow.data) {
                return false;
            }

            slow = slow.next;
        }

        return true;
    }
}
