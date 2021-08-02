package algorithm;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j-1] > arr[j]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
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

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
