package com.SortType;

public class HeapSort {
    public static int[] heapSortWithPositions(int[] arr, int currentSize) {
        int[] positions = new int[3]; // Dùng để trả về vị trí cần hoán đổi và chỉ số hiện tại

        if(currentSize <= 1) {
            return null; // Quá trình sắp xếp đã hoàn tất
        }

        // Ghi lại vị trí cần hoán đổi
        positions[0] = 0;
        positions[1] = currentSize - 1;
        positions[2] = currentSize - 1; // Cập nhật chỉ số hiện tại để trả về

        // Xây dựng lại heap từ root, nhưng không thực hiện hoán đổi ở đây
        heapify(arr, currentSize, 0);

        return positions;
    }

    // Xác định vị trí lớn nhất trong heap, nhưng không thực hiện hoán đổi
    private static void heapify(int[] arr, int n, int i) {
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
            // Tiếp tục xác định vị trí lớn nhất trong heap
            heapify(arr, n, largest);
        }
    }
}
