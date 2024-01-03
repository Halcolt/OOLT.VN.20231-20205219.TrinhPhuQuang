package com.SortType;

public class BubbleSort {
    public static int[] bubbleSortWithPositions(int[] arr) {
        int n = arr.length;
        int[] positions = new int[2]; // To store the positions i and j

        for (int pass = 0; pass < n - 1; pass++) {
            for (int i = 0; i < n - 1 - pass; i++) {
                if (arr[i] > arr[i + 1]) {
                    positions[0] = i;
                    positions[1] = i + 1;
                    return positions;
                }
            }
        }
        return null;
    }
}

