/**
 * @author Patrick-lenovo
 * @create 2018/6/9 15:29
 *
 * 在 Union Find 4 基础上，在执行 find 操作时，加上 Path Compression 路径压缩优化
 *
 * 第二种压缩方式： 将遍历过的点都指向根节点
 *
 *     2                         2
 *    3                   3   4     5   6
 *   4          ->
 *  5
 * 6
 *
 **/

public class UnionFind6 {
    private int[] parent;
    private int count;
    private int[] rank;

    public UnionFind6(int n) {
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

        if (parent[p] != p) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
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
