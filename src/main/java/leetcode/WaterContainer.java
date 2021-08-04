package leetcode;

public class WaterContainer {

    static int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j-i);
            if (height[i] <= height[j])
                i++;
            else
                j--;
            if (area > max)
                max = area;
        }
        return max;
    }

    static int maxAreaDP(int[] height) {
        return max_area(height, 0, height.length - 1);
    }

    static int max_area (int[] height, int left, int right) {
        if (left == right)
            return 0;
        int area = Math.min(height[left], height[right]) * (right - left);
        if (height[left] <= height[right])
            return Math.max(area, max_area(height, left + 1, right));
        else
            return Math.max(area, max_area(height, left, right - 1));
    }

    public static void main(String[] args) {

        int[] height = new int[] {136,114,104,156,183,152,66,189,116,94,90,58,10,131,67,85,183,174,174,135,88,79,19,0,
                15,28,96,95,35,174,38,171,88,142,80,24,95,146,13,163,192,103,21,154,187,40,40,122,167,166,58,7,46,77,7,
                13,58,56,109,93,182,99,17,23,194,97,47,89,195,12,4,188,68,26,142,7,18,134,129,185,101,187,144,99,17,104,
                112,75,160,173,120,142,73,89,165,67,138,164,108,134};
        System.out.println("max area: " + maxArea(height));
        System.out.println("max area dp: " + maxAreaDP(height));
        System.out.println("expected: 15252");
    }
}
