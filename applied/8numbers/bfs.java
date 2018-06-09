import java.util.Arrays;

/**
 * @author Patrick-lenovo
 * @create 2018/6/4 11:45
 *
 * 八数码问题
 *
 * BFS + Hash
 *
 **/

public class bfs {

    // 状态树最大规模 9! = 362880
    final static Integer MAXSIZE = 1000003;

    // 移动误差，顺序为 上下左右移
    final static Integer[] dx = {0, 0, -1, 1};
    final static Integer[] dy = {-1, 1, 0, 0};

    // 局面
    private static class Situation {
        public Integer[] state;
        // 父亲索引
        public Integer parent;
        // 步骤记录, 0-3 分别为上下左右
        public Integer step;

        public Situation(Integer[] newState) {
            state = newState.clone();
            parent = null;
            step = null;
        }

        public Situation(Integer[] newState, Integer p, Integer s) {
            state = Arrays.copyOf(newState, 9);
            parent = p;
            step = s;
        }
    }

    // 八数码状态树
    private static Situation[] states = new Situation[MAXSIZE];

    // 哈希数组，用来查重
    private static boolean[] isVisited = new boolean[MAXSIZE];

    // 用 head 标记当前遍历到的位置
    private static Integer head;

    // 用 rear 标记数组结尾
    private static Integer rear;

    private bfs() {}

    /**
     * 对 原始局面 src 进行搜索，直到找到 dst 目标局面，返回步骤，步骤采用 0-3 分别代表上移，下移，左移，右移
     * @param src
     * @param dst
     * @return string 类型
     */
    public static String serach(Integer[] src, Integer[] dst) {
        System.out.println("初始局面： ");
        situationPrinter(src);

        head = 0;
        rear = 1;

        states[head] = new Situation(src);
        isVisited[getCode(src)] = true;

        while (head < rear) {

            Situation s = states[head];

            // 找到目标
            if (Arrays.equals(s.state, dst)) {
                String result = new String();
                Situation tmp = s;
                while (tmp != null && tmp.parent != null) {
                    result = tmp.step + result;
                    tmp = states[tmp.parent];
                }
                return result;
            }

            // 找到空格
            int i;
            for (i = 0; i < 9; ++i) {
                if (s.state[i] == 0) {
                    break;
                }
            }
            int srcX = i % 3;
            int srcY = i / 3;
            int srcP = srcX + srcY * 3;

            // 尝试移动
            for (int j = 0; j < 4; j++) {
                int dstX = srcX + dx[j];
                int dstY = srcY + dy[j];
                if (dstX >= 0 && dstX < 3 && dstY >= 0 && dstY < 3) {
                    Integer[] tmp = Arrays.copyOf(s.state, 9);
                    int dstP = dstX + dstY * 3;
                    tmp[srcP] = tmp[dstP];
                    tmp[dstP] = 0;

                    // 查重
                    Integer code = getCode(tmp);
                    if (!isVisited[code]) {
                        states[rear] = new Situation(tmp, head, j);
                        isVisited[code] = true;
                        rear++;
                    }
                }
            }

            head++;
        }

        return "hasn't solution";
    }

    /**
     * 获得局面对应的哈希值
     * @param situation
     * @return
     */
    private static Integer getCode(Integer[] situation) {
        Integer val = 0;
        for (int i = 0; i < 9; ++i) {
            val = situation[i] + val * 10;
        }
        return val % MAXSIZE;
    }

    /**
     * 采用九宫格方式打印八数码
     * @param situation
     */
    private static void situationPrinter(Integer[] situation) {
        for (int i = 0; i < situation.length; ++i) {
            System.out.print(situation[i] + " ");
            if (i % 3 == 2) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Integer[] start = {3,4,7,8,2,0,5,1,6};
        Integer[] end = {1, 2, 3, 4, 5, 6, 7, 8, 0};
        String result = serach(start, end);
        System.out.println(result);
        if (!result.equals("hasn't solution")) {
            System.out.println("size = " + (result.length() + 1));
        }
    }
}
