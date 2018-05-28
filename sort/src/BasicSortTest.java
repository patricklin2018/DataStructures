import java.util.Arrays;

/**
 * Created by Patrick
 * 2018/5/27 16:58
 *
 * 时间复杂度 = O(n^2) 的基础排序算法的时间效率比较
 */

public class BasicSortTest {

    public static void main(String[] args) {
        int N = 20000;

        // 测试1： 一般测试
        System.out.println("Test for random array, size = " + N + ", random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("SelectionSort", arr1);
        SortTestHelper.testSort("SelectionSort2", arr2);
        SortTestHelper.testSort("InsertionSort", arr3);
        SortTestHelper.testSort("BubbleSort", arr4);
        SortTestHelper.testSort("BubbleSort2", arr5);

        System.out.println();

        // 测试2： 有序性更强的测试
        System.out.println("Test for ordered random array, size = " + N + ", random range [0, 3]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 3);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        arr5 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("SelectionSort", arr1);
        SortTestHelper.testSort("SelectionSort2", arr2);
        SortTestHelper.testSort("InsertionSort", arr3);
        SortTestHelper.testSort("BubbleSort", arr4);
        SortTestHelper.testSort("BubbleSort2", arr5);

        System.out.println();

        // 测试3： 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + ", swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        arr5 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("SelectionSort", arr1);
        SortTestHelper.testSort("SelectionSort2", arr2);
        SortTestHelper.testSort("InsertionSort", arr3);
        SortTestHelper.testSort("BubbleSort", arr4);
        SortTestHelper.testSort("BubbleSort2", arr5);

        System.out.println();
    }
}
