import java.util.Arrays;

/**
 * Created by Patrick
 * 2018/5/28 12:22
 *
 * 快速排序
 *
 * 时间复杂度 = O(nlogn)
 * 最坏情况下 O(n^2)
 * 最好情况下 O(nlogn)
 * 空间复杂度 = O(nlogn)
 * 稳定性 = false
 *
 */
public class QuickSort {
    private QuickSort() {}

    public static void sort(Comparable[] arr) {
        int size = arr.length;

        sort(arr, 0, size - 1);
    }

    /**
     * 递归对 arr 的 [left, right] 区间进行快速排序
     * @param arr
     * @param left
     * @param right
     */
    private static void sort(Comparable[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int p = partition(arr, left, right);
        sort(arr, left, p - 1);
        sort(arr, p + 1, right);
    }

    /**
     * 对 arr 的 [left, right] 区间进行 partition 操作
     * 选定 arr[left] 作为 partition 操作依据
     * 返回 p，使得 arr[left, p - 1] <= arr[p] && arr[p] <= arr[p + 1, right]
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partition(Comparable[] arr, int left, int right) {
        // 选定第一个元素作为 partition 依据
        Comparable e = arr[left];

        int p = left;
        for (int i = p + 1; i <= right; ++i) {
            if (arr[i].compareTo(e) < 0) {
                p++;
                SelectionSort.swap(arr, i, p);
            }
        }
        SelectionSort.swap(arr, p, left);

        return p;
    }

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr6 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSort("ShellSort", arr1);
        SortTestHelper.testSort("MergeSort", arr2);
        SortTestHelper.testSort("MergeSort2", arr3);
        SortTestHelper.testSort("MergeSortBU", arr4);
        SortTestHelper.testSort("MergeSortBU2", arr5);
        SortTestHelper.testSort("QuickSort", arr6);
    }
}
