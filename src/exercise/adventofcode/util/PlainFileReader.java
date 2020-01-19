package exercise.adventofcode.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlainFileReader {
    public static List<String> getList(String filename) {
        File file = new File(System.getProperty("user.dir") + filename);
        List<String> strings = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            while (true) {
                String st = br.readLine();
                if (st == null) break;

                strings.add(st);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return strings;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strings;
    }
}
