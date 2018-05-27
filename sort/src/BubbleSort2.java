/**
 * Created by Patrick
 * 2018/5/27 19:35
 *
 * 对冒泡排序进行优化
 *
 * 记录最后一次交换的位置，省去下一轮冒泡对该位置以后的元素进行考虑
 */
public class BubbleSort2 {

    private BubbleSort2() {}

    public static void sort(Comparable[] arr) {
        int size = arr.length;
        int lastSwapIndex, lastSwapIndexTmp = size - 1;

        for (int i = 0; i < size; ++i) {
            lastSwapIndex = lastSwapIndexTmp;

            for (int j = 0; j < lastSwapIndex; ++j) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);

                    // 记录住最后一次交换位置
                    lastSwapIndexTmp = j;
                }
            }

            if (lastSwapIndex == lastSwapIndexTmp) {
                break;
            }
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 10000;

        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("BubbleSort2", arr);
    }
}
