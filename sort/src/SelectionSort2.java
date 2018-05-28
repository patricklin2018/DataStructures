/**
 * Created by Patrick
 * 2018/5/27 19:17
 *
 * 对选择排序-优化
 *
 * 优化： 每一轮查找时，同时寻找最小值的索引 和 最大值的索引
 */
public class SelectionSort2 {

    public SelectionSort2() {}

    public static void sort(Comparable[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int minIndex = left;
            int maxIndex = right;

            // 每一轮查找时， 首先保证 arr[minIndex] <= arr[maxIndex]
            if (arr[minIndex].compareTo(arr[maxIndex]) > 0) {
                swap(arr, minIndex, maxIndex);
            }

            for(int i = left + 1; i < right; ++i) {
                if (arr[i].compareTo(arr[minIndex]) < 0) {
                    minIndex = i;
                }
                else if (arr[i].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = i;
                }
            }

            swap(arr, left, minIndex);
            swap(arr, right, maxIndex);

            left ++;
            right --;
        }
    }

    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("SelectionSort2", arr);
    }
}
