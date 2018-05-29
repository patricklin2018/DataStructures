import java.util.Arrays;

/**
 * Created by Patrick
 * 2018/5/27 16:15
 *
 * 归并排序
 *
 * 时间复杂度 = O(nlogn)
 * 最坏情况下 O(nlogn)
 * 最好情况下 O(nlogn)
 * 空间复杂度 = O(n)
 * 稳定性 = true
 *
 */

public class MergeSort {
    private MergeSort() {}

    /**
     * 对 arr 数组的 [left, right] 范围进行归并排序
     * @param arr 排序数组
     * @param left 左边界
     * @param right 右边界
     */
    private static void sort(Comparable[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        // 防止 left + right 溢出
        int mid = (right - left) / 2 + left;

        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void sort(Comparable[] arr) {
        int size = arr.length;
        sort(arr, 0, size - 1);
    }

    /**
     * 对 arr 数组的 [left, mid] 和 [mid + 1, right] 区间进行归并
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(Comparable[] arr, int left, int mid, int right) {
        // backup range [left, right + 1)
        Comparable[] backup = Arrays.copyOfRange(arr, left, right + 1);

        int i = left, j = mid + 1;
        for (int k = left; k <= right; ++k) {
            if (i > mid) {
                // 左半部分处理完毕
                arr[k] = backup[j - left];
                j++;
            }
            else if (j > right) {
                // 右半部分处理完毕
                arr[k] = backup[i - left];
                i++;
            }
            /**
             * 这里需要使用 <= ，保持归并排序的稳定性，否则将被破坏
             */
            else if (backup[i - left].compareTo(backup[j - left]) <= 0) {
                arr[k] = backup[i - left];
                i++;
            }
            else {
                arr[k] = backup[j - left];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        // 这里仅对 MergeSort 和 ShellSort 进行比较
        // 因为测试百万级数据，加入O（n^2）实在太慢了
        int N = 1000000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSort("MergeSort", arr1);
        SortTestHelper.testSort("ShellSort", arr2);
    }
}
