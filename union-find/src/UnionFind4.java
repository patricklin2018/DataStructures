/**
 * @author Patrick-lenovo
 * @create 2018/6/9 15:01
 *
 * Quick Union 版本基于 Rank（树深度） 的优化
 *
 * 即，进行 union 操作时，比较两个集合的深度，将浅的集合合并到深的集合，以此优化树深
 *
 **/

public class UnionFind4 {

    private int[] parent;
    private int count;
    private int[] rank;

    public UnionFind4(int n) {
        parent = new int[n];
        count = n;
        rank = new int[n];

        for  (int i = 0; i < count; ++i) {
            parent[i] = i;
            rank[i] = 1;
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
    对比 p 和 q 的树深，将浅的指向深的集合
     */
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        }
        else if (rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        }
        else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }
}
