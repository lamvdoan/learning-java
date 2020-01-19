package exercise.sort;

public class BubbleSort {
    public static void main(String[] args) {
//        int[] numbers = {3, 6, 1, 9, 7, 3, 4};
        int[] numbers = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        printNumbers(numbers);

        int[] sortedNumbers = bubbleSort(numbers);
        printNumbers(sortedNumbers);
    }

    private static int[] bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        return numbers;
    }

    private static void printNumbers(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();
    }
}
