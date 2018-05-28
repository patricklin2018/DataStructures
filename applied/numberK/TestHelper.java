/**
 * created by PATRICK
 * 2018/5/28 20:04
 *
 * 测试辅助用类
 *
 **/

public class TestHelper {

    private TestHelper() {}

    /**
     * 生成一个 range = [0, n] ，具有 n 个元素的无序数组
     * @param n 数组长度
     * @return
     */
    public static Integer[] generateOrderedArray (int n, int rangeL, int rangeR) {

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; ++i) {
            arr[i] = (int)(Math.random() * (rangeR - rangeL + 1)) + rangeL;
        }

        return arr;
    }

    /**
     * 测试 numberK 算法的正确性
     * @param arr
     * @param k k = 1 时为最大元素
     * @param answer 提交测试答案
     * @return 返回测试是否通过
     */
    public static boolean testNumberK(Comparable[] arr, int k, Comparable answer) {
        // 快速排序
        QuickSort3Ways.sort(arr);

        return arr[k - 1].compareTo(answer) == 0 ? true : false;
    }


}
