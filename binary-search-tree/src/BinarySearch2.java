/**
 * created by PATRICK
 * 2018/5/30 0:59
 *
 * 二分搜索（非递归）
 *
 **/

public class BinarySearch2 {

    private BinarySearch2() {}

    public static Comparable find(Comparable[] arr, Comparable target) {

        int left = 0, right = arr.length - 1;

        while (left <= right) {

            int mid = (right - left) / 2 + left;

            int result = arr[mid].compareTo(target);
            if (result == 0) {
                return mid;
            }
            else if (result > 0) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = new Integer(i);

        for(int i = 0 ; i < 2*N ; i ++) {
            int v = (int)BinarySearch2.find(arr, new Integer(i));
            if (i < N)
                assert v == i;
            else
                assert v == -1;
        }

        System.out.println("测试通过!");
    }

}
