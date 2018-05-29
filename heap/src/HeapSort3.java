/**
 * Created by Patrick
 * 2018/5/29 12:33
 *
 * 堆排序-优化
 *
 * 优化： 在 HeapSort2 基础上，直接将堆转化为数组排序，省略出堆的额外空间使用，使得空间复杂度 O(n) => O(1)
 *
 * 堆的索引不再类似 MaxHeap 中，以 1 为索引开始，而是符合数组特性的，以 0 为索引开始
 *
 */

public class HeapSort3 {

    private HeapSort3() {}

    public static void sort(Comparable[] arr) {
        int size = arr.length;

        // Heapify 数组建堆
        for (int i = (size - 1) / 2; i >= 0; --i) {
            shiftDown(arr, size, i);
        }

        // 堆转数组
        for (int i = size - 1; i > 0; --i) {
            swap(arr, i, 0);
            shiftDown(arr, i, 0);
        }
    }

    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void shiftDown(Comparable[] arr, int size, int i) {
        Comparable v = arr[i];

        while (i * 2 + 1 < size) {
            int j = i * 2 + 1;

            if (j + 1 < size && arr[j].compareTo(arr[j + 1]) < 0) {
                j++;
            }

            if (v.compareTo(arr[j]) > 0) {
                break;
            }

            arr[i] = arr[j];
            i = j;
        }

        arr[i] = v;
    }

    public static void main(String[] args) {
        int N = 10;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSort("HeapSort3", arr);
    }
}
