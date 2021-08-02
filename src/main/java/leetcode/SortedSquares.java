package leetcode;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 *
 * @author Alberto Battistini
 * @version 0.1
 * @since 0.1
 */
public class SortedSquares {

    static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0, j = nums.length - 1;

        for (int r = res.length - 1; r >= 0; r--) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                res[r] = nums[i] * nums[i];
                i++;
            }
            else {
                res[r] = nums[j] * nums[j];
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-7,-3,2,3,11};
        nums = sortedSquares(nums);
        System.out.println(Arrays.toString(nums));
    }
}
