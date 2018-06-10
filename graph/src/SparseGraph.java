import java.util.Vector;

/**
 * @author Patrick-lenovo
 * @create 2018/6/10 11:59
 *
 * 稀疏图 - 邻接表
 *
 **/

public class SparseGraph implements Graph{
    private int n;
    private int m;
    private boolean directed;
    private Vector<Integer>[] g;

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;

        g = (Vector<Integer>[]) new Vector[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new Vector<>();
        }
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
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;

        if (hasEdge(v, w)) {
            return;
        }

        g[v].add(w);
        if (!directed && v != w) {
            g[w].add(v);
        }

        m++;
    }

    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;

        int size = g[v].size();
        for(int i = 0; i < size; i ++ )
            if( g[v].elementAt(i) == w )
                return true;
        return false;
    }


    /*
        返回 定点 v 的所有邻边
        Java 的引用机制，直接返回 vector 并不会带来额外的开销
     */
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }

    public void show() {
        for( int i = 0 ; i < n ; i ++ ){
            System.out.print("vertex " + i + ":\t");
            int szie = g[i].size();
            for( int j = 0 ; j < szie ; j ++ )
                System.out.print(g[i].elementAt(j) + "\t");
            System.out.println();
        }
    }
}
