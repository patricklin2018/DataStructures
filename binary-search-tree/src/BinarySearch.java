
/**
 * created by PATRICK
 * 2018/5/30 0:49
 *
 * 递归版：
 * 二分搜索
 * floor and ceil
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

    public static int floor(Comparable[] arr, Comparable target) {
        return floor(arr, target, -1, arr.length - 1);
    }

    public static int ceil(Comparable[] arr, Comparable target) {
        return ceil(arr, target, 0, arr.length);
    }

    private static int floor(Comparable[] arr, Comparable target, int left, int right) {
        if (left == right) {
            if (left + 1 < arr.length && arr[left + 1].compareTo(target) == 0) {
                return left + 1;
            }
            return left;
        }

        int mid = (right - left + 1) / 2 + left;
        if (arr[mid].compareTo(target) >= 0) {
            return floor(arr, target, left, mid  - 1);
        }
        else {
            return floor(arr, target, mid, right);
        }
    }

    private static int ceil(Comparable[] arr, Comparable target, int left, int right) {
        if (left == right) {
            if (right - 1 >= 0 && arr[right - 1].compareTo(target) == 0) {
                return right - 1;
            }
            return right;
        }

        int mid = (right - left) / 2 + left;
        if (arr[mid].compareTo(target) <= 0) {
            return ceil(arr, target, mid + 1, right);
        }
        else {
            return ceil(arr, target, left, mid);
        }
    }

    public static void main(String[] args) {
        testFloorAndCeil();
    }

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
}
