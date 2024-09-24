package classlab;

import java.util.*;

public class arrayElement {
    public static void main(String[] args) {
        int[] arr = {10, 2, 1, 13, 12, 15, 17};
        int low = 0;
        int high = arr.length - 1;

        int middle = (high - low )/2;
        int[] newArr = new int[arr.length - 1];
        for (int i = 0 ,j = 0; i < arr.length; i++) {
            if (i != middle) {
                newArr[j++] = arr[i];
            }
        }
        System.out.println(Arrays.toString(newArr));
    }
}

