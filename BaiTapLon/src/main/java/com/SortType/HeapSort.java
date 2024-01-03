package com.SortType;

public class HeapSort {
    public static int[] heapSortWithPositions(int[] arr) {
        int n = arr.length;
        int[] positions = new int[2]; // To store the positions i and j

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, positions);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i, positions);
            heapify(arr, i, 0, positions);
        }

        if (positions[0] == -1 && positions[1] == -1) {
            return null;
        }
        return positions;
    }

    private static void heapify(int[] arr, int n, int i, int[] positions) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }


        if (largest != i) {
            swap(arr, i, largest, positions);
            heapify(arr, n, largest, positions);
        }
    }

    private static void swap(int[] arr, int i, int j, int[] positions) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        positions[0] = i;
        positions[1] = j;
    }
}
