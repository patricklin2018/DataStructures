import java.util.Vector;

/**
 * @author Patrick-lenovo
 * @create 2018/6/15 15:24
 *
 * Kruskal 最小生成树算法
 *
 **/
public class KruskalMST<Weight extends Number & Comparable> {

    private Vector<Edge<Weight>> mst;
    private Number mstWeight;

    public KruskalMST(WeightedGraph g) {
        mst = new Vector<>();
        mstWeight = 0;

        MinHeap<Edge<Weight>> heap = new MinHeap<>(g.E());
        int vSize = g.V();
        for (int i = 0; i < vSize; ++i) {
            for (Object item : g.adj(i)) {
                Edge<Weight> e = (Edge<Weight>) item;
                if (e.v() <= e.w()){
                    heap.insert(e);
                }
            }
        }

        UnionFind4 uf = new UnionFind4(g.V());

        while (!heap.isEmpty() && mst.size() < g.V() - 1) {
            Edge<Weight> e = heap.extractMin();
            if (uf.isConnected(e.v(), e.w())) {
                continue;
            }
            mst.add(e);
            uf.unionElements(e.v(), e.w());
           mstWeight = mstWeight.doubleValue() + e.wt().doubleValue();
        }
    }

    public Vector<Edge<Weight>> getMst() {
        return mst;
    }

    public Number getMstWeight() {
        return mstWeight;
    }

    /*
        测试
     */
    public static void main(String[] args) {
        String filename = "graph/data/testG3.txt";
        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<>(V, false);
        ReadGraphHelper.readWeightedGraph(g, filename);
        KruskalMST<Double> kruskalMST = new KruskalMST<>(g);
        Vector<Edge<Double>> mst = kruskalMST.getMst();

        for (int i = 0; i < mst.size(); ++i) {
            System.out.println(mst.elementAt(i));
        }

        System.out.println("the mst weight = " + kruskalMST.getMstWeight());
    }
}
