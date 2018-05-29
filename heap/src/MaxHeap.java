/**
 * created by PATRICK
 * 2018/5/29 1:22
 *
 * 最大堆
 *
 **/

public class MaxHeap<Item extends Comparable> {

    // 数据存储
    // 从 1 开始索引
    protected Item[] data;
    // 数据量
    protected int counter;
    // 容量
    protected int capacity;

    /**
     * 构造一个容量为 capacity 的最大堆
     * @param capacity
     */
    public MaxHeap(int capacity) {
        data = (Item[])new Comparable[capacity + 1];
        counter = 0;
        this.capacity = capacity;
    }

    /**
     * 通过 Heapify 数组建堆
     * @param arr 数组
     */
    public MaxHeap(Item[] arr) {
        int size = arr.length;

        data = (Item[]) new Comparable[size + 1];
        capacity = size;
        for (int i = 0; i < size; ++i) {
            data[i + 1] = arr[i];
        }
        counter = size;

        /**
         * Heapify
         * 时间复杂度 = O(n)
         */
        for (int i = counter / 2; i >= 1; --i) {
            shiftDown(i);
        }
    }

    /**
     * @return 返回元素个数
     */
    public int size() {
        return counter;
    }

    /**
     * @return 堆内是否为空
     */
    public boolean isEmpty() {
        return counter == 0;
    }

    /**
     * 插入新元素
     * @param item
     */
    public void insert(Item item) {
        // 超出容量
        assert counter + 1 <= capacity;

        data[counter + 1] = item;
        counter++;
        shiftUp(counter);
    }

    /**
     * @return 返回最大的元素，即堆的 root 节点
     */
    public Item getMax() {
        assert counter > 0;
        return data[1];
    }

    /**
     * 取出根节点
     * @return
     */
    public Item extractMax() {
        assert counter > 0;

        Item root = data[1];

        swap(1, counter);
        counter--;
        shiftDown(1);

        return root;
    }

    /**
     * 对数组索引为 k 的值进行 shiftUp 操作
     * @param k 数组索引
     */
    private void shiftUp(int k) {
        while (k > 1 && data[k].compareTo(data[k/2]) > 0) {
            swap(k, k/2);
            k /= 2;
        }
    }

    /**
     * 对数组索引为 k 的值进行 shiftDown 操作
     * @param k
     */
    private void shiftDown(int k) {
        while(k * 2 <= counter) {
            int j = k * 2;
            if (j + 1 <= counter && data[j].compareTo(data[j + 1]) < 0) {
                j++;
            }

            if (data[k].compareTo(data[j]) > 0) {
                break;
            }

            swap(k, j);
            k = j;
        }
    }

    /**
     * 交换堆中 i 和 j 索引的值
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        // 堆中元素个数
        int N = 100;
        // 堆中元素取值范围[0, M)
        int M = 100;
        for( int i = 0 ; i < N ; i ++ )
            maxHeap.insert( new Integer((int)(Math.random() * M)) );

        Integer[] arr = new Integer[N];
        for( int i = 0 ; i < N ; i ++ ){
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从大到小排列的
        for( int i = 1 ; i < N ; i ++ ) {
            assert arr[i-1] >= arr[i];
        }
    }
}
