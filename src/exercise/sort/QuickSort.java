package exercise.sort;


public class QuickSort {
    public static void main(String[] args) {
        int[] numbers = {3, 6, 1, 5, 7, 3, 4};
        printNumbers(numbers);
        sort(numbers);
        printNumbers(numbers);
    }

    private static void sort(int[] numbers) {
        sort(numbers, 0, numbers.length - 1);
    }

    private static void sort(int[] numbers, int left, int right) {
        // Partition the numbers and then find the last sorted index
        int index = partition(numbers, left, right);

        // partition left of index
        if (left < index - 1) {
            sort(numbers, left, index - 1);
        }

        // partition right of index
        if (index < right) {
            sort(numbers, index, right);
        }
    }

    private static int partition(int[] numbers, int i, int j) {
        int pivotIndex = (i + j) / 2;
        int pivot = numbers[pivotIndex];

        while (i <= j) {

            // Find first index of number where left number doesn't belong on left
            while (numbers[i] < pivot) {
                i = incrementI(i);
            }

            // Find first index of number where right number doesn't belong on right
            while (numbers[j] > pivot) {
                j = decrementJ(j);
            }

            // Low and High values are already found, going to swap them, and set cursor for next comparison
            if (i <= j) {
                swap(numbers, i, j);
                i = incrementI(i);
                j = decrementJ(j);
            }
        }

        return i;
    }

    private static void swap(int[] numbers, int left, int right) {
        int temp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temp;
        printNumbers(numbers);
    }

    private static int incrementI(int i) {
        i++;
        System.out.println("i: " + i);
        return i;
    }

    private static int decrementJ(int j) {
        j--;
        System.out.println("j: " + j);
        return j;
    }

    private static void printNumbers(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();
    }
}
