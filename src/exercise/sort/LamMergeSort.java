package exercise.sort;

/*
 *  Splits the array into halves recursively until it is no longer possible.
 *  Merge the numbers in ascending order by sorting the original array based on next smallest between the 2 temp arrays.
 *
 */

public class LamMergeSort {
    public static void main(String[] args) {
        int[] numbers = {3, 6, 1, 5, 7, 3, 4};
        printNumbers(numbers);
        mergeSort(numbers);
        printNumbers(numbers);
    }

    private static void printNumbers(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();
    }

    private static void mergeSort(int[] numbers) {
        mergeSort(numbers, 0, numbers.length - 1);
    }

    private static void mergeSort(int[] numbers, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(numbers, left, middle);
            mergeSort(numbers, middle + 1, right);
            merge(numbers, left, middle, right);
        }
    }

    /*
     * {3, 6, 1, 5, 7, 3, 4}, length = 7
     * 0,7 | 0,3 & 4,6 | 0,1 & 2,3 | 4,5 & 6
     * m = 1, left = 2, right = 3, 1
     *
     * m = 1, left = 0, right = 1, 1
     *
     * m = 1, left = 0, right = 3, 2
     *
     * m = 5, left = 4, right = 6, 2
     *
     * m = 3, left = 0, right = 7, 7
     */

    private static void merge(int[] numbers, int left, int m, int right) {
        // Store the 2 arrays
        int size = right - left + 1;  // 1 is to make room for Integer.MAX_VALUE
        int[] tempLeft = new int[size];
        int[] tempRight = new int[size];

        int maxLeft = m - left + 1;
        int maxRight = right - m;

        tempLeft[maxLeft] = Integer.MAX_VALUE;  // This is to stop comparing number for this temp array
        tempRight[maxRight] = Integer.MAX_VALUE;

        for (int i = 0; i < maxLeft; i++) {
            tempLeft[i] = numbers[left + i];
        }

        for (int i = 0; i < right - m; i++) {
            tempRight[i] = numbers[m + i + 1];
        }


        // Merge both arrays by order
        int lPointer = 0;
        int rPointer = 0;

        for (int i = left; i <= right; i++) {
            if (tempLeft[lPointer] < tempRight[rPointer]) {
                numbers[i] = tempLeft[lPointer];
                lPointer++;
            } else {
                numbers[i] = tempRight[rPointer];
                rPointer++;
            }
        }
    }
}
