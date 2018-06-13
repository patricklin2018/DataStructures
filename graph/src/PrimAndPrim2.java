/**
 * @author Patrick-lenovo
 * @create 2018/6/14 2:01
 *
 * 利用 testG4.txt 对 LazyPrimMST 和 LazyPrimMST2 两个方法进行时间效率上的比较
 *
 **/
public class PrimAndPrim2 {

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

        System.out.println("Test LazyPrimMST2:");
        startTime = System.currentTimeMillis();
        LazyPrimMST2<Double> lp2 = new LazyPrimMST2<>(g);
        endTime = System.currentTimeMillis();
        System.out.println("Consume " + (endTime-startTime) + "ms.");
    }
}
