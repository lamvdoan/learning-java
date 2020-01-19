package exercise.leet_code.collection;

import java.util.LinkedList;
import java.util.Queue;

/*
 *  Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Stack using Queues.
 *  Memory Usage: 34.1 MB, less than 91.67% of Java online submissions for Implement Stack using Queues.
 */

public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());   // returns 2
        System.out.println(stack.pop());   // returns 2
        System.out.println(stack.empty()); // returns false
        System.out.println(stack.top());   // returns 1
        stack.push(5);
        stack.push(6);
        System.out.println(stack.top);   // returns 6
        System.out.println();

        stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());   // returns 2
        stack.push(3);
        System.out.println(stack.pop());   // returns 3
        System.out.println(stack.top()); // returns false
        System.out.println();

        stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());   // returns 2
        System.out.println(stack.pop());   // returns 1
        System.out.println(stack.empty()); // returns true
    }

    static class MyStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;
        Queue<Integer> activeQueue;
        Queue<Integer> inactiveQueue;
        int top;

        MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
            activeQueue = queue1;
            inactiveQueue = queue2;
        }

        public void push(int x) {
            activeQueue.add(empty() ? x : top);
            top = x;
        }

        public int pop() {
            if (!empty()) {
                int oldTop = top;

                while (activeQueue.size() != 1) {
                    inactiveQueue.add(activeQueue.remove());
                }

                top = activeQueue.remove();

                activeQueue = activeQueue == queue1 ? queue2 : queue1;
                inactiveQueue = activeQueue == queue1 ? queue2 : queue1;

                return oldTop;
            }

            return -1;
        }

        int top() {
            if (!empty()) {
                return top;
            }

            return -1;
        }

        boolean empty() {
            return activeQueue.size() == 0;
        }
    }
}
