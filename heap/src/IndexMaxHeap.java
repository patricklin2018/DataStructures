import java.util.Arrays;

/**
 * Created by Patrick
 * 2018/5/29 15:15
 *
 * 最大索引堆
 *
 * 增加索引，堆的调整交换索引值，而不是交换元素值。
 *
 * 通过 indexes 数组，堆下标找到索引
 * 通过 reverse 数组，索引找到堆下标
 */

public class IndexMaxHeap<Item extends Comparable> {

    protected Item[] data;
    protected int[] indexes;
    protected int[] reverse;
    protected int counter;
    protected int capacity;


    private IndexMaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];

        // reverse 初始化
        for (int i = 0; i <= capacity; ++i) {
            reverse[i] = 0;
        }

        counter = 0;
        this.capacity = capacity;
    }

    /**
     * 查询堆下标 i 下是否已有元素
     * @param i
     * @return
     */
    public boolean contain(int i) {
        assert i + 1 >= 1 && i + 1 <= capacity;

        return reverse[i + 1] != 0;
    }

    public int size() {
        return counter;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    /**
     * 插入新元素，
     * @param i 索引，0 为开始
     * @param item
     */
    public void insert(int i, Item item) {

        assert i + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;
        assert !contain(i);

        // data 索引从 1 开始
        i++;

        indexes[++counter] = i;
        data[i] = item;
        reverse[i] = counter;

        shiftUp(counter);
    }

    public Item extractMax() {
        assert counter > 0;

        Item ret = data[indexes[1]];
        swapIndex(1, counter);
        reverse[indexes[counter]] = 0;
        counter--;

        shiftDown(1);

        return ret;
    }

    /**
     * @return 最大索引堆中堆顶的索引
     */
    public int extracMaxIndex() {
        assert counter > 0;

        int ret = indexes[1];
        swapIndex(1, counter--);
        shiftDown(1);

        return ret;
    }

    /**
     * @return 索引堆的堆顶元素
     */
    public Item getMax() {
        assert counter > 0;

        return data[indexes[1]];
    }

    /**
     * @return 索引堆的堆顶元素的索引号
     */
    public int getMaxIndex() {
        assert counter > 0;

        return indexes[1];
    }

    /**
     * 获取堆中，索引为 index 的元素
     * @param index
     * @return
     */
    public Item getItem(int index) {
        assert index + 1 >= 1 && index + 1 <= counter;

        return data[index];
    }

    /**
     * 将索引为 i 的元素修改为 item
     * @param i
     * @param item
     */
    public void change(int i, Item item) {

        i += 1;

        assert i <= capacity;
        assert i >= 1 && i <= counter;

        data[i] = item;

        shiftUp(reverse[i]);
        shiftDown(reverse[i]);
    }

    /**
     * 采用移动的方式替代 swap 交换
     * @param k 为堆数组的下标
     */
    private void shiftUp(int k) {

        int e = indexes[k];

        while (k > 1 && data[indexes[k / 2]].compareTo(data[e]) < 0) {
            indexes[k] = indexes[k / 2];
            reverse[indexes[k]] = k;
            k /= 2;
        }

        indexes[k] = e;
        reverse[indexes[k]] = k;
    }

    /**
     * 采用移动的方式替代 swap 交换
     * @param k 为堆数组的下标
     */
    private void shiftDown(int k) {

        int e = indexes[k];

        while (k * 2 <= counter) {
            int j = k * 2;
            if (j + 1 <= counter && data[indexes[j + 1]].compareTo(data[indexes[j]]) > 0) {
                j++;
            }

            if (data[e].compareTo(data[indexes[j]]) > 0) {
                break;
            }

            indexes[k] = indexes[k / 2];
            reverse[indexes[k]] = k;
            k = j;
        }

        indexes[k] = e;
        reverse[indexes[k]] = k;
    }

    /**
     * 交换堆数组下标下的索引值
     * @param i
     * @param j
     */
    private void swapIndex(int i, int j) {
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;

        reverse[indexes[i]] = i;
        reverse[indexes[j]] = j;
    }

    // 测试索引堆中的索引数组index和反向数组reverse
    // 注意:这个测试在向堆中插入元素以后, 不进行extract操作有效
    public boolean testIndexes(){

        int[] copyIndexes = new int[counter + 1];
        int[] copyReverseIndexes = new int[counter + 1];

        for( int i = 0 ; i <= counter ; i ++ ) {
            copyIndexes[i] = indexes[i];
            copyReverseIndexes[i] = reverse[i];
        }

        copyIndexes[0] = 0;
        copyReverseIndexes[0] = 0;
        Arrays.sort(copyIndexes);
        Arrays.sort(copyReverseIndexes);

        // 在对索引堆中的索引和反向索引进行排序后,
        // 两个数组都应该正好是1...count这count个索引
        boolean res = true;
        for( int i = 1 ; i <= counter ; i ++ )
            if( copyIndexes[i-1] + 1 != copyIndexes[i] ||
                    copyReverseIndexes[i-1] + 1 != copyReverseIndexes[i] ){
                res = false;
                break;
            }

        if( !res ){
            System.out.println("Error!");
            return false;
        }

        return true;
    }

    // 测试 IndexMaxHeap
    public static void main(String[] args) {

        int N = 10;
        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<Integer>(N);
        for( int i = 0 ; i < N ; i ++ )
            indexMaxHeap.insert( i , (int)(Math.random()*N) );
        assert indexMaxHeap.testIndexes();
        System.out.println("测试通过!");
    }
}
