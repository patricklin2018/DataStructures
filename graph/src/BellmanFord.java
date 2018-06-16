import java.util.Vector;

/**
 * @author Patrick-lenovo
 * @create 2018/6/16 18:57
 *
 * Bellman-Ford 最短路径算法
 *
 **/
public class BellmanFord<Weight extends Number & Comparable> {

    private WeightedGraph g;
    private int s;
    private Number[] distTo;
    private Edge<Weight>[] from;
    // 标记是否含有负权环
    private boolean hasNegativeCycle;

    public BellmanFord(WeightedGraph g, int s) {
        this.g = g;
        assert s >= 0 && s < g.V();
        this.s = s;

        int vertSize = g.V();
        distTo = new Number[vertSize];
        from = new Edge[vertSize];
        for (int i = 0; i < vertSize; ++i) {
            distTo[i] = 0.0;
            from[i] = null;
        }

        from[s] = new Edge<>(s, s, (Weight)distTo[s]);

        // 使用 pass 步到达最短路径
        for (int pass = 1; pass < vertSize; ++pass) {

            for (int i = 0; i < vertSize; ++i) {
                for (Object item : g.adj(i)) {
                    Edge<Weight> e = (Edge<Weight>)item;

                    if (from[e.v()] != null && (from[e.w()] == null || distTo[e.v()].doubleValue() + e.wt().doubleValue() < distTo[e.w()].doubleValue())) {
                        distTo[e.w()] = distTo[e.v()].doubleValue() + e.wt().doubleValue();
                        from[e.w()] = e;
                    }
                }
            }
        }

        hasNegativeCycle = detectNegativeCycle();
    }

    /*
        判断图 g 中是否含有负权环
     */
    public boolean detectNegativeCycle() {
        for( int i = 0 ; i < g.V() ; i ++ ){
            for( Object item : g.adj(i) ){
                Edge<Weight> e = (Edge<Weight>)item;
                if(from[e.v()] != null && distTo[e.v()].doubleValue() + e.wt().doubleValue() < distTo[e.w()].doubleValue()) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isHasNegativeCycle() {
        return hasNegativeCycle;
    }

    /*
        返回 从 s 到 w 的最短路径的权值
     */
    Number shortestPathTo( int w ){
        assert w >= 0 && w < g.V();
        assert !hasNegativeCycle;
        assert hasPathTo(w);
        return distTo[w];
    }

    /*
        判断 s 到 w 是否联通
     */
    boolean hasPathTo( int w ){
        assert( w >= 0 && w < g.V() );
        return from[w] != null;
    }

    /*
        获得最短路径
     */
    Vector<Edge<Weight>> shortestPath(int w){

        assert w >= 0 && w < g.V() ;
        assert !hasNegativeCycle ;
        assert hasPathTo(w) ;

        Vector<Edge<Weight>> res = new Vector<>();
        Edge<Weight> e = from[w];
        while (e.v() != s) {
            res.insertElementAt(e, 0);
            e = from[e.v()];
        }
        res.insertElementAt(e, 0);

        return res;
    }

    /*
        打印从 s 到 w 的路径
     */
    void showPath(int w){

        assert( w >= 0 && w < g.V() );
        assert( !hasNegativeCycle );
        assert( hasPathTo(w) );

        Vector<Edge<Weight>> res = shortestPath(w);
        for( int i = 0 ; i < res.size() ; i ++ ){
            System.out.print(res.elementAt(i).v() + " -> ");
            if(i == res.size() - 1)
                System.out.println(res.elementAt(i).w());
        }
    }

    /*
        测试
     */
    public static void main(String[] args) {
        String filename = "graph/data/testG7.txt";
        int V = 5;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<>(V, true);
        ReadGraphHelper.readWeightedGraph(g, filename);

        System.out.println("Test Bellman-Ford:\n");
        int s = 0;
        BellmanFord<Double> bf = new BellmanFord<>(g, s);
        if(bf.detectNegativeCycle())
            System.out.println("The graph contain negative cycle!");
        else{
            for (int i = 0 ; i < V; ++i) {
                if(i == s)
                    continue;

                if(bf.hasPathTo(i)) {
                    System.out.println("Shortest Path to " + i + " : " + bf.shortestPathTo(i));
                    bf.showPath(i);
                }
                else
                    System.out.println("No Path to " + i );
            }
        }
    }

}
