package leetcode;

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
