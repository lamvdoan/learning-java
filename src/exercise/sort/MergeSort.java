package exercise.sort;


public class MergeSort {
    public static void main(String[] args) {
        int[] numbers = {3, 6, 1, 5, 7, 3, 4};
        printNumbers(numbers);
        mergeSort(numbers);
//        printNumbers(numbers);
    }

    private static void printNumbers(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();
    }

    private static void mergeSort(int[] numbers) {
        mergeSort(numbers, new int[numbers.length], 0, numbers.length - 1);
    }

    private static void mergeSort(int[] numbers, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (high + low) / 2;
            mergeSort(numbers, helper, low, middle);  // sort left half
            mergeSort(numbers, helper, middle + 1, high);  // sort right half
            merge(numbers, helper, low, middle, high);  // merge them
        }
    }

    private static void merge(int[] numbers, int[] helper, int low, int middle, int high) {
        System.out.println(String.format("low: %s, mid:  %s, high: %s", low, middle, high));
        // Copy both halves into a helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int helperLeft = low;  // setting initial point of left array
        int helperRight = middle + 1;  // setting initial point of right array

        // Iterate through the helper array.
        // Compare the left and right half, copying back the smaller element from the two halves into the original array
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                numbers[low] = helper[helperLeft];
                System.out.print(">: ");
                printNumbers(numbers);
                helperLeft++;
            } else {  // If right element is smaller than the left element
                numbers[low] = helper[helperRight];
                System.out.print("<: ");
                printNumbers(numbers);
                helperRight++;
            }

            low++;
        }

        // Copy the rest of the left side of the array into the original array
        int remaining = middle - helperLeft;

        for (int i = 0; i <= remaining; i++) {
            numbers[low + i] = helper[helperLeft + i];
            System.out.print("R: ");
            printNumbers(numbers);
        }
    }

}
