package leetcode;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 *
 *  A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without
 *  changing the order of the remaining elements.
 *
 *
 *
 *  Example 1:
 *
 *  Input: s = "bbbab"
 *  Output: 4
 *  Explanation: One possible longest palindromic subsequence is "bbbb".
 *  Example 2:
 *
 *  Input: s = "cbbd"
 *  Output: 2
 *  Explanation: One possible longest palindromic subsequence is "bb".
 *
 */
public class LongestPalindromicSubsequence {

    static int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n == 1)
            return 1;
        if (s.equals("")) return 0;
        int[][] L = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                L[i][j] = -1;
        return long_pal_subseq(s, 0, n - 1, L);
    }

    static int long_pal_subseq(String s, int i, int j, int[][] L) {
        if (L[i][j] != -1)
            return L[i][j];
        if (i == j)
            return 1;
        if (i > j)
            return 0;
        int sum = 0;
        if (s.charAt(i) == s.charAt(j))
            sum += 2 + long_pal_subseq(s, i+1, j-1, L);
        else
            sum += Math.max(long_pal_subseq(s, i+1, j, L), long_pal_subseq(s, i, j-1, L));

        L[i][j] = sum;
        return sum;
    }

    public static void main(String[] args) {

        String _s = "bb";
        String s = "euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxoj" +
                "fofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodq" +
                "mvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbika" +
                "qkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkap" +
                "ovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew";
        System.out.println(longestPalindromeSubseq(_s));
        System.out.println(longestPalindromeSubseq(s));
    }
}
