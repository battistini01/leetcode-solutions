package algorithm;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j-1]) {
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        Random rn = new Random();
        int range = 5000 - (-5000) + 1;
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rn.nextInt(range) - 5000;
        }

        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
