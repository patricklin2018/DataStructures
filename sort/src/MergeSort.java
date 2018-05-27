import java.util.Arrays;

/**
 * Created by Patrick
 * 2018/5/27 16:15
 *
 * 归并排序
 */

public class MergeSort {
    private MergeSort() {}

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

    private static void merge(Comparable[] arr, int left, int mid, int right) {
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
