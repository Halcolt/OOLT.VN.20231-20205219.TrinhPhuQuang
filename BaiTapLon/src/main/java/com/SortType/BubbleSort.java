package com.SortType;

public class BubbleSort {
    public static int[] bubbleSortWithPositions(int[] arr, int i, int j) {
        int n = arr.length;
        int[] positions = new int[4]; // 0 - 1[vị trí phần tử ] [2 - 3 vị trí phần tử kế]

        if (i < n - 1) {
            if (j < n - 1 - i) {
                if (arr[j] > arr[j + 1]) {
                    // Hoán đổi phần tử
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    positions[0] = j;
                    positions[1] = j + 1;
                } else {
                    positions[0] = -1; // Đánh dấu không cần hoán đổi
                }
                // Cập nhật trạng thái hiện tại
                positions[2] = i;
                positions[3] = j + 1;
                return positions;
            } else {
                // Chuyển sang lượt so sánh tiếp theo
                positions[2] = i + 1;
                positions[3] = 0;
                return positions;
            }
        }
        return null; // Quá trình sắp xếp hoàn tất
    }
}
