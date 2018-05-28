/**
 * Created by Patrick
 * 2018/5/28 15:17
 *
 * 双路快速排序
 *
 * 优化： partition 操作不再是将数组分为 arr[左边] < arr[p] <= arr[右边] 这种不稳定的形式（当大量arr[i] 等于 arr[p]时，使得 p 右边区间过长，造成算法不稳定性）
 *                 而是将数组分为 arr[左边] <= arr[p] <= arr[右边]，双路进行搜索，使其左右尽可能平衡
 */
public class QuickSort2Ways {

    private QuickSort2Ways() {}

    public static void sort(Comparable[] arr) {
        int size = arr.length;

        sort(arr, 0, size - 1);
    }

    private static void sort(Comparable[] arr, int left, int right) {

        if (right - left <= 15) {
            InsertionSort.sort(arr, left, right);
            return;
        }

        int p = partition(arr, left, right);
        sort(arr, left, p - 1);
        sort(arr, p + 1, right);
    }

    private static int partition(Comparable[] arr, int left, int right) {

        SelectionSort.swap(arr, left, (int)(Math.random() * (right - left + 1)) + left);

        Comparable v = arr[left];
        // 双标定
        int i = left + 1, j = right;
        while (true) {

            /**
             * 这里等式判断采用 arr[i].compareTo(v) < 0 和 arr[j].compareTo(v) > 0 而不采用 arr[i].compareTo(v) <= 0 和 arr[j].compareTo(v) => 0
             * 是因为，前者最后得到的标定点可以使得左右两边更加均衡
             * 比如，arr=[1, 0, 0, 0, ..., 0]，前者虽然多进行了交换计算，但是最后得到的 p 更加趋近中间
             *                                而后者虽然节省了交换计算，但是最后得到的 p 为倒数第二个位置，使得左右两边十分失衡
             */
            while (i <= right && arr[i].compareTo(v) < 0) {
                i++;
            }
            while (j >= left + 1 && arr[j].compareTo(v) > 0) {
                j--;
            }

            if (i > j) {
                break;
            }

            SelectionSort.swap(arr, i, j);
            i++;
            j--;
        }

        SelectionSort.swap(arr, left, j);

        return j;
    }
}
