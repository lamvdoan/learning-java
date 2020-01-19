package exercise.adventofcode.year2019;

import exercise.adventofcode.util.PlainFileReader;

import java.util.List;

public class Day1 {
    public static void main(String[] args) {
        List<String> masses = PlainFileReader.getList("/src/exercise/adventofcode/year2019/day1.txt");
        int totalFuel = 0;

        for (String massString : masses) {
            int mass = Integer.parseInt(massString);
            int fuel = getFuel(mass);

            while (fuel > 0) {
                totalFuel += fuel;
                fuel = getFuel(fuel);
            }
        }

        System.out.println("Total Fuel: " + totalFuel);
    }

    private static int getFuel(int fuel) {
        return (int) (Math.floor(fuel / 3.0) - 2);
    }
}
