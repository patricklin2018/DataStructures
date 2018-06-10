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
        System.out.println("test G1 in Dense Graph:");
        g1.show();

        Component c1 = new Component(g1);
        System.out.println("component = " + c1.getCompCounter());

        Path p = new Path(g1, 0);
        for (int i = 0; i < g1.V(); ++i) {
            p.pathPrinter(i);
        }
        System.out.println();


        SparseGraph g2 = new SparseGraph(13, false);
        ReadGraphHelper readGraph2 = new ReadGraphHelper(g2, filename);
        System.out.println("test G1 in Sparse Graph:");
        g2.show();

        Component c2 = new Component(g2);
        System.out.println("component = " + c2.getCompCounter());

        p = new Path(g2, 0);
        for (int i = 0; i < g2.V(); ++i) {
            p.pathPrinter(i);
        }
        System.out.println();

        filename = "graph/src/testG2.txt";
        DenseGraph g3 = new DenseGraph(6, false);
        ReadGraphHelper readGraph3 = new ReadGraphHelper(g3, filename);
        System.out.println("test G2 in Dense Graph:");
        g1.show();

        Component c3 = new Component(g3);
        System.out.println("component = " + c3.getCompCounter());

        p = new Path(g3, 0);
        for (int i = 0; i < g3.V(); ++i) {
            p.pathPrinter(i);
        }
        System.out.println();

        SparseGraph g4 = new SparseGraph(6, false);
        ReadGraphHelper readGraph4 = new ReadGraphHelper(g4, filename);
        System.out.println("test G2 in Sparse Graph:");
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
