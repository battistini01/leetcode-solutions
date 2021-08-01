package main.java.leetcode;

/**
 * Solution of leetcode problem: Given an integer, convert it to a roman numeral.
 *
 * @author Alberto Battistini
 * @version 0.1
 * @since 0.1
 */
public class IntToRoman {

    static String intToRoman(int num) {
        if (num < 1)
            return "";
        StringBuilder res = new StringBuilder();
        int mil = num / 1000;
        int cen = (num / 100) % 10;
        int dex = (num / 10) % 10;
        int units = num % 10;

        int m = 0, c = 0, d = 0, u = 0;

        while (m < mil) {
            res.append("M");
            m++;
        }

        while (c < cen) {
            if (cen == 9) {
                res.append("CM");
                c = cen;
            }
            else if (cen >= 5) {
                res.append("D");
                cen -= 5;
                c = 0;
            }
            else if (cen == 4) {
                res.append("CD");
                c = cen;
            }
            else {
                res.append("C");
                c++;
            }
        }

        while (d < dex) {
            if (dex == 9) {
                res.append("XC");
                d = dex;
            }
            else if (dex >= 5) {
                res.append("L");
                dex -= 5;
                d = 0;
            }
            else if (dex == 4) {
                res.append("XL");
                d = dex;
            }
            else {
                res.append("X");
                d++;
            }
        }

        while (u < units) {
            if (units == 9) {
                res.append("IX");
                u = units;
            }
            else if (units >= 5) {
                res.append("V");
                units -= 5;
                u = 0;
            }
            else if (units == 4) {
                res.append("IV");
                u = units;
            }
            else {
                res.append("I");
                u++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int n = 1994;
        System.out.println(intToRoman(n));
    }
}
