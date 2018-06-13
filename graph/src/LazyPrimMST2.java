import java.util.Vector;

/**
 * @author Patrick-lenovo
 * @create 2018/6/13 0:49
 *
 * 使用 Lazy Prim 普里姆求解最小生成树 - 优化
 *
 * 采用最小索引堆代替最小堆，仅维护最小权值的横切边，而不是将所有横切边加入堆
 *
 * 将时间复杂度从 O(ElogE) 将为 O(ElogV)
 *
 **/
public class LazyPrimMST2<Weight extends Number & Comparable> {
    // 图引用
    private WeightedGraph<Weight> G;
    // 最小索引堆
    private IndexMinHeap<Weight> imh;
    // 记录当前生成树的最小权值横切边
    private Edge<Weight>[] edgeTo;
    // 标记节点 i 是否被访问过
    private boolean[] visited;
    // 最小生成树所包含的所有边
    private Vector<Edge<Weight>> mstEdges;
    // 最小生成树的权值
    private Number mstWeight;

    public LazyPrimMST2(WeightedGraph WG) {
        G = WG;
        assert G.E() >= 1;
        imh = new IndexMinHeap<>(G.V());

        // 初始化
        edgeTo = new Edge[G.V()];
        visited = new boolean[G.V()];
        for (int i = 0; i < G.V(); ++i) {
            edgeTo[i] = null;
            visited[i] = false;
        }
        mstEdges = new Vector<>();
        mstWeight = 0;

        visit(0);
        while (!imh.isEmpty()) {
            // 这里因为该 heap 的存储从 1 开始，而 edgeTo 从 0 开始，因此需要减 1
            int v = imh.extracMinxIndex() - 1;
            assert edgeTo[v] != null;
            mstEdges.add(edgeTo[v]);
            mstWeight = mstWeight.doubleValue() + edgeTo[v].wt().doubleValue();
            visit(v);
        }
    }

    private void visit(int v) {
        assert !visited[v];
        visited[v] = true;

        for (Edge<Weight> e : G.adj(v)) {
            int other = e.other(v);
            if (visited[other]) {
                continue;
            }

            if (edgeTo[other] == null) {
                edgeTo[other] = e;
                imh.insert(other, e.wt());
            }
            else if (edgeTo[other].wt().compareTo(e.wt()) > 0) {
                edgeTo[other] = e;
                imh.change(other, e.wt());
            }
        }
    }

    public Vector<Edge<Weight>> getMstEdges() {
        return mstEdges;
    }

    public Number getMstWeight() {
        return mstWeight;
    }

    /*
        利用 /data/testG4.txt 测试
     */
    public static void main (String[] args) {
        String filename = "graph/data/testG4.txt";
        int V = 10000;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<>(V, false);
        ReadGraphHelper.readWeightedGraph(g, filename);
        System.out.println("the weighted graph is:");
        g.show();

        LazyPrimMST2<Double> lz = new LazyPrimMST2<>(g);
        Vector<Edge<Double>> mst = lz.getMstEdges();
        int mstSz = mst.size();
        System.out.println("the mst result:");
        for(int i = 0; i < mstSz; ++i) {
            System.out.println(mst.elementAt(i));
        }
        System.out.println("the mst weight is: " + lz.getMstWeight());
    }
}
