package exercise.cracking.ch3;

/*
 *  Three in One: Describe how you could use a single array to implement three stacks.
 *
 *  Hints: 2, 12, 38, 58
 */

import exercise.utils.RunTime;

public class StacksAndQueue1 {
    private static RunTime time1 = new RunTime();
    private static RunTime time2 = new RunTime();
    private static RunTime time3 = new RunTime();

    public static void main(String[] args) {
        System.out.println("Three in One");
        System.out.println("*************\n");


        for (int i = 0; i < 1; i++) {
            executeTest();
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

    private static void executeTest() {

        time1.start();
        threeStacks();
        time1.endAndPrintElapsedTime();

        time2.start();
        threeStacks2();
        time2.endAndPrintElapsedTime();
//
//        time3.start();
//        time3.endAndPrintElapsedTime();

        System.out.println();
    }

    private static void printArrayStack(ArrayStack stack) {
        for (int i = 0; i < stack.getTotalSize(); i++) {
            System.out.print(stack.numbers[i] + " ");
        }

        System.out.println();
    }

    private static void threeStacks() {
        ArrayStack1 stack = new ArrayStack1();

        stack.push(1, 7);
        stack.push(2, 3);
        stack.push(1, 2);
        stack.push(3, 9);
        System.out.println("Popped: " + stack.pop(1));
        stack.push(3, 5);
        stack.push(1, 1);
        printArrayStack(stack);
    }

    private static void threeStacks2() {
        ArrayStack2 stack = new ArrayStack2();

        stack.push(1, 7);
        stack.push(2, 3);
        stack.push(1, 2);
        stack.push(3, 9);
        System.out.println("Popped: " + stack.pop(1));
        stack.push(3, 5);
        stack.push(1, 1);
        printArrayStack(stack);
    }
}
