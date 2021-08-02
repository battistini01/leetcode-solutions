package algorithm;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    static void mergeSort(int[] arr, int l, int r) {
        if (l < r){
            int q = (l+r) / 2;
            mergeSort(arr, l, q);
            mergeSort(arr, q+1, r);
            merge(arr, l, q, r);
        }
    }

    static void merge(int[] arr, int l, int q, int r) {
        int n1 = q - l + 1;
        int n2 = r - q;
        int l1 = l, l2 = q + 1;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l1++];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[l2++];
        }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    public static void main(String[] args) {
        Random rn = new Random();
        int range = 5000 - (-5000) + 1;
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rn.nextInt(range) - 5000;
        }

        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
