package leetcode;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 *
 *
 * @author Alberto Battistini
 * @version 0.1
 * @since 0.1
 */
public class CountPrimes {

    static int countPrimes(int n) {
        if (n < 3)
            return 0;

        int[] primes = new int[n+1];
        for (int i = 2; i <= n; i++) {
            primes[i] = 1;
        }

        for (int i = 2; i*i <= n; i ++) {
            if (primes[i] == 1) {
                for (int j = i*i; j <= n; j += i) {
                    primes[j] = -1;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i] != -1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(countPrimes(n));
    }
}
