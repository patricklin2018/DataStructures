/**
 * @author Patrick-lenovo
 * @create 2018/6/9 12:38
 *
 * Quick Union 版本 基于 size 的优化
 *
 * 即，进行 union 操作时，不再将 p 固定指向 q，而是考虑两者的 size，将小合计指向大合集
 *
 **/

public class UnionFind3 {
    private int[] parent;
    private int count;
    private int[] size;

    public UnionFind3(int n) {
        parent = new int[n];
        count = n;
        size = new int[n];

        for  (int i = 0; i < count; ++i) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int find(int p) {
        assert p >= 0 && p < count;

        while (p != parent[p]) {
            p = parent[p];
        }

        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /*
    对比 p 和 q 合集的大小，将小的合集指向相对大的合集里，以此优化树深
     */
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        if (size[pRoot] < size[qRoot]) {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
        else {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }
}
