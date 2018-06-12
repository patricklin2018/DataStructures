/**
 * @author Patrick-lenovo
 * @create 2018/6/12 11:52
 *
 * 图的边结构
 *
 **/
public class Edge<Weight extends Number & Comparable> implements Comparable<Edge> {

    // 边的两个端点
    private int a, b;
    // 边的权值
    private Weight weight;

    public Edge(int a, int b, Weight weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public Edge(Edge<Weight> e) {
        this.a = e.a;
        this.b = e.b;
        this.weight = e.weight;
    }

    /*
        返回第一个顶点
     */
    public int v() {
        return a;
    }

    /*
        返回第二个顶点
     */
    public int w() {
        return b;
    }

    /*
        返回权值
     */
    public Weight wt() {
        return weight;
    }

    /*
        给定顶点 x，返回另一个顶点
     */
    public int other(int x) {
        assert x == a || x == b;
        return x == a ? b : a;
    }

    public String toString() {
        return a + "-" + b + " : " + weight;
    }

    @Override
    public int compareTo(Edge that) {
        if (weight.compareTo(that.wt()) < 0) {
            return -1;
        }
        else if (weight.compareTo(that.wt()) > 0) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
