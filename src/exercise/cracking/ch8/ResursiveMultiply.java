package exercise.cracking.ch8;

/*
 *  Recursive Multiply: Write a recursive function to multiply two positive integers without using the * operator or /
 *  operator.  You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations.
 */

public class ResursiveMultiply {
    public static void main(String[] args) {
//        System.out.println("56, " + multiply(7, 8));
//
        System.out.println();

        System.out.println("56, " + multiply2(7, 8));
        System.out.println("0, " + multiply2(7, 0));
        System.out.println("7, " + multiply2(7, 1));
        System.out.println("0, " + multiply2(0, 7));
        System.out.println("7, " + multiply2(1, 7));
        System.out.println("30, " + multiply2(6, 5));
        System.out.println("50, " + multiply2(5, 10));
        System.out.println("100, " + multiply2(5, 20));

        System.out.println();

//        System.out.println("0, " + multiply3(5, 0));
//        System.out.println("5, " + multiply3(5, 1));
//        System.out.println("0, " + multiply3(0, 5));
//        System.out.println("5, " + multiply3(1, 5));
//        System.out.println("15, " + multiply3(3, 5));
//        System.out.println("30, " + multiply3(6, 5));
//        System.out.println("50, " + multiply3(5, 10));
//        System.out.println("100, " + multiply3(5, 20));
    }

    private static int multiply(int num1, int num2) {
        int sum = 0;

        for (int n = 0; n < num2; n++) {
            sum += num1;
        }

        return sum;
    }

    private static int multiply2(int num1, int num2) {
        return multiply2(num1, num2, 0);
    }

    private static int multiply2(int num1, int num2, int sum) {
        if (num2 > 0) {
            sum += multiply2(num1, num2 - 1, sum) + num1;
        }

        return sum;
    }

    private static int multiply3(int num1, int num2) {
        return multiply3(num1, num2, num1, 1, 0);
    }

    private static int multiply3(int num1, int num2, int mul, int count, int sum) {
        if (num2 > 0) {
            if (count + count <= num2) {
                sum += multiply3(num1, num2 - count - count, mul + mul, count + count, sum) + mul + mul;
            } else if (count <= num2) {
                sum += multiply3(num1, num2 - count, mul, count, sum) + mul;
            } else {
                sum += multiply3(num1, num2 - 1, mul, 1, sum) + num1;
            }
        }

        return sum;
    }
}
