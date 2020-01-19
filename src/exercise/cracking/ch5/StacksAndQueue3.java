package exercise.cracking.ch5;

/*
 *
 */

import exercise.utils.RunTime;

public class StacksAndQueue3 {
    private static RunTime time1 = new RunTime();
    private static RunTime time2 = new RunTime();
    private static RunTime time3 = new RunTime();

    public static void main(String[] args) {
        System.out.println("");
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
        renameFunction();
        time1.endAndPrintElapsedTime();

//        time2.start();
//        time2.endAndPrintElapsedTime();
//
//        time3.start();
//        time3.endAndPrintElapsedTime();

        System.out.println();
    }


    private static void renameFunction() {
    }

}
