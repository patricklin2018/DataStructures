import java.util.Vector;

/**
 * @author Patrick-lenovo
 * @create 2018/6/12 20:36
 *
 * 使用 Lazy Prim 普里姆求解最小生成树
 *
 **/
public class LazyPrimMST<Weight extends Number & Comparable> {
    // 图引用
    private WeightedGraph<Weight> G;
    // 最小堆，辅助
    private MinHeap<Edge<Weight>> heap;
    // 标记节点 i 是否被访问过
    private boolean[] visited;
    // 最小生成树所包含的所有边
    private Vector<Edge<Weight>> mstEdges;
    // 最小生成树的权值
    private Number mstWeight;

    public LazyPrimMST(WeightedGraph<Weight> graph) {

        // 初始化
        G = graph;
        heap = new MinHeap<>(G.E());
        visited = new boolean[G.V()];
        mstEdges = new Vector<>();
        mstWeight = 0;

        // 选第一个元素作为初始出发点
        visit(0);

        while (!heap.isEmpty()) {
            Edge<Weight> e = heap.extractMin();

            // 如果该边为生成树的一部分
            if (visited[e.w()] == true && visited[e.v()] == true) {
                continue;
            }

            mstEdges.add(e);
            mstWeight = mstWeight.doubleValue() + e.wt().doubleValue();

            if (!visited[e.v()]) {
                visit(e.v());
            }
            else {
                visit(e.w());
            }
        }
    }

    /*
        访问顶点 v
     */
    private void visit(int v) {
        assert !visited[v];
        visited[v] = true;

        // 将和 v 节点相连的所有未访问的边加入最小堆中
        for (Edge<Weight> e : G.adj(v)) {
            if (!visited[e.other(v)]) {
                heap.insert(e);
            }
        }
    }

    public Vector<Edge<Weight>> getMstEdges() {
        return mstEdges;
    }

    public Number getResult () {
        return mstWeight;
    }

    /*
        测试
     */
    public static void main (String[] args) {
        String filename = "graph/data/testG3.txt";
        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<>(V, false);
        ReadGraphHelper.readWeightedGraph(g, filename);
        System.out.println("the weighted graph is:");
        g.show();

        LazyPrimMST<Double> lz = new LazyPrimMST<>(g);
        Vector<Edge<Double>> mst = lz.getMstEdges();
        int mstSz = mst.size();
        System.out.println("the mst result:");
        for(int i = 0; i < mstSz; ++i) {
            System.out.println(mst.elementAt(i));
        }
        System.out.println("the mst weight is: " + lz.getResult());
    }
}
