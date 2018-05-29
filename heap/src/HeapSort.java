/**
 * Created by Patrick
 * 2018/5/29 10:34
 *
 * 堆排序
 *
 * 时间复杂度 = O(nlogn)
 * 最坏情况下 O(nlogn)
 * 最好情况下 O(nlogn)
 * 空间复杂度 = O(1)
 * 稳定性 = false
 *
 */

public class HeapSort {

    private HeapSort() {}

    public static void sort(Comparable[] arr) {

        int size = arr.length;
        MaxHeap<Comparable> heap = new MaxHeap<>(size);

        // 进堆, 时间复杂度为 O(nlogn)
        for (int i = 0; i < size; ++i) {
            heap.insert(arr[i]);
        }

        // 出堆，时间复杂度为 O(nlogn)
        for (int i = size - 1; i >= 0; --i) {
            arr[i] = heap.extractMax();
        }
    }

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSort("HeapSort", arr1);
    }
}
