/**
 * @author Patrick-lenovo
 * @create 2018/6/10 13:55
 *
 * 分别采用 DenseGraph 和 SparseGraph 存储 testG1.txt 和 testG2.txt 的图
 *
 **/

public class DenseAndSparseGraph {

    public static void main(String[] args) {

        String filename = "graph/src/testG1.txt";
        DenseGraph g1 = new DenseGraph(13, false);
        ReadGraphHelper readGraph1 = new ReadGraphHelper(g1, filename);
        System.out.println("test G1 in Sparse Graph:");
        g1.show();
        System.out.println();

        SparseGraph g2 = new SparseGraph(13, false);
        ReadGraphHelper readGraph2 = new ReadGraphHelper(g2, filename);
        System.out.println("test G2 in Sparse Graph:");
        g2.show();
        System.out.println();

        filename = "graph/src/testG2.txt";
        DenseGraph g3 = new DenseGraph(6, false);
        ReadGraphHelper readGraph3 = new ReadGraphHelper(g3, filename);
        System.out.println("test G1 in Sparse Graph:");
        g1.show();
        System.out.println();

        SparseGraph g4 = new SparseGraph(6, false);
        ReadGraphHelper readGraph4 = new ReadGraphHelper(g4, filename);
        System.out.println("test G2 in Sparse Graph:");
        g2.show();
        System.out.println();
    }
}
