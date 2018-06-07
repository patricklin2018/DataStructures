/**
 * @author Patrick-lenovo
 * @create 2018/6/8 0:29
 *
 * 简单并查集
 *
 **/

public class UnionFind1 {

    private int[] id;
    private int count;

    public UnionFind1(int n) {
        id = new int[n];
        count = n;

        // 初始化
        for (int i = 0; i < n; ++i) {
            // 皆指向自己，没有交并的元素
            id[i] = i;
        }
    }

    /*
    查找元素 p 所对应的集合
     */
    private int find(int p) {
        assert p >= 0 && p < count;
        return id[p];
    }

    /*
    查看 p 和 q 是否属于一个集合
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /*
    将元素 p 的合集合并到元素 q 的合集
    时间复杂度 = O(n)
     */
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) {
            return;
        }

        for (int i = 0; i < count; ++i) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }

    public static void main(String[] args) {

        int n = 1000000;

        // 虽然isConnected只需要O(1)的时间, 但由于union操作需要O(n)的，那么测试过程的 n 次操作，总共的算法复杂度是O(n^2)。
        UnionFindTestHelper.testUF1(n);
    }
}
