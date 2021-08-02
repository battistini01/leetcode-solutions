package algorithm;

import java.util.Arrays;

public class CountingSort {

    //FIXME
    static void countingSort(int[] arr) {
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

        for (int k = arr.length - 1; k >= 0; k--) {
            arr[k] = arr[count[arr[k] - min] - 1];
            count[arr[k] - min]--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {50, 42, -21, -53};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
