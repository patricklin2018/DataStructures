/**
 * @author Patrick-lenovo
 * @create 2018/6/12 11:42
 *
 * 带权图接口
 *
 **/

public interface WeightedGraph<Weight extends Number & Comparable> {
    int V();

    int E();

    void addEdge(Edge<Weight> e);

    boolean hasEdge(int v, int w);

    void show();

    /*
        返回顶点 v 的所有边 Edge<Weight>
     */
    Iterable<Edge<Weight>> adj(int v);
}
