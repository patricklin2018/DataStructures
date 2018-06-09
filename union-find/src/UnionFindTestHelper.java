import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author Patrick-lenovo
 * @create 2018/6/8 0:37
 *
 * 并查集测试辅助类
 *
 **/

public class UnionFindTestHelper {

    /**
     * 生成有 n 个元素的随机数组，每个元素的随即范围为 [rangeL, rangeR]
     */
    public static int[] generateRandomArray(int n, int rangL, int rangR) {

        assert rangL <= rangR;

        int[] arr = new int[n];

        for (int i = 0; i < n; ++i) {
            arr[i] = (int) (Math.random() * (rangR - rangL + 1) + rangL);
        }

        return arr;
    }

    /**
     * 测试 ufClassName 所对应的 union 和 isConnected 操作的算法运行时间
     * @param ufClassName
     * @param a
     * @param b a 和 b 数组用来做 union 操作
     * @param c
     * @param d c 和 d 数组用来做 isConnected 操作
     * @return 总共所用的时间
     */
    public static long testUF(String ufClassName, int[] a, int[] b, int[] c, int[] d) {
        try {
            Class ufClass = Class.forName(ufClassName);

            Constructor cons = ufClass.getConstructor(new Class[]{int.class});

            int N = a.length;
            Object ufObject = cons.newInstance(N);

            Method unionMethod = ufClass.getMethod("unionElements", new Class[] {int.class, int.class});
            Method isConnectedMethod = ufClass.getMethod("isConnected", new Class[] {int.class, int.class});

            long startTime = System.currentTimeMillis();
            // union
            for (int i = 0; i < N; ++i) {
                unionMethod.invoke(ufObject, new Object[]{a[i], b[i]});
            }

            // isConnected
            for (int i = 0; i < N; ++i) {
                isConnectedMethod.invoke(ufObject, new Object[]{c[i], d[i]});
            }
            long endTime = System.currentTimeMillis();

            System.out.println(ufClass.getSimpleName() + " : " + (endTime - startTime) + " ms");

            return (endTime - startTime);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

}
