package exercise;

import exercise.array.Array1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberInArrayTests {
    private List<Integer> numbers;

    @Before
    public void init() {
        numbers = new ArrayList<>();

        for (int i = 1; i < 101; i++) {
            numbers.add(i);
        };
    }

    @Test
    public void testForNumber1() {
        numbers.remove(0);
        int missingNumber = Array1.getMissingNumber(numbers);

        Assert.assertEquals("Number 1 is missing but not found", 1, missingNumber);
    }

    @Test
    public void testForNumber100() {
        numbers.remove(numbers.size() - 1);
        int missingNumber = Array1.getMissingNumber(numbers);

        Assert.assertEquals("Number 100 is missing but not found", 100, missingNumber);
    }

    @Test
    public void testForRandomNumber() {
        Random random = new Random();
        int randomIndex = random.nextInt(100) + 1;
        int removedNumber = randomIndex + 1;
        numbers.remove(randomIndex);

        int missingNumber = Array1.getMissingNumber(numbers);

        Assert.assertEquals("Number " + removedNumber + " is missing but not found", removedNumber, missingNumber);
    }
}
