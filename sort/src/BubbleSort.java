/**
 * Created by Patrick
 * 2018/5/27 19:30
 *
 * 冒泡排序
 *
 *
 */
public class BubbleSort {

    private BubbleSort() {}

    public static void sort(Comparable[] arr) {
        int size = arr.length;
        boolean swaped = false;

        do {
            swaped = false;

            for (int i = 1; i < size; ++i) {
                if (arr[i].compareTo(arr[i - 1]) < 0) {
                    swap(arr, i - 1, i);
                    swaped = true;
                }
            }
        } while(swaped);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 20000;

        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("BubbleSort", arr);
    }
}
