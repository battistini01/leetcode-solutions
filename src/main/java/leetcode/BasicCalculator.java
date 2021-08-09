package leetcode;

import java.util.Stack;

/**
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the
 * result of the evaluation.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions,
 * such as eval()
 */
public class BasicCalculator {

    static int calculate(String s) {
        if (s==null || s.equals(""))
            return 0;
        s = s.replace(" ","");
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                sum += num * sign;
                sign = 1;
            }
            else if (s.charAt(i) == '(') {
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            }
            else if (s.charAt(i) == ')') {
                sum *= stack.pop();
                sum += stack.pop();
            }
            else if (s.charAt(i) == '-') {
                sign = -1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "-(3+(4+5))";
        System.out.println("expected: -12");
        System.out.println(calculate(s));
    }
}
