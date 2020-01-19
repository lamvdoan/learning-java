package exercise.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  Given a sum, find the pairs that sum up to an existing number in an array

public class Array4 {
    public static void main(String[] args) {
        List<Integer> listOfNumbers = Arrays.asList(2, 6, 3, 9, 11);
        solutionOne(listOfNumbers, 11);
        System.out.println();

        solutionTwo(listOfNumbers, 11);
    }

    private static void solutionOne(List<Integer> listOfNumbers, int sum) {
        for (int i = 0; (i + 1) < listOfNumbers.size(); i++) {
            for (int j = (i + 1); j < listOfNumbers.size(); j++) {
                int sumOfPair = listOfNumbers.get(i) + listOfNumbers.get(j);

                if (sumOfPair == sum) {
                    System.out.println("Pair: " + listOfNumbers.get(i) + ", " + listOfNumbers.get(j));
                }
            }
        }
    }

    private static void solutionTwo(List<Integer> listOfNumbers, int sum) {
        Map<Integer, Boolean> usedNumbers = new HashMap<>();

        for (Integer number : listOfNumbers) {
            usedNumbers.put(number, true);
        }

        for (Integer firstNumber : listOfNumbers) {
            int secondNumber = sum - firstNumber;

            if (usedNumbers.containsKey(secondNumber) && usedNumbers.get(secondNumber)) {
                usedNumbers.put(firstNumber, false);
                usedNumbers.put(secondNumber, false);
                System.out.println("Pair: " + firstNumber + ", " + secondNumber);
            }
        }
    }
}
