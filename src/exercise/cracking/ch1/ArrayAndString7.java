package exercise.cracking.ch1;

/*
 *  Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a
 *  method to rotate the image by 90 degrees. Can you do this in place?
 */

import exercise.utils.RunTime;

public class ArrayAndString7 {
    private static RunTime time1 = new RunTime();
    private static RunTime time2 = new RunTime();

    private static final int MAX_SIZE = 4;

    public static void main(String[] args) {
        System.out.println("Rotate Matrix");
        System.out.println("*************\n");

        int[][] matrix1 = new int[MAX_SIZE][MAX_SIZE];

        for (int i = 0; i < 10; i++) {
            executeTest(matrix1);
            System.out.println();
        }

        System.out.println("// Lam's Solution with another array");
        time1.getAverageElapsedTime();

        System.out.println("\n// Book's Solution");
        time2.getAverageElapsedTime();
    }

    private static void executeTest(int[][] matrix) {
        fillArray(matrix);
        time1.start();
        rotateMatrix1(matrix);
        time1.endAndPrintElapsedTime();

        fillArray(matrix);
        time2.start();
        rotateMatrix2(matrix);
        time2.endAndPrintElapsedTime();
    }

    private static void fillArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = i + 1;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }

    private static boolean rotateMatrix1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length != matrix.length) {
            return false;
        }

        int[][] rotatedMatrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                rotatedMatrix[i][j] = matrix[matrix.length - 1 - j][i];
            }
        }

        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = rotatedMatrix[row][col];
            }
        }

        return true;
    }

    private static boolean rotateMatrix2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length != matrix.length) {
            return false;
        }

        // iterating from outer layer square to inner layer square
        for (int layer = 0; layer < matrix.length / 2; layer++) {
            int last = matrix.length - 1 - layer;  // index of last layer

            for (int i = layer; i < last; i++) {
                int offset = i - layer;  // iterating backwards from last

                int top = matrix[layer][i];
                matrix[layer][i] = matrix[last - offset][layer];  // top = left
                matrix[last - offset][layer] = matrix[last][last - offset];  // left = bottom
                matrix[last][last - offset] = matrix[i][last];  // bottom = right
                matrix[i][last] = top;  // right = top
            }
        }

        return true;
    }
}
