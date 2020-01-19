package exercise.sort;

/*
 *  Find a pivot and have smaller numbers on the left and larger numbers on the right
 *
 *  Chooses a number for the partition.  Have i = -1, j = 0
 *  If array[j] > partition, do nothing.  Else, increment i and then swap array[i] and array[j]
 *  Return the last number which becomes the new pivot.
 *
 */

public class LamQuickSort {
    public static void main(String[] args) {
        int[] numbers = {3, 6, 1, 5, 7, 3, 4};
        printNumbers(numbers);
        quickSort(numbers);
        printNumbers(numbers);
    }

    private static void quickSort(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
    }

    private static void quickSort(int[] numbers, int left, int right) {
        if (left < right) {
            int partition = partition(numbers, left, right);
            quickSort(numbers, left, partition - 1);
            quickSort(numbers, partition + 1, right);
        }
    }

    private static int partition(int[] numbers, int left, int right) {
        int i = left - 1; // needs to be in the -1 spot

        for (int j = left; j <= right; j++) {
            if (numbers[j] <= numbers[right]) {
                i++;

                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }

        return i;
    }

    private static void printNumbers(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();
    }
}
