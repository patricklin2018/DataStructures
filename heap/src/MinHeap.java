/**
 * Created by Patrick
 * 2018/5/29 17:43
 *
 * 最小堆
 *
 */

public class MinHeap<Item extends Comparable> {

    protected Item[] data;
    protected int counter;
    protected int capacity;

    public MinHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        counter = 0;
        this.capacity = capacity;
    }

    /**
     * 数组构造堆
     * @param arr
     */
    public MinHeap(Item[] arr) {
        int size = arr.length;

        data = (Item[]) new Comparable[size + 1];
        this.capacity = size;

        for (int i = 0; i < size; ++i) {
            data[i + 1] = arr[i];
        }
        counter = size;

        // heapify
        for (int i = counter / 2; i >= 1; --i) {
            shiftDown(i);
        }
    }

    public void insert(Item item) {
        assert counter + 1 <= capacity;

        data[++counter] = item;
        shiftUp(counter);
    }

    /**
     * @return 取出堆顶
     */
    public Item extractMin() {
        assert counter > 0;

        Item res = data[1];
        swap(1, counter--);
        shiftDown(1);

        return res;
    }

    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    private void shiftUp(int i) {
        assert i + 1 >= 1 && i + 1 <= counter;

        Item e = data[i];
        while (i > 1 && data[i / 2].compareTo(e) > 0) {
            data[i] = data[i / 2];
            i /= 2;
        }
        data[i] = e;
    }

    private void shiftDown(int i) {
        assert i + 1 >= 1 && i + 1 <= counter;

        Item e = data[i];
        while (i * 2 <= counter) {
            int j = i * 2;

            if (j + 1 <= counter && data[j + 1].compareTo(data[j]) < 0) {
                j++;
            }

            if (data[j].compareTo(e) > 0) {
                break;
            }

            data[i] = data[j];
            i = j;
        }
        data[i] = e;
    }

    // 测试 MinHeap
    public static void main(String[] args) {

        MinHeap<Integer> minHeap = new MinHeap<Integer>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            minHeap.insert( new Integer((int)(Math.random() * M)) );

        Integer[] arr = new Integer[N];
        // 将minheap中的数据逐渐使用extractMin取出来
        // 取出来的顺序应该是按照从小到大的顺序取出来的
        for( int i = 0 ; i < N ; i ++ ){
            arr[i] = minHeap.extractMin();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从小到大排列的
        for( int i = 1 ; i < N ; i ++ )
            assert arr[i-1] <= arr[i];
    }
}
