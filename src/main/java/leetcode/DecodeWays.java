package leetcode;

/**
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 *
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of
 * the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 *
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 *
 * Given a string s containing only digits, return the number of ways to decode it.
 *
 * The answer is guaranteed to fit in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * Example 3:
 *
 * Input: s = "0"
 * Output: 0
 * Explanation: There is no character that is mapped to a number starting with 0.
 * The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
 * Hence, there are no valid ways to decode this since all digits need to be mapped.
 * Example 4:
 *
 * Input: s = "06"
 * Output: 0
 * Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06")
 */
public class DecodeWays {

    static int numDecodings(String s) {
        if (s == null || s.equals(""))
            return 0;
        int[] nw = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            nw[i] = -1;
        return num_ways(s, 0, s.length()-1, nw);
    }

    static int num_ways(String s, int i, int j,int[] nw) {

        if (i<=j && s.charAt(i) == '0')
            return 0;
        if (i >= j) {
            return 1;
        }

        if (nw[i] != -1) {
            return nw[i];
        }

        int num_ways = 0;

        if (i+1 <= j && Integer.parseInt(s.substring(i, i+2)) <= 26) {
            num_ways = num_ways(s, i + 1, j, nw) + num_ways + num_ways(s, i + 2, j, nw);
        }
        else
            num_ways = num_ways(s, i+1, j, nw);

        nw[i] = num_ways;
        return num_ways;
    }

    public int numDecodingsDP(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i=2; i<=s.length(); i++) {
            int one = Integer.valueOf(s.substring(i-1, i));
            int two = Integer.valueOf(s.substring(i-2, i));

            if (one >= 1) {
                dp[i] += dp[i-1];
            }

            if (two >= 10 && two <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "101011";
        // J J K
        // J J A A
        System.out.println(numDecodings(s));
    }
}
