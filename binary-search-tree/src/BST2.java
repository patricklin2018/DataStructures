import java.util.Stack;

/**
 * created by PATRICK
 * 2018/5/30 22:13
 *
 * 二分搜索树
 *
 * 非递归实现
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
     * 插入 (key, value)
     * @param key
     * @param value
     */
    public void insert(Key key, Value value) {

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

    /**
     * 非递归版本
     * 查询二分搜索树是否含有 key 键
     * @param key
     * @return
     */
    public boolean contain(Key key) {
        if (root == null) {
            return false;
        }

        Node i = root;
        while (i != null) {
            int result = i.key.compareTo(key);
            if (result == 0) {
                return true;
            }
            else if (result > 0) {
                i = i.left;
            }
            else {
                i = i.right;
            }
        }

        return false;
    }

    /**
     * 非递归版本
     * 查找 key 键 对应的 value
     * @param key
     * @return 若找不到返回 null
     */
    public Value search(Key key) {
        if (root == null) {
            return null;
        }

        Node i = root;
        while (i != null) {
            int result = i.key.compareTo(key);
            if (result == 0) {
                return i.value;
            }
            else if (result > 0) {
                i = i.left;
            }
            else {
                i = i.right;
            }
        }

        return null;
    }

    /**
     * 非递归前序遍历
     */
    public void preOrder() {

        Stack<Node> stack = new Stack<>();
        Node i = root;

        while (!stack.isEmpty() || i != null) {
            if (i != null) {
                System.out.println(i.value);
                stack.push(i);
                i = i.left;
            }
            else {
                i = stack.pop();
                i = i.right;
            }
        }
    }

    /**
     * 非递归中序遍历
     */
    public void inOrder() {

        Stack<Node> stack = new Stack<>();
        Node i = root;

        while (!stack.isEmpty() || i != null) {

            while (i != null) {
                stack.push(i);
                i = i.left;
            }

            if (!stack.isEmpty()) {
                i = stack.pop();
                System.out.println(i.value);
                i = i.right;
            }
        }
    }

    /**
     * 非递归后序遍历
     */
    public void postOrder() {

        Stack<Node> stack = new Stack<>();
        // 输出辅助栈，记住入栈顺序
        Stack<Node> out = new Stack<>();
        
        Node i = root;

        while (!stack.isEmpty() || i != null) {
            if (i != null) {
                stack.push(i);
                out.push(i);
                i = i.right;
            }
            else {
                i = stack.pop();
                i = i.left;
            }
        }

        while (!out.isEmpty()) {
            System.out.println(out.pop().value);
        }
    }

    public static void main(String[] args) {

        BST2<Integer, Integer> bst = new BST2<>();
        BST<Integer, Integer> bst2 = new BST<>();

        int N = 10;
        int M = 100;
        for(int i = 0 ; i < N ; i ++){
            Integer key = new Integer((int)(Math.random()*M));
            bst.insert(key, key);
            bst2.insert(key, key);
            System.out.print(key + " ");
        }
        System.out.println();

        // 测试二分搜索树的size()
        System.out.println("size: " + bst.size());
        System.out.println();

        // 测试二分搜索树的前序遍历 preOrder
        System.out.println("preOrder: ");
        bst.preOrder();
        System.out.println("递归版本: ");
        bst2.preOrder();

        // 测试二分搜索树的中序遍历 inOrder
        System.out.println("inOrder: ");
        bst.inOrder();
        System.out.println("递归版本: ");
        bst2.inOrder();

        // 测试二分搜索树的后序遍历 postOrder
        System.out.println("postOrder: ");
        bst.postOrder();
        System.out.println("递归版本: ");
        bst2.postOrder();

    }
}
