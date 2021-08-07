package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * In a deck of cards, each card has an integer written on it.
 *
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or
 * more groups of cards, where:
 *
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 *
 *
 * Example 1:
 *
 * Input: deck = [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
 * Example 2:
 *
 * Input: deck = [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition.
 */
public class XofKindInADeckofCards {

    static boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2)
            return false;

        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            hm.put(deck[i], hm.getOrDefault(deck[i], 0) + 1);
        }

        int val = hm.get(deck[0]);
        for (Map.Entry<Integer, Integer> entry: hm.entrySet()) {
            val = gcd(entry.getValue(), val);
        }
        if (val >= 2)
            return true;
        return false;
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] deck = {1,1,2,2};
        System.out.println(hasGroupsSizeX(deck));
    }
}
