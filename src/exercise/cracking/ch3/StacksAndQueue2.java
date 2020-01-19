package exercise.cracking.ch3;

/*
 *  Stack Min: How would you design a stack which, in addition to push and pop, has a function min which returns the
 *  minimum element? Push, pop and min should all operate in O(1) time.
 *
 *  Hints: #27, #59, #78
 */

import exercise.utils.RunTime;

public class StacksAndQueue2 {
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
        stackMin(createData1(new MinStack1()));
        time1.endAndPrintElapsedTime();

//        time2.start();
//        stackMin2(new MinStack2());
//        time2.endAndPrintElapsedTime();
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

    private static MinStack createData1(MinStack stack) {
        stack.push(5);
        stack.push(1);
        System.out.println(stack.min()); // 1
        stack.pop();
        stack.push(8);
        stack.push(2);
        System.out.println(stack.min()); // 2
        stack.pop();
        System.out.println(stack.min()); // 5

        return stack;
    }

    private static int stackMin(MinStack stack) {
        return stack.min();
    }

    private static int stackMin2(MinStack stack) {
        return stack.min();
    }
}
