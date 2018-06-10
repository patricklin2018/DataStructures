import java.util.Vector;

/**
 * @author Patrick-lenovo
 * @create 2018/6/10 11:51
 *
 * 稠密图 - 邻接矩阵实现
 *
 **/
public class DenseGraph implements Graph{
    // 节点数
    private int n;
    // 边数
    private int m;
    // 是否为有向图
    private boolean directed;
    // 图数据
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        assert n > 0;

        this.n = n;
        this.m = 0;
        this.directed = directed;

        g =  new boolean[n][n];
    }

    /*
        返回定点数
     */
    public int V() {
        return n;
    }

    /*
        返回边数
     */
    public int E() {
        return m;
    }

    /*
        图中，将 v 连向 w
     */
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        if (hasEdge(v, w)) {
            return;
        }

        g[v][w] = true;
        if (!directed) {
            g[w][v] = true;
        }

        m++;
    }

    /*
        返回 v 和 w 之间是否具有边
     */
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        return g[v][w];
    }

    /*
        返回 定点 v 的所有邻边
        Java 的引用机制，直接返回 vector 并不会带来额外的开销
     */
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;

        Vector<Integer> adjV = new Vector<Integer>();
        for (int i = 0; i < n; i++) {
            if (g[v][i]) {
                adjV.add(i);
            }
        }
        return adjV;
    }

    public void show() {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(g[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
