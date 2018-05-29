/**
 * created by PATRICK
 * 2018/5/30 0:49
 *
 * 二分搜索（递归）
 *
 **/

public class BinarySearch {

    private BinarySearch() {}

    /**
     * 二分查找法，递归
     * @param arr 有序数组
     * @param target 查找目标元素
     * @return 找到返回相应的索引，没有找到返回 -1
     */
    public static Comparable find(Comparable[] arr, Comparable target) {
        return find(arr, target, 0, arr.length - 1);
    }

    /**
     * 二分查找有序数组 arr 中的 [left, right] 区间
     * @param arr
     * @param target
     * @param left
     * @param right
     * @return
     */
    private static Comparable find(Comparable[] arr, Comparable target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (right - left) / 2 + left;

        int result = arr[mid].compareTo(target);
        if (result == 0) {
            return mid;
        }
        else if (result > 0) {
            return find(arr, target, left, mid - 1);
        }
        else {
            return find(arr, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = new Integer(i);

        for(int i = 0 ; i < 2*N ; i ++) {
            int v = (int)BinarySearch.find(arr, new Integer(i));
            if (i < N)
                assert v == i;
            else
                assert v == -1;
        }
        System.out.println("测试通过!");
    }

}
