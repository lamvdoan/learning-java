package exercise.leet_code.optimization;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println("1, " + countAndSay(1));
        System.out.println("11, " + countAndSay(2));
        System.out.println("21, " + countAndSay(3));
        System.out.println("1211, " + countAndSay(4));
        System.out.println("111221, " + countAndSay(5));
        System.out.println("312211, " + countAndSay(6));
        System.out.println("13112221, " + countAndSay(7));
        System.out.println("1113213211, " + countAndSay(8));
        System.out.println("31131211131221, " + countAndSay(9));
        System.out.println("13211311123113112211, " + countAndSay(10));
    }

    public static String countAndSay(int n) {
        String sequence = "1";

        for (int i = 1; i < n; i++) {
            int length = sequence.length();
            int count = 1;
            StringBuilder sb = new StringBuilder("");

            for (int j = 0; j < length; j++) {
                char current = sequence.charAt(j);

                if (j != length - 1 && current == sequence.charAt(j + 1)) {
                    count++;
                } else {
                    sb.append(count).append(current - '0');
                    count = 1;
                }
            }

            sequence = sb.toString();
        }

        return sequence;
    }
}
