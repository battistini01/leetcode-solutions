package leetcode;

/**
 *
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each
 * unique element appears at MOST TWICE. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result
 * be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicatesFromSortedArray {

    // at most twice version
    static int removeDuplicatesMaxTwice(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int ind = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[ind] && nums[i] == nums[ind-1])
                continue;
            ind++;
            nums[ind] = nums[i];
        }
        return ind + 1;
    }

    static int removeDuplicates(int[] nums) {
        int ind = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[ind]) {
                ind++;
                nums[ind] = nums[i];
            }
        }
        return ind + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int[] nums2 = {1,1,1,2,2,3};
        System.out.println("remove max twice expected: 5"); // [1, 1, 2, 2, 3]
        System.out.println(removeDuplicatesMaxTwice(nums));
        System.out.println("remove expected: 3"); // [1, 2, 3]
        System.out.println(removeDuplicates(nums2));
    }
}
