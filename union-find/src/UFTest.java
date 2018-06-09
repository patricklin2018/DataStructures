/**
 * @author Patrick-lenovo
 * @create 2018/6/9 11:20
 *
 * 测试 Union Find 各版本，并进行时间效率的对比
 *
 **/

public class UFTest {

    public static void main (String[] args) {

        int N = 1000000;

        int[] a = UnionFindTestHelper.generateRandomArray(N, 0, N - 1);
        int[] b = UnionFindTestHelper.generateRandomArray(N, 0, N - 1);
        int[] c = UnionFindTestHelper.generateRandomArray(N, 0, N - 1);
        int[] d = UnionFindTestHelper.generateRandomArray(N, 0, N - 1);

        System.out.println("N = " + N + " 次 union 和 isConnected 操作，消耗时间如下：");
        //UnionFindTestHelper.testUF("UnionFind1", a, b, c, d);
        //UnionFindTestHelper.testUF("UnionFind2", a, b, c, d);
        UnionFindTestHelper.testUF("UnionFind3", a, b, c, d);
        UnionFindTestHelper.testUF("UnionFind4", a, b, c, d);
        UnionFindTestHelper.testUF("UnionFind5", a, b, c, d);
        UnionFindTestHelper.testUF("UnionFind6", a, b, c, d);
    }
}
