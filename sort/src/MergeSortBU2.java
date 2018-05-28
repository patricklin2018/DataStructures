import java.util.Arrays;

/**
 * Created by Patrick
 * 2018/5/28 12:02
 *
 * 归并排序-自底向上-优化
 *
 * 优化 1： 规模较小时，采用插入排序
 * 优化 2： 左边区间的最大值 小于 右边区间的最小值时省略 merge 计算
 *
 */
public class MergeSortBU2 {

    private MergeSortBU2() {}

    public static void sort(Comparable[] arr) {

        int len = arr.length;

        // 优化 1： 规模较小时，直接采用插入排序
        for (int i = 0; i < len; i += 16) {
            InsertionSort.sort(arr, i, Math.min(i + 15, len - 1));
        }

        for (int size = 16; size < len; size += size) {
            for (int i = 0; i < len - size; i += size + size) {
                // 对 [i + size - 1, i + 2 * size - 1] 进行归并
                // 优化 2： 对于左边区间的最大值，小于右边区间的最小值时，不进行 merge 计算
                if (arr[i + size - 1].compareTo(arr[i + size]) > 0) {
                    MergeSort.merge(arr, i, i + size - 1, Math.min(i + 2 * size - 1, len - 1));
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSort("ShellSort", arr1);
        SortTestHelper.testSort("MergeSort", arr2);
        SortTestHelper.testSort("MergeSort2", arr3);
        SortTestHelper.testSort("MergeSortBU", arr4);
        SortTestHelper.testSort("MergeSortBU2", arr5);
    }
}
