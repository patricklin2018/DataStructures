/**
 * created by PATRICK
 * 2018/5/30 0:59
 *
 * 非递归版
 * 二分搜索
 * floor and ceil
 *
 **/

public class BinarySearch2 {

    private BinarySearch2() {}

    /**
     * 二分查找-非递归
     * @param arr
     * @param target
     * @return
     */
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

    /**
     * 二分查找法-floor 函数
     * arr 有序数组中找到 target 的 floor
     * @param arr
     * @param target
     * @return 如果找到 target，返回第一个 target 的索引
     *         如果找不到 target，返回小于 target 的最大值的索引
     *         如果 target 为 arr 数组的最小值，则返回 -1
     */
    public static int floor(Comparable[] arr, Comparable target) {
        int left = -1, right = arr.length - 1;

        while (left < right) {
            /**
             * 向上取整
             * 区别主要在于，假设数组 arr = [1,2,3,3,3,4], target = 3
             * left = 1, right = 2, arr[left] = 2, arr[right] = 3
             * 若向下取整，最后 left = right = 2
             * 若向上取整，最后 left = right = 1
             * 其次，left 以 -1 初始化，防止越界等
             */
            int mid = (right - left + 1) / 2 + left;

            if (arr[mid].compareTo(target) >= 0) {
                right = mid - 1;
            }
            else {
                left = mid;
            }
        }

        if (left + 1 < arr.length && arr[left + 1].compareTo(target) == 0) {
            return left + 1;
        }
        return left;
    }

    /**
     * 二分查找-ceil 函数
     * 查找 arr 有序数组中 target 的 ceil
     * @param arr
     * @param target
     * @return 如果找到 target， 返回最后一个该值的索引
     *         否则，返回大于该值的最小值索引
     *         若 target 为数组最大值，则返回 -1
     */
    public static int ceil(Comparable[] arr, Comparable target) {
        int left = 0, right = arr.length;

        while (left < right) {
            // 向下取整
            int mid = (right - left) / 2 + left;
            if (arr[mid].compareTo(target) <= 0) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        if (right - 1 >= 0 && arr[right - 1].compareTo(target) == 0) {
            return right - 1;
        }
        return right == arr.length ? -1 : right;
    }

    public static void main(String[] args) {
        testFloorAndCeil();
    }

    /**
     * 测试 floor 和 ceil
     */
    private static void testFloorAndCeil() {
        Integer arr[] = new Integer[]{1, 1, 1, 2, 2, 2, 2, 2, 4, 4, 5, 5, 5, 6, 6, 6};
        for( int i = 0 ; i <= 8 ; i ++ ){

            int floorIndex = floor(arr, i);
            System.out.println("the floor index of " + i + " is " + floorIndex + ".");
            if( floorIndex >= 0 && floorIndex < arr.length )
                System.out.println("The value is " + arr[floorIndex] + ".");
            System.out.println();

            int ceilIndex = ceil(arr, i);
            System.out.println("the ceil index of " + i + " is " + ceilIndex + ".");
            if( ceilIndex >= 0 && ceilIndex < arr.length )
                System.out.println("The value is " + arr[ceilIndex] + ".");
            System.out.println();

            System.out.println();
        }
    }

    /**
     * 测试二分搜索
     */
    public static void testBinarySearch() {
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
