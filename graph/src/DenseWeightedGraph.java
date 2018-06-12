import java.util.Vector;

/**
 * @author Patrick-lenovo
 * @create 2018/6/12 12:07
 *
 * 稠密带权图 - 邻接矩阵
 *
 **/
public class DenseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {

    private int n;
    private int m;
    private boolean directed;
    private Edge<Weight>[][] g;

    public DenseWeightedGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new Edge[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                g[i][j] = null;
            }
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

        g[e.v()][e.w()] = new Edge<>(e);
        if (!directed && e.v() != e.w()) {
            g[e.w()][e.v()] = new Edge<>(e);
        }

        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w] != null;
    }

    @Override
    public void show() {
        for( int i = 0 ; i < n ; i ++ ) {
            for( int j = 0 ; j < n ; j ++ ) {
                if (g[i][j] != null) {
                    System.out.print(g[i][j].wt() + "\t");
                } else {
                    System.out.print("NULL\t");
                }
            }
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        Vector<Edge<Weight>> adjE = new Vector<>();

        for (int i = 0; i < n; ++i) {
            if (g[v][i] != null) {
                adjE.add(g[v][i]);
            }
        }

        return adjE;
    }
}
