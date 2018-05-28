import java.util.Arrays;

/**
 * Created by Patrick
 * 2018/5/28 01:00
 *
 * 归并排序优化
 *
 * 时间复杂度 = O(n^2)
 * 最坏情况下 O(n^2)
 * 最好情况下 O(n^2)
 * 空间复杂度 = O(1)
 * 稳定性 = false
 *
 */

public class MergeSort2 {
    private MergeSort2() {}

    public static void sort(Comparable[] arr) {
        int size = arr.length;
        sort(arr, 0, size - 1);
    }

    private static void sort(Comparable[] arr, int left, int right) {
        // 优化1：当规模小于一定量的数组直接采用插入排序
        if (right - left <= 15) {
            InsertionSort.sort(arr, left, right);
            return;
        }

        int mid = (right - left) / 2 + left;

        sort(arr, left, mid);
        sort(arr, mid + 1, right);

        // 优化2：左边部分的最大元素 小于 右边部分最小元素时，省略 merge 计算
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            MergeSort.merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSort("ShellSort", arr1);
        SortTestHelper.testSort("MergeSort", arr2);
        SortTestHelper.testSort("MergeSort2", arr3);
    }
}
