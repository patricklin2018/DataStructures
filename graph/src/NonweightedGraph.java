public interface NonweightedGraph {
    // 返回顶点数量
    int V();
    // 返回边数量
    int E();
    // 将 v 连向 w
    void addEdge(int v, int w);
    // 检测 v 和 w 是否相连
    boolean hasEdge(int v, int w);
    // 显示存储结构
    void show();
    // 返回 v 的所有邻边
    Iterable<Integer> adj(int v);
}
