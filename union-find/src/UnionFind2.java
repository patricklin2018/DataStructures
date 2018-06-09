/**
 * @author Patrick-lenovo
 * @create 2018/6/9 10:50
 *
 * Union Find
 *
 * Quick Union 版本
 *
 * find 时间复杂度 = O(h 树的深度)
 * union 时间复杂度 = O(h 树的深度)
 *
 **/

public class UnionFind2 {

    private int[] parent;
    private int count;

    public UnionFind2(int n) {
        parent = new int[n];
        count = n;

        for  (int i = 0; i < count; ++i) {
            parent[i] = i;
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
    将 p 合并到 q 的根上
     */
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        parent[pRoot] = qRoot;
    }
}
