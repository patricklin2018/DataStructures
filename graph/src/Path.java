import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * @author Patrick-lenovo
 * @create 2018/6/10 15:30
 *
 * 采用 BFS 求最短路径
 *
 **/

public class Path {
    private Graph g;
    private int s;
    private boolean[] visited;
    private int[] from;

    // 记录从 s 到可达每个点的最短路径节点数
    private int[] ord;

    /*
        求出图 g 从 s 点开始到其它所有点的路径
     */
    public Path(Graph g, int s) {
        this.g = g;
        assert s >= 0 && s < g.V();
        this.s = s;

        int verticeSize = g.V();
        visited = new boolean[verticeSize];
        from = new int[verticeSize];
        ord = new int[verticeSize];

        for (int i = 0; i < verticeSize; ++i) {
            visited[i] =false;
            from[i] = -1;
            ord[i] = -1;
        }

        Queue<Integer> que = new LinkedList<>();
        que.offer(s);
        visited[s] = true;
        ord[s] = 0;
        while (!que.isEmpty()) {
            Integer tmp = que.poll();
            for (int i : g.adj(tmp)) {
                if (!visited[i]) {
                    que.offer(i);
                    visited[i] = true;
                    from[i] = tmp;
                    ord[i] = ord[tmp] + 1;
                }
            }
        }

    }

    public boolean hasPath(int w) {
        assert w >= 0 && w < g.V();
        return visited[w];
    }

    /*
        查询从 s 到 w  的最短路径
     */
    public Vector<Integer> getPath(int w) {
        assert hasPath(w);

        Vector<Integer> vec = new Vector<>();
        int p = w;
        while (p != -1) {
            vec.insertElementAt(p, 0);
            p = from[p];
        }

        return vec;
    }

    /*
        打印从 s 到 w 的最短路径
     */
    public void pathPrinter(int w) {
        assert hasPath(w);

        Vector<Integer> vec = getPath(w);
        int vecSize = vec.size();
        for( int i = 0 ; i < vecSize ; i ++ ){
            System.out.print(vec.elementAt(i));
            if( i == vec.size() - 1 )
                System.out.println();
            else
                System.out.print(" -> ");
        }
    }

    /*
        查询从 s 到 w 的最短路径的节点数
        若不在一个联通分量上则返回 -1
     */
    public int length(int w){
        assert w >= 0 && w < g.V();
        return ord[w];
    }
}
