package exercise.array;

import java.util.List;

// How do you find the missing number in a given integer array of 1 to 100?

public class Array1 {
    public static Integer getMissingNumber(List<Integer> numbers) {

        if (numbers.get(0) != 1) {
            return 1;
        } else if (numbers.get(numbers.size() - 1) != 100) {
            return 100;
        } else {
            for (int i = 0; i < numbers.size() - 1; i++) {
                Integer currentNumber = numbers.get(i);
                Integer nextNumber = numbers.get(i + 1);

                if (currentNumber != nextNumber - 1) {
                    return nextNumber - 1;
                }
            }
        }

        return null;
    }
}
