package leetcode;

/**
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 *
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 */
public class Sqrt {

    static int mySqrt(int x) {
        if (x <= 1)
            return x;

        long i = 1;
        long result = 1;

        while (result <= x) {
            i++;
            result = i * i;
        }
        return (int) i - 1;
    }

    public static void main(String[] args) {
        int x = 2147395600;
        System.out.println(mySqrt(x));
    }
}
