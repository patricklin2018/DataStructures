/**
 * created by PATRICK
 * 2018/5/30 22:13
 *
 * 二分搜索树
 *
 * 非递归 insert
 *
 **/

public class BST2<Key extends Comparable<Key>, Value> {

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

    public BST2() {
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
     * 非递归版本
     * @param key
     * @param value
     */
    public void insertIterative(Key key, Value value) {

        if (root == null) {
            root = new Node(key, value);
            return;
        }

        Node i = root;
        while (true) {

            int result = i.key.compareTo(key);
            if (result == 0) {
                i.key = key;
                i.value = value;
                return;
            }
            else if (result > 0) {
                if (i.left == null) {
                    i.left = new Node(key, value);
                    return;
                }
                i = i.left;
            }
            else {
                if (i.right == null) {
                    i.right = new Node(key, value);
                    return;
                }
                i = i.right;
            }
        }
    }

    public static void main(String[] args) {
        int N = 100;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        BST<Integer, Integer> bst = new BST<>();
        for (int i = 0; i < N; ++i) {
            bst.insert(arr[i], i);
        }
    }
}
