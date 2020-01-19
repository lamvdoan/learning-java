package exercise.cracking.ch3;

public class MinStack1 extends MinStack {
    private class Node {
        private int data;
        private Node next;
        private int min = Integer.MAX_VALUE;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node top = null;

    @Override
    void push(int data) {
        Node node = new Node(data);

        if (top == null || top.min == Integer.MAX_VALUE) {
            node.min = data;
        } else {
            node.min = Math.min(top.min, data);
        }

        node.next = top;
        top = node;
    }

    @Override
    int pop() {
        int data = top.data;
        top = top.next;
        return data;
    }

    @Override
    int min() {
        return top.min;
    }

    @Override
    int peek() {
        return top.data;
    }
}
