package exercise.array;

import java.util.*;

// Find the duplicate numbers in an array

public class Array2 {
    public static void main(String[] args) {
        List<Integer> listOfNumbers = Arrays.asList(5, 3, 6, 8, 3, 7, 4, 5, 9);
        int[] numbers = new int[]{5, 3, 6, 8, 3, 7, 4, 5, 9};

        Set<Integer> duplicateNumbers = new HashSet<>();
        Set<Integer> setOfNumbers = new HashSet<>();

//        for (Integer number : listOfNumbers) {
//            if (setOfNumbers.contains(number)) {
//                duplicateNumbers.add(number);
//            } else {
//                setOfNumbers.add(number);
//            }
//        }

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];

            if (setOfNumbers.contains(number)) {
                duplicateNumbers.add(number);
            } else {
                setOfNumbers.add(number);
            }
        }

        for (Integer dupe : duplicateNumbers) {
            System.out.println("Duplicate: " + dupe);
        }
    }
}
