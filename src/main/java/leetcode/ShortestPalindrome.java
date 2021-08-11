package leetcode;

/**
 * You are given a string s. You can convert s to a palindrome by adding characters in front of it.
 *
 * Return the shortest palindrome you can find by performing this transformation.
 *
 * Example 1:
 *
 * Input: s = "aacecaaa"
 * Output: "aaacecaaa"
 * Example 2:
 *
 * Input: s = "abcd"
 * Output: "dcbabcd"
 */
public class ShortestPalindrome {

    static String shortestPalindrome(String s) {
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--)
            rev = rev + s.charAt(i);

        if (rev.equals(s))
            return s;

        String p = "";
        String r = "";

        for (char c: rev.toCharArray()) {
            p = p + c;
            r = c + r;
            if ((p + s).equals(rev + r))
                return (p+s);
        }
        return "";
    }

    // sol 2: time exceeeded on last test... f**k
    static String shortestPalindrome2(String s) {
        if (isPal(s)) return s;
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            if (isPalindrome(s, i)) {
                // return prefix + s
                return getPrefix(s, i);
            }
        }
        return "";
    }

    static String getPrefix(String s, int i) {
        String res = "";
        for (int idx = i + 1; idx < s.length(); idx++) {
            res = s.charAt(idx) + res;
        }
        return res + s;
    }

    static boolean isPalindrome(String s, int j) {
        if (s.length() == 1 || s.equals("")) return true;
        for (int i = 0; i < (j+1) / 2; i++)
            if (s.charAt(i) != s.charAt(j - i))
                return false;
        return true;
    }

    static boolean isPal(String s) {
        int j = s.length() - 1;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(j - i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aba";
        System.out.println(shortestPalindrome(s));
    }
}
