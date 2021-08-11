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

    // Basic Calculator 2
    static int calculate2(String s) {
        if (s==null || s.equals(""))
            return 0;
        s = s.replace(" ","");
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int sign = '+';

        for (int i = 0; i < s.length(); i++) {

            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            }
            if (!Character.isDigit(s.charAt(i)) || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                }
                else if (sign == '-') {
                    stack.push(-num);
                }
                else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                else if (sign == '*') {
                    stack.push(stack.pop() * num);
                }

                sign = s.charAt(i);
                num = 0;
            }
        }

        while (!stack.isEmpty())
            sum += stack.pop();
        return sum;
    }

    public static void main(String[] args) {
        //String s = "-(3+(4+5))";
        String s = "7*2+1";
        System.out.println(calculate2(s));
    }
}
