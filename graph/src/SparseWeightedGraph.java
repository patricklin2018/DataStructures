import java.util.Vector;

/**
 * @author Patrick-lenovo
 * @create 2018/6/12 12:05
 *
 * 稀疏带权图 - 邻接表
 *
 **/
public class SparseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {

    // 节点数
    private int n;
    // 边数
    private int m;
    // 是否为有向图
    private boolean directed;
    // 图的数据
    private Vector<Edge<Weight>>[] g;

    public SparseWeightedGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = (Vector<Edge<Weight>>[])new Vector[n];

        for (int i = 0; i < n; ++i) {
            g[i] = new Vector<>();
        }
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(Edge e) {
        assert e.v() >= 0 && e.v() < n;
        assert e.w() >= 0 && e.w() < n;

        if (hasEdge(e.v(), e.w())) {
            return;
        }

        g[e.v()].add(new Edge(e));
        if (directed && e.v() != e.w()) {
            g[e.w()].add(new Edge<>(e));
        }

        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        int eSize = g[v].size();
        for (int i = 0; i < eSize; ++i) {
            if (g[v].elementAt(i).other(v) == w) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; ++i) {
            System.out.print("vertex " + i + " :\t");
            int eSize = g[i].size();
            for (int j = 0; j < eSize; ++j) {
                System.out.print("( " + g[i].elementAt(j).toString() + ")\t");
            }
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
