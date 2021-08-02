package algorithm;

import java.util.Arrays;

public class CountingSort {

    static int[] countingSort(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int c: arr) {
            if (c > max)
                max = c;
            if (c < min)
                min = c;
        }
        int[] count = new int[max - min + 1];

        for (int i=0; i < n; i++) {
            count[arr[i] - min]++;
        }
        for (int i = 1; i <= count.length - 1; i++) {
            count[i] += count[i-1];
        }

        int[] output =  new int[n];
        for (int k = n - 1; k >= 0; k--) {
            output[count[arr[k] - min] - 1] = arr[k];
            count[arr[k] - min]--;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-53, 42, -21, 50, 9, -19, 1};
        int[] sorted = countingSort(arr);
        System.out.println(Arrays.toString(sorted));
    }
}
