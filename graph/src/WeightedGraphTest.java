/**
 * @author Patrick-lenovo
 * @create 2018/6/12 12:32
 *
 * 带权图测试
 * 借助 ReadGraphHelper ,利用 testG3.txt 对 DenseWeightedGraph 和 SparseWeightedGraph 进行读取测试
 *
 **/
public class WeightedGraphTest {

    public static void main(String[] args) {
        String filename = "graph/src/testG3.txt";

        DenseWeightedGraph<Double> g1 = new DenseWeightedGraph<>(8, false);
        ReadGraphHelper.readWeightedGraph(g1, filename);
        System.out.println("test G3 in Dense NonweightedGraph:");
        g1.show();
        System.out.println();

        SparseWeightedGraph<Double> g2 = new SparseWeightedGraph<>(8, false);
        ReadGraphHelper.readWeightedGraph(g2, filename);
        System.out.println("test G3 in Sparse Weighted NonweightedGraph:");
        g2.show();
    }
}
