import java.lang.reflect.Method;

/**
 * Created by Patrick
 * 2018/5/27 14:47
 */
public class SortTestHelper {

    private SortTestHelper() {}

    /**
     * 生成有 n 个元素的随机数组，每个元素的随即范围为 [rangeL, rangeR]
     */
    public static Integer[] generateRandomArray(int n, int rangL, int rangR) {

        assert rangL <= rangR;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; ++i) {
            arr[i] = new Integer((int) (Math.random() * (rangR - rangL + 1) + rangL));
        }

        return arr;
    }

    /**
     * 生成一个近乎有序的数组
     * 首先生成一个含有 [0, 1, 2, ..., n-1]的完全有序数组，之后随机交换 swapTimes 对数据
     * swapTimes = 0 时， 数组完全有序
     * swapTimes 越大， 数组越趋向于无序
     */
    public static Integer[]  generateNearlyOrderedArray(int n, int swapTimes) {
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; ++i) {
            arr[i] = new Integer(i);
        }

        // swap
        for (int i = 0; i < n; ++i) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        return arr;
    }

    /**
     * 打印 arr 数组的所有内容
     */
    public static void printArr(Object[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; ++i) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

    /**
     * 判断 arr 数组是否有序
     */
    public static boolean isSorted(Comparable[] arr) {
        int size = arr.length - 1;
        for (int i = 0; i < size; ++i) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 测试 sortClassName 所对应的排序算法，排序 arr 数组所得到的结果的正确性和算法运行时间
     */
    public static long testSort(String sortClassName, Comparable[] arr) {
        // 通过反射机制，查找排序类名称
        try {
            Class sortClass = Class.forName(sortClassName);
            // 获得排序算法
            Method sortMethod = sortClass.getMethod("sort", new Class[] {Comparable[].class});
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 进行排序
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();

            assert isSorted(arr);

            System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + " ms");

            return (endTime - startTime);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
