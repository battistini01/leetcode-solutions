package leetcode;

/**
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.
 * If multiple answers exist, you may return any of them.
 *
 * (A string S is a subsequence of string T if deleting some number of characters from T (possibly 0, and the
 * characters are chosen anywhere from T) results in the string S.)
 */
public class ShortestCommonSupersequence {

    static String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] L = new int[n+1][m+1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else
                    L[i][j] = -1;
        return LCS_(str1, str2, n, m, L);
    }

    static String LCS_(String s1, String s2, int n, int m, int[][] L) {
        if (s1.equals("")) return s2;
        if (s2.equals("")) return s1;

        int r = lcs_rec(s1, s2, n, m, L);

        int[][] dp = L;

        int i = n, j = m;
        String sup_seq = "";
        String sub_seq = "";
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                sup_seq = s1.charAt(i-1) + sup_seq;
                sub_seq = s1.charAt(i-1) + sub_seq;
                i--;
                j--;
            }
            else if (dp[i-1][j] >= dp[i][j-1]) {
                sup_seq = s1.charAt(i-1) + sup_seq;
                i--;
            }
            else {
                sup_seq = s2.charAt(j-1) + sup_seq;
                j--;
            }
        }
        while(i > 0) {
            sup_seq = s1.charAt(i-1) + sup_seq;
            i--;
        }
        while(j > 0) {
            sup_seq = s2.charAt(j-1) + sup_seq;
            j--;
        }

        System.out.println("lcs: " + sub_seq);
        return sup_seq;
    }

    static int lcs_rec(String s1, String s2, int i, int j, int[][] L) {
        if (i == 0 || j == 0)
            return 0;
        if (L[i][j] != -1)
            return L[i][j];
        int max = 0;
        if (s1.charAt(i-1) == s2.charAt(j-1))
            max = 1 + lcs_rec(s1, s2, i-1, j-1, L);
        else {
            int l1 = lcs_rec(s1, s2, i-1, j, L);
            int l2 = lcs_rec(s1, s2, i, j-1, L);
            max = Math.max(l1, l2);
        }
        L[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        String str1 = "AGGTAB", str2 = "GXTXAYB";
        System.out.println("supersequence: " + shortestCommonSupersequence(str1, str2));
    }
}
