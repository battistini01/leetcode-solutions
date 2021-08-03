package leetcode;

/**
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 */
public class LongestCommonSubsequence {

    static int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length(), m = text2.length();

        int[][] L = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            L[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            L[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (text1.charAt(i-1) == text2.charAt(j-1))
                    L[i][j] = 1 + L[i-1][j-1];
                else {
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
                }
            }
        }

        return L[n][m];
    }

    static int LCS_(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] L = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                L[i][j] = -1;
            }
        }
        return LCS_rec(text1, text2, n, m, L);
    }

    static int LCS_rec(String text1, String text2, int n, int m, int[][] L) {
        if (L[n][m] == -1) {
            if (n == 0 || m == 0)
                L[n][m] = 0;
            else {
                if (text1.charAt(n-1) == text2.charAt(m-1))
                    L[n][m] = 1 + LCS_rec(text1, text2, n-1, m-1, L);
                else {
                    int len1 = LCS_rec(text1, text2, n-1, m, L);
                    int len2 = LCS_rec(text1, text2, n, m-1, L);
                    L[n][m] = Math.max(len1, len2);
                }
            }
        }
        return L[n][m];
    }

    public static void main(String[] args) {
        String s1 = "ABBA";
        String s2 = "ABXBA";
        System.out.println("LCS: " + longestCommonSubsequence(s1, s2));
        System.out.println("LCS_rec: " + LCS_(s1, s2));
    }
}
