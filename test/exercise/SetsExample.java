package exercise;

import java.util.Arrays;
import java.util.List;

public class SetsExample {

    public static void main(String[] argv) {
        List<Integer> numbers = Arrays.asList(0, 10, 0, 4, 1, 3, 4, 11);
        List<Integer> sortedNumbers = sortArray(numbers);

        System.out.println(numbers);
        System.out.println(sortedNumbers);
    }

    private static List<Integer> sortArray(List<Integer> sortedList) {
        int maxIndex = sortedList.size() - 1;

        for (int i = 1; i <= maxIndex; i++) {
            int previousIndex = i - 1;
            int currentIndex = i;

            while(previousIndex >= 0) {
                Integer currentNumber = sortedList.get(currentIndex);
                Integer previousNumber =  sortedList.get(previousIndex);

                if (previousNumber >= currentNumber) {
                    sortedList.set(previousIndex, currentNumber);
                    sortedList.set(currentIndex, previousNumber);
                    currentIndex--;
                    previousIndex--;
                }  else {
                    break;
                }
            }
        }

        return sortedList;
    }

}
