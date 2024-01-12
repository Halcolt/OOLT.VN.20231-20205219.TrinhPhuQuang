package com.SortType;

public class ShellSort {
    public static int[] shellSortWithPositions(int[] arr, int gap, int i) {
        int n = arr.length;
        int[] positions = new int[4];

        if (gap == 0) {
            gap = n / 2;  // Khởi tạo giá trị gap
        }

        while (gap > 0) {
            if (i < n) {
                int j = i;
                int temp = arr[i];  // Lưu giá trị tại vị trí i

                if (j >= gap && arr[j - gap] > temp) {
                    // Hoán đổi phần tử arr[j] và arr[j - gap]
                    arr[j] = arr[j - gap];
                    arr[j - gap] = temp;

                    positions[0] = j - gap;
                    positions[1] = j;
                    positions[2] = gap;
                    positions[3] = i + 1;
                    return positions;
                }
                i++;
            } else {
                // Khi đã xử lý xong một "gap", giảm giá trị của "gap"*
                gap = gap / 2;
                i = 0;
            }
        }
        return null;  // finish
    }
}

