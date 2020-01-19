package exercise.leet_code.optimization;

import java.util.Arrays;

/*
 * Runtime: 34 ms, faster than 26.39% of Java online submissions for Gas Station.
 * Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Gas Station.
 */
public class GasStation {
    public static void main(String[] args) {
        System.out.println("3, " + canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        System.out.println("2, " + canCompleteCircuit(new int[]{3,3,4,5,1}, new int[]{3,5,4,1,2}));
        System.out.println("2, " + canCompleteCircuit(new int[]{3,3,5,4,1}, new int[]{3,5,1,4,2}));
        System.out.println("-1, " + canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {
        Arrays.stream(gas).sum();

        for (int startIndex = 0; startIndex < gas.length; startIndex++) {
            if (gas[startIndex] >= cost[startIndex]) {
                int currentStation = startIndex;
                int gasTank = 0;

                // prepare to travel to next station
                while (true) {
                    gasTank += gas[currentStation]; // fill gas
                    if (gasTank < cost[currentStation]) break; // check next station eligibility
                    gasTank -= cost[currentStation]; // consume gas
                    currentStation = currentStation != gas.length - 1 ? currentStation + 1 : 0;
                    if (currentStation == startIndex) return startIndex; // check for roundtrip
                }
            }
        }

        return -1;
    }
}
