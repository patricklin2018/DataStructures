/**
 * @author Patrick-lenovo
 * @create 2018/6/10 13:55
 *
 * 无权图测试
 * 借助 ReadGraphHelper,分别采用 DenseNonweightedGraph 和 SparseNonweightedGraph 存储 testG1.txt 和 testG2.txt 的图
 *
 **/

public class NonweightedGraphTest {

    public static void main(String[] args) {

        String filename = "graph/data/testG1.txt";
        DenseNonweightedGraph g1 = new DenseNonweightedGraph(13, false);
        ReadGraphHelper.readNonWeightedGraph(g1, filename);
        System.out.println("test G1 in Dense NonweightedGraph:");
        g1.show();

        Component c1 = new Component(g1);
        System.out.println("component = " + c1.getCompCounter());

        Path p = new Path(g1, 0);
        for (int i = 0; i < g1.V(); ++i) {
            p.pathPrinter(i);
        }
        System.out.println();


        SparseNonweightedGraph g2 = new SparseNonweightedGraph(13, false);
        ReadGraphHelper.readNonWeightedGraph(g2, filename);
        System.out.println("test G1 in Sparse NonweightedGraph:");
        g2.show();

        Component c2 = new Component(g2);
        System.out.println("component = " + c2.getCompCounter());

        p = new Path(g2, 0);
        for (int i = 0; i < g2.V(); ++i) {
            p.pathPrinter(i);
        }
        System.out.println();

        filename = "graph/src/testG2.txt";
        DenseNonweightedGraph g3 = new DenseNonweightedGraph(6, false);
        ReadGraphHelper.readNonWeightedGraph(g3, filename);
        System.out.println("test G2 in Dense NonweightedGraph:");
        g1.show();

        Component c3 = new Component(g3);
        System.out.println("component = " + c3.getCompCounter());

        p = new Path(g3, 0);
        for (int i = 0; i < g3.V(); ++i) {
            p.pathPrinter(i);
        }
        System.out.println();

        SparseNonweightedGraph g4 = new SparseNonweightedGraph(6, false);
        ReadGraphHelper.readNonWeightedGraph(g4, filename);
        System.out.println("test G2 in Sparse NonweightedGraph:");
        g2.show();

        Component c4 = new Component(g4);
        System.out.println("component = " + c4.getCompCounter());

        p = new Path(g4, 0);
        for (int i = 0; i < g4.V(); ++i) {
            p.pathPrinter(i);
        }
        System.out.println();
    }
}
