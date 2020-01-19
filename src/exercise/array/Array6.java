package exercise.array;

import java.util.*;

// Remove duplicate numbers in an array

public class Array6 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 3, 6, 8, 3, 7, 4, 5, 9));
        Set<Integer> setOfNumbers = new HashSet<>();

        numbers.forEach(number -> System.out.print(number + ", "));
        System.out.println();

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);

            if (setOfNumbers.contains(number)) {
                numbers.remove(i);
            } else {
                setOfNumbers.add(number);
            }
        }

        numbers.forEach(number -> System.out.print(number + ", "));
    }
}
