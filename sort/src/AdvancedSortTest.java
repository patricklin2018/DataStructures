import java.util.Arrays;

/**
 * Created by Patrick
 * 2018/5/28 14:46
 *
 * 时间复杂度 = O(nlogn) 的高级排序算法的时间效率比较
 */

public class AdvancedSortTest{

    public static void main(String[] args) {

        // 测试 T 组数据，每组数据大小为 N
        int T = 100;
        int N = 1000000;

        long time1 = 0, time2 = 0, time3 = 0, time4 = 0, time5 = 0, time6 = 0, time7 = 0, time8 = 0, time9 = 0, time10 = 0;

        for (int i = 0; i < T; ++i) {
            System.out.println("第 " + (i + 1) + " 组数据：");

            Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
            Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
            Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
            Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
            Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);
            Integer[] arr6 = Arrays.copyOf(arr1, arr1.length);
            Integer[] arr7 = Arrays.copyOf(arr1, arr1.length);
            Integer[] arr8 = Arrays.copyOf(arr1, arr1.length);
            Integer[] arr9 = Arrays.copyOf(arr1, arr1.length);
            Integer[] arr10 = Arrays.copyOf(arr1, arr1.length);

            time1 += SortTestHelper.testSort("ShellSort", arr1);
            time2 += SortTestHelper.testSort("MergeSort", arr2);
            time3 += SortTestHelper.testSort("MergeSort2", arr3);
            time4 += SortTestHelper.testSort("MergeSort3", arr4);
            time5 += SortTestHelper.testSort("QuickSort", arr5);
            time6 += SortTestHelper.testSort("QuickSort2", arr6);
            time7 += SortTestHelper.testSort("QuickSort2Ways", arr7);
            time8 += SortTestHelper.testSort("QuickSort3Ways", arr8);
            time9 += SortTestHelper.testSort("HeapSort", arr9);
            time10 += SortTestHelper.testSort("HeapSort2", arr10);

            System.out.println();
        }

        System.out.println("经过 " + T + " 组大小为 " + N + " 的数据测试，结果如下：");
        System.out.println("ShellSort 平均时间 = " + time1 / T + " ms");
        System.out.println("MergeSort 平均时间 = " + time2 / T + " ms");
        System.out.println("MergeSort2 平均时间 = " + time3 / T + " ms");
        System.out.println("MergeSort3 平均时间 = " + time4 / T + " ms");
        System.out.println("QuickSort 平均时间 = " + time5 / T + " ms");
        System.out.println("QuickSort2 平均时间 = " + time6 / T + " ms");
        System.out.println("QuickSort2Ways 平均时间 = " + time7 / T + " ms");
        System.out.println("QuickSort3Ways 平均时间 = " + time8 / T + " ms");
        System.out.println("HeapSort 平均时间 = " + time9 / T + " ms");
        System.out.println("HeapSort2 平均时间 = " + time10 / T + " ms");
    }
}
