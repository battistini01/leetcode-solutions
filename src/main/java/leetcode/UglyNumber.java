package leetcode;

/**
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return true if n is an ugly number.
 *
 * @author Alberto Battistini
 * @version 0.1
 * @since 0.1
 */
public class UglyNumber {

    static boolean isUgly(int n) {

        if (n < 1)
            return false;

        n = divideBy(n, 2);
        n = divideBy(n, 3);
        n = divideBy(n, 5);

        return n == 1;
    }

    private static int divideBy(int n, int div) {
        while (n % div == 0) {
            n = n / div;
        }
        return n;
    }

    public static void main(String[] args) {
        int n = 14;
        System.out.println(isUgly(n));
    }
}
