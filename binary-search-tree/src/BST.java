/**
 * created by PATRICK
 * 2018/5/30 22:13
 *
 * 二分搜索树
 *
 * 递归 insert
 * 递归 contain
 *
 **/

public class BST<Key extends Comparable<Key>, Value> {

    /**
     * 节点结构
     */
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node (Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    // 根节点
    private Node root;
    // 节点数量
    private int counter;

    public BST() {
        root = null;
        counter = 0;
    }

    /**
     * @return 树的节点数量
     */
    public int size() {
        return counter;
    }

    /**
     * @return 二分搜索树是否为空
     */
    public boolean isEmpty() {
        return counter == 0;
    }

    /**
     * 递归版本
     * 向二分搜索树中添加 (key, value)，若树中存在则更新，否则新建
     * @param key
     * @param value
     */
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    /**
     * 查询二分搜索树中是否存在 键key
     * @param key
     * @return
     */
    public boolean contain(Key key) {
        return contain(root, key);
    }

    /**
     * 查找 key 对应的 value
     * @param key
     * @return 若不存在，返回 null
     */
    public Value search(Key key) {
        return search(root, key);
    }

    /**
     * 递归版本
     * 向以 node 为父节根的二分搜索树中，插入(key, value)
     * @param node 根
     * @param key
     * @param value
     * @return 返回根节点
     */
    private Node insert(Node node, Key key, Value value) {

        if (node == null) {
            counter++;
            return new Node(key, value);
        }

        int result = node.key.compareTo(key);
        if (result == 0) {
            node.value = value;
        }
        else if (result > 0) {
            node.left = insert(node.left, key, value);
        }
        else {
            node.right = insert(node.right, key, value);
        }

        return node;
    }

    /**
     * 查看以 node 为根节点的树是否存在 key键
     * @param node
     * @param key
     * @return
     */
    private boolean contain(Node node, Key key) {
        if (node == null) {
            return false;
        }

        int result = node.key.compareTo(key);
        if (result == 0) {
            return true;
        }
        else if (result > 0) {
            return contain(node.left, key);
        }
        else {
            return contain(node.right, key);
        }
    }

    /**
     * 查找以 node 为根节点的树中，key 对应的 value
     * @param node
     * @param key
     * @return
     */
    private Value search(Node node, Key key) {

        if (node == null) {
            return null;
        }

        int result = node.key.compareTo(key);
        if (result == 0) {
            return node.value;
        }
        else if (result > 0) {
            return search(node.left, key);
        }
        else {
            return search(node.right, key);
        }
    }

    public static void main(String[] args) {

        int N = 1000000;

        // 创建一个数组，包含[0...N)的所有元素
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = new Integer(i);

        // 打乱数组顺序
        for(int i = 0 ; i < N ; i ++) {
            int pos = (int) (Math.random() * (i + 1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }

        BST<Integer,String> bst = new BST<>();
        for(int i = 0 ; i < N ; i ++)
            bst.insert(new Integer(arr[i]), Integer.toString(arr[i]));

        for(int i = 0 ; i < 2*N ; i ++){
            String res = bst.search(new Integer(i));
            if( i < N )
                assert res.equals(Integer.toString(i));
            else
                assert res == null;
        }

        System.out.println("测试通过!");
    }
}
