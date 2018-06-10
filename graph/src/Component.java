import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Patrick-lenovo
 * @create 2018/6/10 14:41
 *
 * 采用 BFS 或 DFS 求联通分量
 *
 **/

public class Component {
    Graph g;
    // 记录访问过的数组
    private boolean[] isVisited;
    // 联通分量个数
    private int compCounter;
    // 每个节点所对应的联通分量标记
    private int[] id;

    public Component(Graph graph) {
        g = graph;

        int verticeSize = g.V();

        isVisited = new boolean[verticeSize];
        compCounter = 0;
        id = new int[verticeSize];

        for (int i = 0; i < verticeSize; ++i) {
            isVisited[i] = false;
            id[i] = i;
        }

        // 求联通分量
        for (int i = 0; i < verticeSize; ++i) {
            if (!isVisited[i]) {
                bfs(i);
                compCounter++;
            }
        }
    }

    public int getCompCounter() {
        return compCounter;
    }

    public boolean isConnected(int v, int w) {
        assert v >= 0 && v < g.V();
        assert w >= 0 && w < g.V();

        return id[v] == id[w];
    }

    /**
     * 深度优先搜索
     * @param v 顶点索引
     */
    private void dfs(int v) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        while (!stack.isEmpty()) {
            Integer tmp = stack.pop();
            isVisited[tmp] = true;
            id[tmp] = compCounter;
            for (int i : g.adj(tmp)) {
                if (!isVisited[i]){
                    stack.push(i);
                }
            }
        }
    }

    /**
     * 广度优先搜索
     * @param v
     */
    private void bfs(int v) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(v);
        while (!que.isEmpty()) {
            Integer tmp = que.poll();
            isVisited[tmp] = true;
            id[tmp] = compCounter;
            for (int i : g.adj(tmp)) {
                if (!isVisited[i]){
                    que.offer(i);
                }
            }
        }
    }
}
