/**
 * Created by Patrick
 * 2018/5/29 10:55
 *
 * 堆排序-优化
 *
 * 优化： 利用数组建堆 Heapify，省略进堆的过程
 *
 * 将 n 个元素逐个插入到空堆中，时间复杂度 = O(nlogn)
 * 通过 Heapify 数组构建堆过程，时间复杂度 = O(n)
 *
 */

public class HeapSort2 {

    private HeapSort2() {}

    public static void sort(Comparable[] arr) {
        int size = arr.length;

        MaxHeap<Comparable> heap = new MaxHeap<>(arr);

        for (int i = size - 1; i >= 0; --i) {
            arr[i] = heap.extractMax();
        }
    }
}
