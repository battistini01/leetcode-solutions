package leetcode;

import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should
 * be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * @author Alberto Battistini
 * @version 0.1
 * @since 0.1
 */
public class Merge_sorted_arrays {

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] res = new int[m + n];
        int r = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res[r] = nums1[i++];
            }
            else
                res[r] = nums2[j++];
            r++;
        }
        while (i < m) {
            res[r++] = nums1[i++];
        }
        while (j < n) {
            res[r++] = nums2[j++];
        }

        for (int k = 0; k < nums1.length; k++)
            nums1[k] = res[k];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[] {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
