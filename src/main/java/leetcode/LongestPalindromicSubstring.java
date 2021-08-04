package leetcode;

public class LongestPalindromicSubstring {

    static String longestPalindrome(String s) {
        if (s.equals("")) return "";
        int max = 0;
        int start = 0, end = 0;
        int n = s.length();
        for(int i = 0; i < n-1; i++) {
            int len1 = calculate(s, i,  i);
            int len2 = calculate(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > max) {
                max = len;
                start = i - (len-1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    static int calculate(String s, int l, int r) {
        int L = l, R = r;
        while (L >= 0 && R <= s.length() - 1 && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        String s1 = "bab";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome(s1));
    }
}
