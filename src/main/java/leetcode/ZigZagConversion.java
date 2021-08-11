package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
 * display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 */
public class ZigZagConversion {

    static String mysolutionConvert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int cols_n = s.length() / numRows;
        int mids_n = numRows - 1;
        int mid_len = numRows - 2;
        StringBuilder sb = new StringBuilder();
        List<String> cols = new ArrayList<>(cols_n);
        List<String> mids = new ArrayList<>(mids_n);

        for (int i = 0; i < s.length(); i += numRows + (numRows - 2)) {
            if (i + numRows >= s.length())
                cols.add(s.substring(i));
            else
                cols.add(s.substring(i, i + numRows));
        }
        for (int i = numRows; i < s.length(); i += numRows + numRows - 2) {
            if (i + mid_len >= s.length()) {
                mids.add(s.substring(i));
            }
            else
                mids.add(s.substring(i, i + mid_len));
        }

        int str_idx = 0, mid_str_idx = numRows - 2 - 1;

        for (int r = 0; r < numRows; r++) {

            int mid_idx = 0;

            for (int c = 0; c < cols.size(); c++) {

                if (r == 0 || r == numRows -1) {
                    String st = cols.get(c);
                    if (str_idx < st.length())
                        sb.append(st.substring(str_idx, str_idx + 1));
                }
                else {
                    String st = cols.get(c);
                    if (str_idx < st.length())
                        sb.append(st.substring(str_idx, str_idx + 1));
                    if (mid_idx < mids.size()) {
                        String mid_str = mids.get(mid_idx);

                        if (Math.abs(r - mid_len) == mid_str_idx && mid_str_idx < mid_str.length()) {
                            sb.append(mid_str.substring(mid_str_idx, mid_str_idx + 1));
                        }
                    }
                }
                mid_idx++;
            }
            if (r != 0 && Math.abs(r - mid_len) == mid_str_idx)
                mid_str_idx--;
            str_idx++;
        }

        System.out.println(cols);
        System.out.println(mids);

        return sb.toString();
    }

    static String convert(String s, int numRows) {  // leetcode proposed solution - much better than mine XD
        if (numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        boolean goingDown = false;
        int curRow = 0;

        for (char c: s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder r: rows) {
            res.append(r);
        }
        return res.toString();
    }

    static String convertInspectRow(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder res = new StringBuilder();
        int cycleLen =  2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {

            for (int j = 0; j + i < s.length(); j += cycleLen) {
                res.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < s.length()) {
                    res.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING"; // expected: PHASIYIRPLIGAN
        int numRows = 5;
        System.out.println("my sol result: " + mysolutionConvert(s, numRows));
        System.out.println("sol 1 result: " + convert(s, numRows));
        System.out.println("sol 2 result: " + convertInspectRow(s, numRows));
    }
}
