package exercise;

/**
 * /**
 *  *
 *  * Given two strings text1 and text2, return the length of their longest common subsequence.
 *  * If there is no common subsequence, return 0.
 *  *
 *  * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 *  * deleted without changing the relative order of the remaining characters.
 *  *
 *  * For example, "ace" is a subsequence of "abcde".
 *  * A common subsequence of two strings is a subsequence that is common to both strings.
 *  */
public class LCS {

    static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] L = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else
                    L[i][j] = -1;
            }
        }
        lcs_rec(text1, text2, n, m , L);
        return L[n][m];
    }

    static int lcs_rec(String s1, String s2, int i, int j, int[][] L) {
        if (L[i][j] == -1) {
            int max = 0;
            if (s1.charAt(i-1) == s2.charAt(j-1))
                max = 1 + lcs_rec(s1, s2, i-1, j-1, L);
            else
                max = Math.max(lcs_rec(s1, s2, i-1, j, L), lcs_rec(s1, s2, i, j-1, L));
            L[i][j] = max;
            return max;
        }
        return L[i][j];
    }

    static String shortesCommonSuperSequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] L = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else
                    L[i][j] = -1;
            }
        }

        lcs_rec(s1, s2, n, m, L);
        StringBuilder sb = new StringBuilder();

        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            }
            else {
                if (L[i-1][j] >= L[i][j-1]) {
                    sb.append(s1.charAt(i-1));
                    i--;
                }
                else {
                    sb.append(s2.charAt(j-1));
                    j--;
                }
            }
        }

        while (i > 0) {
            sb.append(s1.charAt(i-1));
            i--;
        }

        while (j > 0) {
            sb.append(s2.charAt(j-1));
            j--;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "ABCCS";
        String s2 = "XS";
        //System.out.println(longestCommonSubsequence(s1, s2));
        System.out.println(shortesCommonSuperSequence(s1, s2));
    }
}
