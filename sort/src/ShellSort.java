/**
 * Created by Patrick
 * 2018/5/27 20:08
 *
 * 希尔排序(简单插入排序改进)
 *
 */
public class ShellSort {

    private ShellSort() {}

    public static void sort(Comparable[] arr) {
        int size = arr.length;

        for (int gap = size / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < size; ++i) {
                // 插入排序
                int j = i;
                Comparable e = arr[i];
                for (; j >= gap && e.compareTo(arr[j - gap]) < 0; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                arr[j] = e;
            }
        }
    }

    public static void main(String[] args) {
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("ShellSort", arr);
    }
}
