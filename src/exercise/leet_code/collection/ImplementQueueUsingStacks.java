package exercise.leet_code.collection;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println("1, " + queue.peek());  // returns 1
        System.out.println("1, " + queue.pop());   // returns 1
        System.out.println("false, " + queue.empty()); // returns false
        System.out.println();

        queue = new MyQueue();
        queue.push(1);
        System.out.println("1, " + queue.pop());
        queue.push(2);
        System.out.println("2, " + queue.pop());
        System.out.println("true, " + queue.empty());
        System.out.println();

        queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println("1, " + queue.pop());
        queue.push(3);
        System.out.println("2, " + queue.pop());
        System.out.println("3, " + queue.pop());
        System.out.println("true, " + queue.empty());
        System.out.println();

        queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println("1, " + queue.pop());
        System.out.println("2, " + queue.pop());
        System.out.println("3, " + queue.pop());
        System.out.println("true, " + queue.empty());
        System.out.println();
    }

    static class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        int bottom;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if (stack1.size() == 0) {
                bottom = x;
            }

            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            int oldTop = bottom;

            while (stack1.size() > 2) {
                stack2.push(stack1.pop());
            }

            if (stack1.size() == 2) {
                bottom = stack1.peek();
                stack2.push(stack1.pop());
            }

            stack1.pop();

            while (stack2.size() > 0) {
                stack1.push(stack2.pop());
            }

            return oldTop;
        }

        /** Get the front element. */
        public int peek() {
            return bottom;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.size() == 0;
        }
    }
}
