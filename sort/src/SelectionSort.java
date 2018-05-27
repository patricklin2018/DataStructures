/**
 * Created by Patrick
 * 2018/5/27 14:57
 *
 * 选择排序
 *
 * 时间复杂度 = O(n^2)
 * 最坏情况下 O(n^2)
 * 最好情况下 O(n^2)
 * 空间复杂度 = O(1)
 * 稳定性 = false
 */

public class SelectionSort {
    private SelectionSort() {}

    public static void sort(Comparable[] arr) {
        int size = arr.length;

        for (int i = 0; i < size; ++i) {
            // 寻找 [i, n) 之间最小值的索引
            int minIndex = i;
            for (int j = i; j < size; ++j) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
        }
    }

    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("SelectionSort", arr);
    }
}
