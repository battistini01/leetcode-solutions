package leetcode;

/**
 * Given a string s return if it is palindrome
 *
 * @author Alberto Battistini
 * @version 0.1
 * @since 0.1
 */
public class Palindrome {

    static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "XAXAX";
        System.out.println(isPalindrome(s));
    }
}
