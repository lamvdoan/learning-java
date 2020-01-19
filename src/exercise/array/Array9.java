package exercise.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Find the duplicate numbers in an array

public class Array9 {
    public static void main(String[] args) {
        List<Integer> listOfNumbers = Arrays.asList(5, 3, 6, 8, 3);
        List<Integer> reversedArray = new ArrayList<>();

        for (int i = listOfNumbers.size() - 1; i >= 0; i--) {
            reversedArray.add(listOfNumbers.get(i));
        }

        listOfNumbers.forEach(number -> System.out.print(number + ", "));
        System.out.println();
        reversedArray.forEach(number -> System.out.print(number + ", "));
    }
}
