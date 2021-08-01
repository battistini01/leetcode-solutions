package main.java.leetcode;

import java.util.Stack;

/**
 * Given a string s which represents an expression, evaluate this expression and return its value.
 *
 * The integer division should truncate toward zero.
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range [0, 231 - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 *
 * @author Alberto Battistini
 * @version 0.1
 * @since 0.1
 */
public class Expression {

    static int calculate(String s) {
        if (s==null ||  s.length() == 0)
            return 0;
        int num = 0;
        char pre = '+';
        s = s.replace(" ","");
        Stack<Integer> st = new Stack<>();
        char ch;

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (s.charAt(i) - '0');
            }

            if (!Character.isDigit(ch) || i == s.length() - 1) {
                if (pre == '+') {
                    st.push(num);
                }
                if (pre == '-') {
                    st.push(-num);
                }
                if (pre == '*') {
                    st.push(st.pop() * num);
                }
                if (pre == '/') {
                    st.push(st.pop() / num);
                }

                pre = s.charAt(i);
                num = 0;
            }
        }

        int sum = 0;
        while (!st.isEmpty()) {
            sum += st.pop();
        }

        return sum;
    }

    public static void main(String[] args) {
        String s = "2+4/2";
        System.out.println(calculate(s));
    }
}
