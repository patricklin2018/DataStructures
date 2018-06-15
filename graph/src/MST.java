/**
 * @author Patrick-lenovo
 * @create 2018/6/14 2:01
 *
 * 利用 testG4.txt 对 LazyPrimMST、PrimMST、Kruskal 几个方法进行时间效率上的比较
 *
 **/
public class MST {

    public static void main(String[] args) {
        String filename = "graph/data/testG4.txt";
        int V = 10000;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<>(V, false);
        ReadGraphHelper.readWeightedGraph(g, filename);

        long startTime, endTime;
        System.out.println("Test LazyPrimMST:");
        startTime = System.currentTimeMillis();
        LazyPrimMST<Double> lp1 = new LazyPrimMST<>(g);
        endTime = System.currentTimeMillis();
        System.out.println("Consume " + (endTime-startTime) + "ms.");
        System.out.println("the mst weight result = " + lp1.getResult());
        System.out.println();

        System.out.println("Test PrimMST:");
        startTime = System.currentTimeMillis();
        PrimMST<Double> lp2 = new PrimMST<>(g);
        endTime = System.currentTimeMillis();
        System.out.println("Consume " + (endTime-startTime) + "ms.");
        System.out.println("the mst weight result = " + lp2.getMstWeight());
        System.out.println();

        System.out.println("Test KruskalMST:");
        startTime = System.currentTimeMillis();
        KruskalMST<Double> lp3 = new KruskalMST<>(g);
        endTime = System.currentTimeMillis();
        System.out.println("Consume " + (endTime-startTime) + "ms.");
        System.out.println("the mst weight result = " + lp3.getMstWeight());
        System.out.println();
    }
}
