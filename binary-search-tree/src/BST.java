import java.util.LinkedList;
import java.util.Queue;

/**
 * created by PATRICK
 * 2018/5/30 22:13
 *
 * 二分搜索树
 *
 * 递归实现
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
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.value);

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * @return 二分搜索树中最小的键
     */
    public Key minimum() {
        assert counter > 0;
        Node min = minimum(root);
        return min.key;
    }

    /**
     * @return 二分搜索树中最大的键
     */
    public Key maximum() {
        assert counter > 0;
        Node max = maximum(root);
        return max.key;
    }

    /**
     * 删除二分搜索树中最小键值的点
     */
    public void removeMin() {
        if (root != null) {
            root = removeMin(root);
        }
    }

    /**
     * 删除二分搜索树中最大键值的点
     */
    public void removeMax() {
        if (root != null) {
            root = removeMax(root);
        }
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

    /**
     * 以 node 为根节点的树进行前序遍历
     * @param node
     */
    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.value);
            inOrder(node.right);
        }
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.value);
        }
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            counter--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node left = node.left;
            node.left = null;
            counter--;
            return left;
        }

        node.right = removeMax(node.right);
        return node;
    }

    // 测试二分搜索树的前中后序遍历
    public static void main(String[] args) {

        BST<Integer, Integer> bst = new BST<>();

        int N = 10;
        int M = 100;
        for(int i = 0 ; i < N ; i ++){
            Integer key = new Integer((int)(Math.random()*M));
            bst.insert(key, key);
            System.out.print(key + " ");
        }
        System.out.println();

        // 测试二分搜索树的size()
        System.out.println("size: " + bst.size());
        System.out.println();

        // 测试二分搜索树的前序遍历 preOrder
        System.out.println("preOrder: ");
        bst.preOrder();
        System.out.println();

        // 测试二分搜索树的中序遍历 inOrder
        System.out.println("inOrder: ");
        bst.inOrder();
        System.out.println();

        // 测试二分搜索树的后序遍历 postOrder
        System.out.println("postOrder: ");
        bst.postOrder();
        System.out.println();

        // 测试二分搜索树的后序遍历 levelOrder
        System.out.println("levelOrder: ");
        bst.levelOrder();
        System.out.println();
    }
}
