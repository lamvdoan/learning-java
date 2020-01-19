package exercise.utils;

import java.util.ArrayList;
import java.util.List;

public class RunTime {
    private List<Long> startTimes = new ArrayList<>();
    private List<Long> endTimes = new ArrayList<>();
    private List<Double> elapsedTimes = new ArrayList<>();

    public void start() {
        startTimes.add(System.nanoTime());
    }

    public void endAndPrintElapsedTime() {
        end();
        calculateElapsedTime();
        printElapsedTime();
    }

    private void end() {
        endTimes.add(System.nanoTime());
    }

    private void calculateElapsedTime() {
        double elapsedTime = (endTimes.get(endTimes.size() - 1) - startTimes.get(startTimes.size() - 1)) / 1000000.0;
        elapsedTimes.add(elapsedTime);
    }

    private void printElapsedTime() {
        System.out.println("Total time: " + elapsedTimes.get(elapsedTimes.size() - 1) + " ms");
        System.out.println();
    }

    public void getAverageElapsedTime() {
        double totalElapsedTime = 0.0;

        for (double elapsedTime : elapsedTimes) {
            totalElapsedTime += elapsedTime;
        }

        System.out.println("Average Elapsed Time: " + totalElapsedTime / elapsedTimes.size() + " ms");
    }
}
