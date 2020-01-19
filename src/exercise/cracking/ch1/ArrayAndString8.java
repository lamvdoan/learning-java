package exercise.cracking.ch1;

/*
 *  Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row & column are set to 0.
 */

import exercise.utils.RunTime;

public class ArrayAndString8 {
    private static RunTime time1 = new RunTime();
    private static RunTime time2 = new RunTime();
    private static RunTime timeInitial = new RunTime();

    public static void main(String[] args) {
        System.out.println("Zero matrix");
        System.out.println("*************\n");

        int[][] matrix1 = {
                {4, 4, 4, 4},
                {4, 4, 0, 4},
                {4, 4, 4, 4},
                {4, 4, 4, 4},
        };

        int[][] matrix2 = {
                {4, 0, 4, 4},
                {4, 4, 4, 4},
                {4, 4, 4, 4},
                {4, 4, 4, 4},
        };

        for (int i = 0; i < 10; i++) {
            executeTest(matrix1);
            executeTest(matrix2);
        }

        System.out.println("// Lam's Solution with some book advice");
        timeInitial.getAverageElapsedTime();

        System.out.println("\n// Lam's Solution with some book advice");
        time1.getAverageElapsedTime();

        System.out.println("\n// Books's solution");
        time2.getAverageElapsedTime();
    }

    private static void executeTest(int[][] matrix) {
        int[][] matrix1 = copyArray(matrix);
        int[][] matrix2 = copyArray(matrix);
        printMatrix(matrix);

        timeInitial.start();
        zeroMatrix(matrix);
        timeInitial.endAndPrintElapsedTime();

        time1.start();
        System.out.println(zeroMatrix(matrix1));
        time1.endAndPrintElapsedTime();

        time2.start();
        System.out.println(zeroMatrix2(matrix2));
        time2.endAndPrintElapsedTime();

        System.out.println();
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

    private static int[][] copyArray(int[][] matrix) {
        int[][] newArray = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, newArray[i], 0, matrix.length);
        }

        return newArray;
    }

    private static boolean zeroMatrix(int[][] matrix) {
        boolean[] zeroRows = new boolean[matrix.length];
        boolean[] zeroColumns = new boolean[matrix.length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 0) {
                    zeroRows[row] = true;
                    zeroColumns[col] = true;
                }
            }
        }

        fillZeroes(matrix, zeroRows, zeroColumns);

        return true;
    }

    private static void fillZeroes(int[][] matrix, boolean[] zeroRows, boolean[] zeroColumns) {
        for (int i = 0; i < matrix.length; i++) {
            if (zeroRows[i]) {
                nullifyRow(i, matrix);
            }

            if (zeroColumns[i]) {
                nullifyColumn(i, matrix);
            }
        }
    }


    private static boolean zeroMatrix2(int[][] matrix) {
        boolean firstRowHasZero = checkForZeroInFirstRow(matrix);
        boolean firstColHasZero = checkForZeroInFirstColumn(matrix);

        // Fill zero to corresponding initial row/column if any zeroes found
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix.length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        // Nullify non-initial row/columns based on zeroes in the initial rows/columns
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                nullifyRow(i, matrix);
            }

            if (matrix[0][i] == 0) {
                nullifyColumn(i, matrix);
            }
        }

        // Nullify corresponding initial row/columns if any initial row/columns has a zero
        if (firstRowHasZero) {
            nullifyRow(0, matrix);
        }

        if (firstColHasZero) {
            nullifyColumn(0, matrix);
        }

        return true;
    }

    private static boolean checkForZeroInFirstRow(int[][] matrix) {
        for (int col = 0; col < matrix.length; col++) {
            if (matrix[0][col] == 0) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkForZeroInFirstColumn(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                return true;
            }
        }

        return false;
    }

    private static void nullifyRow(int row, int[][] matrix) {
        for (int col = 0; col < matrix.length; col++) {
            matrix[row][col] = 0;
        }
    }

    private static void nullifyColumn(int col, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col] = 0;
        }
    }
}
