/**
 * created by PATRICK
 * 2018/5/28 20:12
 *
 * numberK
 *
 * 求任意数组中求第 k 大（小）的元素
 *
 **/

public class numberK {

    private numberK() {}

    /**
     * 寻找 arr 数组中第 k 大的元素
     * 第 k 大元素，即 k = 1 时，为最大元素
     * 这里调用 solve(arr, k - 1, 0, size - 1) 将最大元素转为 k = 0，第 0 大元素，这样更符合数组索引逻辑
     * @param arr
     * @param k
     * @return 元素值
     */
    public static Comparable solve(Comparable[] arr, int k) {

        int size = arr.length;

        assert arr != null && k >= 0 && k < size;

        return solve(arr, k - 1, 0, size - 1);
    }

    /**
     * 对 arr 数组 [left, right] 区间进行 partition 操作，直到找到第 k 大元素
     * @param arr
     * @param k
     * @param left
     * @param right
     * @return
     */
    private static Comparable solve(Comparable[] arr, int k, int left, int right) {

        if (left == right) {
            return arr[left];
        }
        else if (right - left <= 15) {
            InsertionSort.sort(arr, left, right);
            return arr[k];
        }

        // 随机标定
        swap(arr, left, (int)(Math.random() * (right - left + 1)) + left);
        Comparable v = arr[left];

        // 三路 partition
        int less = left, greater = right + 1;
        int i = left + 1;
        while(i < greater) {
            if (arr[i].compareTo(v) == 0) {
                i++;
            }
            else if (arr[i].compareTo(v) < 0) {
                less++;
                swap(arr, less, i++);
            }
            else {
                greater--;
                swap(arr, greater, i);
            }
        }
        swap(arr, left, less);

        if (k >= less && k < greater) {
            return arr[less];
        }
        else if (k < less) {
            return solve(arr, k, left, less - 1);
        }
        else {
            return solve(arr, k, greater, right);
        }
    }

    /**
     * 对 arr 数组的 i 和 j 索引的值进行调换
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 10000;

        System.out.println("测试1：随机数组 N = " + N);
        for (int k = 1; k <= N; ++k) {
            Comparable[] arr = TestHelper.generateOrderedArray(N, 0, N);
            Comparable res = solve(arr, k);
            if (!TestHelper.testNumberK(arr, k, res)) {
                System.out.println("k = " + k + " 组测试未通过！ 计算结果为 " + res + "， 正确答案为 " + arr[k]);
            }
        }
        System.out.println("测试1 通过！");
        System.out.println();

        System.out.println("测试2：含有许多相等元素的数组 N = " + N);
        for (int k = 1; k <= N; ++k) {
            Comparable[] arr = TestHelper.generateOrderedArray(N, 0, 100);
            Comparable res = solve(arr, k);
            if (!TestHelper.testNumberK(arr, k, res)) {
                System.out.println("k = " + k + " 组测试未通过！ 计算结果为 " + res + "， 正确答案为 " + arr[k]);
            }
        }
        System.out.println("测试2 通过！");
    }
}
