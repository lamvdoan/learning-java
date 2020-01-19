package exercise.leet_code.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 *  Generate as many possible valid ways in which a parentheses can appear.
 *
 *  Example: n = 2:
 *  ()()
 *  (())
 *
 *  (())
 *  ()()
 *  ())(
 *  )(()
 *  )()(
 *  ))((
 *
 *
 *  n = 3:
 *  ()()()
 *  (()())
 *  (())()
 *  ()(())
 *  ((()))
 *
 *  Invalid: (()))(
 */

public class ValidParentheses {
    public static void main(String[] args) {
        List<String> l = generateParenthesis(3);

        l.forEach(System.out::println);
    }

    private static List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        Set<String> set = new HashSet<>();

        // Generate all combos of Parentheses


        for (String s : set) {
            if (isValid(s)) {
                l.add(s);
            }
        }

        return l;
    }

    private static boolean isValid(String s) {
        int length = s.length();
        int open = length / 2;
        int close = length / 2;

        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                open--;
            } else {
                close--;
            }

            if (open > close) {
                return false;
            }
        }

        return true;
    }
}
