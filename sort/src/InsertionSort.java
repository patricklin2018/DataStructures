import java.util.concurrent.ConcurrentMap;

/**
 * Created by Patrick
 * 2018/5/27 16:15
 *
 * 插入排序
 *
 * 时间复杂度 = O(n^2)
 * 最坏情况 O(n^2)
 * 最好情况 O(n)
 * 空间复杂度 = O(1)
 * 稳定性 = true
 *
 */
public class InsertionSort {

    private InsertionSort() {}

    public static void sort(Comparable[] arr) {
        int size = arr.length;

        for (int i = 1; i < size; ++i) {
            Comparable e = arr[i];
            int j = i - 1;
            for (; j >= 0 && arr[j].compareTo(e) > 0; --j) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = e;
        }
    }

    /**
     * 对于 [left, right] 区间进行排序
     * @param arr
     * @param left
     * @param right
     */
    public static void sort(Comparable[] arr, int left, int right) {
        for (int i = left + 1; i <= right; ++i) {
            Comparable e = arr[i];
            int j = i;
            for (; j > left && arr[j - 1].compareTo(e) > 0; --j) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        int N = 20000;

        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("InsertionSort", arr);
    }
}
