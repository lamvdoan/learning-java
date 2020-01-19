package exercise.adventofcode.util;

import java.io.*;

public class CSVFileReader {
    public static int[] getList(String filename) {
        File file = new File(System.getProperty("user.dir") + filename);
        String[] numberString = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";

            while ((line = br.readLine()) != null) {
                numberString = line.split(",");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (numberString == null) return null;
        int[] numbers = new int[numberString.length];

        for (int i = 0; i < numberString.length; i++) {
            numbers[i] = Integer.parseInt(numberString[i]);
        }

        return numbers;
    }
}
