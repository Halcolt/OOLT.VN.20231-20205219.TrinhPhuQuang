package com.SortType;

public class ShellSort {
    public static int[] shellSortWithPositions(int[] arr) {
        int n = arr.length;
        int[] positions = new int[2];

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    swap(arr, j, j - gap, positions);
                }
                arr[j] = temp;
            }
        }

        if (positions[0] == -1 && positions[1] == -1) {
            return null;
        }

        return positions;
    }

    private static void swap(int[] arr, int i, int j, int[] positions) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        positions[0] = i;
        positions[1] = j;
    }
}
