package leetcode;

/**
 *There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such
 * that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1
 * if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 */
public class SearchInRotatedSortedArray {

    static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return binary_search(nums, 0, nums.length - 1, target);
    }

    private static int binary_search(int[] nums, int left, int right, int target) {
        if (left > right)
            return -1;
        int mid = (left + right) / 2;

        if (nums[mid] == target)
            return mid;

        if (nums[left] <= nums[mid]) {

            if (nums[left] <= target && target < nums[mid])
                return binary_search(nums, left, mid - 1, target);
            else
                return binary_search(nums, mid + 1, right, target);

        } else { // nums[left] > nums[mid]

            if (nums[left] <= target || target < nums[mid])
                return binary_search(nums, left, mid - 1, target);
            else
                return binary_search(nums, mid + 1, right, target);
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 3};
        System.out.println("result: " + search(nums,3));
    }
}
