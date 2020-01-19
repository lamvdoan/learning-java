package exercise.leet_code.optimization;

import java.util.ArrayList;
import java.util.List;

public class PowerOfThree {
    public static void main(String[] args) {
        System.out.println("true, " + isPowerOfThree(531441));
        System.out.println("true, " + isPowerOfThree(243));
        System.out.println("true, " + isPowerOfThree(81));
        System.out.println("true, " + isPowerOfThree(27));
        System.out.println("true, " + isPowerOfThree(3));
        System.out.println("true, " + isPowerOfThree(9));
        System.out.println("true, " + isPowerOfThree(1));
        System.out.println("false, " + isPowerOfThree(45));
        System.out.println("false, " + isPowerOfThree(0));
        System.out.println("false, " + isPowerOfThree(2));
        System.out.println("false, " + isPowerOfThree(-3));
        System.out.println("false, " + isPowerOfThree(-9));
        System.out.println("false, " + isPowerOfThree(531440));
        System.out.println("false, " + isPowerOfThree(1594322));

        List<String> output = new ArrayList<>();
        int i =1;
        output.add(String.valueOf(i));
    }

    private static boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        double power = Math.log10(n) / Math.log10(3);
        return power == Math.ceil(power);
    }
}
