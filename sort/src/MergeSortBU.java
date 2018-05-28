import java.util.Arrays;

/**
 * Created by Patrick
 * 2018/5/28 10:48
 *
 * 归并排序（自底向上）
 *
 * 自底向上进行归并排序，由 size = 2 开始，以 size *= 2 为递增的 size 区间，进行归并排序。
 */

public class MergeSortBU {

    private MergeSortBU() {}

    public static void sort(Comparable[] arr) {
        int len = arr.length;

        for (int size = 1; size < len; size *= 2) {
            for (int i = 0; i < len - size; i += size + size) {
                // 对 [i, ..., i + size - 1] 和 [i + size, ..., i + 2 * size - 1] 进行归并
                MergeSort.merge(arr, i, i + size - 1, Math.min(i + 2 * size - 1, len - 1));
            }
        }
    }

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSort("ShellSort", arr1);
        SortTestHelper.testSort("MergeSort", arr2);
        SortTestHelper.testSort("MergeSort2", arr3);
        SortTestHelper.testSort("MergeSortBU", arr4);
    }
}
