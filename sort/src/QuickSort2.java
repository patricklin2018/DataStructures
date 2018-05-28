import java.util.Arrays;

/**
 * Created by Patrick
 * 2018/5/28 14:56
 *
 * 快速排序-优化
 *
 * 优化 1： 对于小规模数组采用插入排序
 * 优化 2： 对于 partition 操作的标定位置 p 采用随机策略，增强稳定性
 *
 */
public class QuickSort2 {
    private QuickSort2() {}

    public static void sort(Comparable[] arr) {
        int size = arr.length;

        sort(arr, 0, size - 1);
    }

    private static void sort(Comparable[] arr, int left, int right) {
        // 优化 1
        if (right - left <= 15) {
            InsertionSort.sort(arr, left, right);
            return;
        }

        int p = partition(arr, left, right);
        sort(arr, left, p - 1);
        sort(arr, p + 1, right);
    }


    public static int partition(Comparable[] arr, int left, int right) {
        // 优化 2： 随机标定
        SelectionSort.swap(arr, left, (int)(Math.random() * (right - left + 1)) + left);
        Comparable e = arr[left];

        int p = left;
        for (int i = p + 1; i <= right; ++i) {
            if (arr[i].compareTo(e) < 0) {
                p++;
                SelectionSort.swap(arr, p, i);
            }
        }
        SelectionSort.swap(arr, p, left);

        return p;
    }

    public static void main(String[] args) {
        int N = 10;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);;
        SortTestHelper.testSort("QuickSort", arr1);
        SortTestHelper.testSort("QuickSort2", arr2);
    }
}
