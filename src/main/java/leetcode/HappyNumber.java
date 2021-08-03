package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 * @author Alberto Battistini
 * @version 0.1
 * @since 0.1
 */
public class HappyNumber {

    static Set<Integer> set = new HashSet<>();

    static boolean isHappy(int n) {
        boolean added = set.add(n);
        if (!added) {
            // already added and not found solution
            return false;
        }
        String s = String.valueOf(n);
        int sum = 0;
        for (int i=0; i < s.length(); i++) {
            int digit = Integer.parseInt(s.substring(i, i+1));
            sum += digit * digit;
        }
        if (sum == 1) return true;
        return isHappy(sum);
    }

    public static void main(String[] args) {
        int n = 19;
        int n1 = 3;
        System.out.println(isHappy(n));
        System.out.println(isHappy(n1));
    }
}
