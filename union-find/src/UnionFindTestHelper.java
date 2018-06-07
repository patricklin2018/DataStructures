/**
 * @author Patrick-lenovo
 * @create 2018/6/8 0:37
 *
 * 并查集测试辅助类
 *
 **/

public class UnionFindTestHelper {

    /**
     * 测试 UnionFind1 并查集实现
     * @param n ： n 次合并和连接查询操作
     */
    public static void testUF1(int n) {
        UnionFind1 uf = new UnionFind1(n);

        long start = System.currentTimeMillis();

        // 随机选择两个元素进行合并
        for (int i = 0; i < n; ++i) {
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            uf.unionElements(a, b);
        }

        // 连接查询
        for (int i = 0; i < n; ++i) {
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            uf.isConnected(a, b);
        }

        long end = System.currentTimeMillis();

        System.out.println("UF1, n = " + n + ", consuming " + (end - start) + " ms");
    }

}
