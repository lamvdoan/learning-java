package exercise.leet_code.integer;

// unfinished

public class ReverseInteger {
    public static void main(String[] args) {
        String s = "2147483648";
        char[] chars = s.replace("-", "").toCharArray();
        String str = String.valueOf(chars);
        System.out.println(str);
    }

    public static int reverse(int x) {
        char[] chars = String.valueOf(x).replace("-", "").toCharArray();
        char[] reversed = new char[chars.length];
        char[] compare = new char[chars.length - 1];

        int j = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            reversed[j] = chars[i];

            if (i != 0) {
                compare[j] = chars[i];
            }

            j++;
        }

        int MAX_NUM = 214748364;
        System.out.print(String.valueOf(compare));
        Integer val = Integer.parseInt(String.valueOf(compare));
        val = val * (x > 0 ? 1 : -1);
        if (val < MAX_NUM - 1 || val > MAX_NUM) {
            return 0;
        } else {
            return Integer.parseInt(String.valueOf(reversed)) * (x > 0 ? 1 : -1);
        }
    }
}
