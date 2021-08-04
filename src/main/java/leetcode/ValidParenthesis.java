package leetcode;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string
 * is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Example 1:
 *
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "(]"
 * Output: false
 */
public class ValidParenthesis {

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if (
                c == ')' && (stack.isEmpty() || stack.pop() != '(') ||
                c == ']' && (stack.isEmpty() || stack.pop() != '[') ||
                c == '}' && (stack.isEmpty() || stack.pop() != '{')
            ) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "((()))[]";
        System.out.println(isValid(s));
    }
}
