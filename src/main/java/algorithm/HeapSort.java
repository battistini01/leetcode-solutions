package algorithm;

import java.util.Arrays;

public class HeapSort {

    static void heapSort(int[] arr) {

        int n = arr.length;
        // build heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0]; // sposto max alla fine della porzione attuale (arr.length - i) dell'array
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i,0);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;

        int max = i;
        if (l < n && arr[l] > arr[max])
            max = l;
        if (r < n && arr[r] > arr[max])
            max = r;

        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapify(arr, n, max);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 12, 4, 5, 9, 2, 8};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
