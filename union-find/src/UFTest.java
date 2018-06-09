/**
 * @author Patrick-lenovo
 * @create 2018/6/9 11:20
 *
 * 测试 Union Find 各版本，并进行时间效率的对比
 *
 **/

public class UFTest {

    public static void main (String[] args) {

        int N = 100000;

        int[] a = UnionFindTestHelper.generateRandomArray(N, 0, N - 1);
        int[] b = UnionFindTestHelper.generateRandomArray(N, 0, N - 1);
        int[] c = UnionFindTestHelper.generateRandomArray(N, 0, N - 1);
        int[] d = UnionFindTestHelper.generateRandomArray(N, 0, N - 1);

        UnionFindTestHelper.testUF("UnionFind1", a, b, c, d);
        UnionFindTestHelper.testUF("UnionFind2", a, b, c, d);
    }
}
