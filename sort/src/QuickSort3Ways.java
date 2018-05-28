/**
 * Created by Patrick
 * 2018/5/28 15:56
 *
 * 三路快速排序
 *
 * 优化： 相对于两路快速排序，增加一路 arr[i] == v 的考虑，这样，经过一轮 partition，相等的部分即可省略计算
 */
public class QuickSort3Ways {

    private QuickSort3Ways() {}

    public static void sort(Comparable[] arr) {
        int size = arr.length;

        sort(arr, 0, size - 1);
    }

    private static void sort(Comparable[] arr, int left, int right) {

        if (right - left <= 15) {
            InsertionSort.sort(arr, left, right);
            return;
        }

        // 随机标定
        SelectionSort.swap(arr, left, (int)(Math.random() * (right - left + 1) + left));

        Comparable v = arr[left];
        // less 标定小于 v 的最后一个元素
        int less = left;
        // greater 标定大于 v 的第一个元素
        int greater = right + 1;
        int i = left + 1;

        while (i < greater) {
            if (arr[i].compareTo(v) == 0) {
                i++;
            }
            else if (arr[i].compareTo(v) < 0) {
                less++;
                SelectionSort.swap(arr, i++, less);
            }
            else {
                greater--;
                SelectionSort.swap(arr, i, greater);
            }
        }

        SelectionSort.swap(arr, left, less);

        sort(arr, left, less - 1);
        sort(arr, greater, right);
    }

    public static void main(String[] args) {
        int N = 200000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSort("QuickSort3Ways", arr1);
    }
}
