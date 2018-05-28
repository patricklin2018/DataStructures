import java.util.Arrays;

/**
 * Created by Patrick
 * 2018/5/28 17:01
 *
 * 归并排序-优化
 *
 * 优化： merge 操作所需的额外空间统一进行申请，不再单独申请
 *
 */
public class MergeSort3 {

    private MergeSort3() {}

    public static void sort(Comparable[] arr) {
        int size = arr.length;
        Comparable[] assistant = new Comparable[size];
        sort(arr, assistant, 0, size - 1);
    }

    private static void sort(Comparable[] arr, Comparable[] assistant, int left, int right) {
        if (right - left <= 15) {
            InsertionSort.sort(arr, left, right);
            return;
        }

        int mid = (right - left) / 2 + left;
        sort(arr, assistant, left, mid);
        sort(arr, assistant, mid + 1, right);

        if (arr[mid].compareTo(arr[mid + 1]) > 0){
            merge(arr, assistant, left, mid, right);
        }
    }

    public static void merge(Comparable[] arr, Comparable[] assistant, int left, int mid, int right) {
        System.arraycopy(arr, left, assistant, left, right - left + 1);

        int i = left, j = mid + 1;
        for (int k = left; k <= right; ++k) {
            if (i > mid) {
                arr[k] = assistant[j++];
            }
            else if (j > right) {
                arr[k] = assistant[i++];
            }
            else if (assistant[i].compareTo(assistant[j]) <= 0) {
                arr[k] = assistant[i++];
            }
            else {
                arr[k] = assistant[j++];
            }
        }
    }

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSort("MergeSort", arr1);
        SortTestHelper.testSort("MergeSort2", arr2);
        SortTestHelper.testSort("MergeSort3", arr3);
    }
}
