package exercise.array;

import java.util.Arrays;
import java.util.List;

//  Find the largest and smallest number in an unsorted integer array

public class Array3 {
    public static void main(String[] args) {
        List<Integer> listOfNumbers = Arrays.asList(5, 3, 6, 8, 3, 7, 4, 5, 9);
        int largestNumber = listOfNumbers.get(0);
        int smallestNumber = listOfNumbers.get(0);

        for (Integer number : listOfNumbers) {
            if (number > largestNumber) {
                largestNumber = number;
            } else if (number < smallestNumber) {
                smallestNumber = number;
            }
        }

        System.out.println("Largest Number: " + largestNumber);
        System.out.println("Smallest Number: " + smallestNumber);
    }
}
