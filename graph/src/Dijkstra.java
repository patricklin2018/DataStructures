import java.util.Vector;

/**
 * @author Patrick-lenovo
 * @create 2018/6/16 13:28
 *
 * Dijkstra 最短路径算法
 *
 **/
public class Dijkstra<Weight extends Number & Comparable>{

    private WeightedGraph<Weight> g;
    // 出发点
    private int s;
    // 从 s 到 i 点的最短路径权值
    private Number[] distTo;
    // 标记顶点是否访问
    private boolean[] isVisted;
    // 记录到达 i 顶点的最短路径中的最后一条边（即连接顶点 i 的那条边）
    private Edge<Weight>[] from;

    public Dijkstra(WeightedGraph g, int s) {
        this.g = g;
        assert s >= 0 && s < g.V();
        this.s = s;

        int verSize = g.V();
        distTo = new Number[verSize];
        isVisted = new boolean[verSize];
        from = new Edge[verSize];
        for (int i = 0; i < verSize; ++i) {
            distTo[i] = 0.0;
            isVisted[i] = false;
            from[i] = null;
        }

        IndexMinHeap<Weight> iHeap = new IndexMinHeap<>(g.V());
        from[s] = new Edge<>(s, s, (Weight)(Number)(0.0));
        iHeap.insert(s, (Weight)distTo[s]);
        isVisted[s] = true;

        while (!iHeap.isEmpty()) {
            int v = iHeap.extracMinxIndex() - 1;

            isVisted[v] =  true;

            for (Object o : g.adj(v)) {
                Edge<Weight> e = (Edge<Weight>)o;
                int w = e.other(v);
                if (isVisted[w] == false) {
                    if (from[w] == null || distTo[v].doubleValue() + e.wt().doubleValue() < distTo[w].doubleValue()) {
                        distTo[w] = distTo[v].doubleValue() + e.wt().doubleValue();
                        from[w] = e;

                        if (iHeap.contain(w)) {
                            iHeap.change(w, e.wt());
                        }
                        else {
                            iHeap.insert(w, e.wt());
                        }
                    }
                }
            }
        }
    }

    /*
        返回从 s 到 w 顶点的最短路径值
     */
    public Number getDistTo(int w) {

        assert w >= 0 && w < g.V();
        assert hasPath(w);

        return distTo[w];
    }

    /*
        返回从 s 到 w 的最短路径经过边
     */
    public Vector<Edge<Weight>> shortestPath(int w) {
        assert w >= 0 && w < g.V();
        assert hasPath(w);

        Vector<Edge<Weight>> path = new Vector<>();
        Edge<Weight> e = from[w];
        while (e.v() != s) {
            path.insertElementAt(e, 0);
            e = from[e.v()];
        }
        path.insertElementAt(e, 0);

        return path;
    }

    public void showShortestPath(int w) {
        assert w >= 0 && w < g.V();
        assert hasPath(w);

        Vector<Edge<Weight>> path = shortestPath(w);
        int sz = path.size();
        for (int i = 0; i < sz; ++i) {
            System.out.print( path.elementAt(i).v() + " -> ");
            if(i == sz - 1)
                System.out.println(path.elementAt(i).w());
        }
    }

    /*
        返回 s 和 w 是否联通
     */
    public boolean hasPath(int w) {
        assert w >= 0 && w < g.V();
        return isVisted[w];
    }

    public static void main(String[] args) {
        String filename = "graph/data/testG5.txt";
        int V = 5;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<>(V, true);
        ReadGraphHelper.readWeightedGraph(g, filename);

        Dijkstra<Double> dis = new Dijkstra<>(g, 0);
        for (int i = 0; i < V; ++i) {
            if(dis.hasPath(i)) {
                System.out.println("Shortest Path to " + i + " : " + dis.getDistTo(i));
                dis.showShortestPath(i);
            }
            else
                System.out.println("No Path to " + i );

            System.out.println("----------");
        }
    }
}
