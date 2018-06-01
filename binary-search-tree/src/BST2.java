import java.util.LinkedList;
import java.util.Queue;
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

        public Node (Node newNode) {
            this.key = newNode.key;
            this.value = newNode.value;
            this.left = newNode.left;
            this.right = newNode.right;
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
            counter++;
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
                    counter++;
                    return;
                }
                i = i.left;
            }
            else {
                if (i.right == null) {
                    i.right = new Node(key, value);
                    counter++;
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
     * @return 最小键值的节点
     */
    public Node minimum() {
        return minimum(root);
    }

    public Node minimum(Node node) {
        assert counter > 0;

        Node i = node;
        while (true) {
            if (i.left == null) {
                return i;
            }
            i = i.left;
        }
    }

    /**
     * @return 最大键值的节点
     */
    public Node maximum() {
        assert counter > 0;

        Node i = root;
        while (true) {
            if (i.right == null) {
                return i;
            }
            i = i.right;
        }
    }

    /**
     * 删除最小键值的节点
     */
    public Node removeMin() {
        return removeMin(root);
    }

    /**
     * 删除以 node 为根节点的最小键值的节点
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (root == null) {
            return null;
        }

        Node i = node;
        Node parent = null;
        while (true) {
            if (i.left == null) {
                Node right =  i.right;
                i.right = null;
                counter--;
                if (parent != null) {
                    parent.left = right;
                    return node;
                }
                else {
                    return right;
                }
            }
            parent = i;
            i = i.left;
        }
    }

    /**
     * 删除二分搜索树中最大键值的节点
     */
    public Node removeMax(Node node) {
        if (root == null) {
            return null;
        }

        Node i = node;
        Node parent = null;
        while (true) {
            if (i.right == null) {
                Node left = i.left;
                i.left = null;
                counter--;
                if (parent != null) {
                    parent.right = left;
                    return node;
                }
                else {
                    return left;
                }
            }
            parent = i;
            i = i.right;
        }
    }

    /**
     * 删除键值为 key 的节点
     * @param key
     */
    public void remove(Key key) {
        if (root == null) {
            return;
        }

        Node i = root;
        Node parent = null;

        while (i != null) {
            int result = i.key.compareTo(key);
            if (result > 0) {
                parent = i;
                i = i.left;
            }
            else if (result < 0) {
                parent = i;
                i = i.right;
            }
            else {
                if (i.left == null) {
                    Node right = i.right;
                    i.right = null;
                    counter--;
                    concatenate(parent, i.key, right);
                    return;
                }
                else if (i.right == null) {
                    Node left = i.left;
                    i.left = null;
                    counter--;
                    concatenate(parent, i.key, left);
                    return;
                }
                else {
                    Node succesor = new Node(minimum(i.right));

                    succesor.left = i.left;
                    succesor.right = removeMin(i.right);

                    i.left = i.right = null;

                    concatenate(parent, i.key, succesor);

                    return;
                }
            }
        }
    }

    /**
     * 传入父子两个节点，父节点根据 key 值比较情况，选择将子节点挂在其父节点的左右
     * 如果 parent 为空，则 root = son
     */
    private void concatenate(Node parent, Key key, Node son) {
        if (parent != null) {
            if (parent.key.compareTo(key) > 0) {
                parent.left = son;
            }
            else {
                parent.right = son;
            }
        }
        else {
            root = son;
        }
    }

    // 测试
    public static void main(String[] args) {

        BST2<Integer, Integer> bst = new BST2<>();

        int N = 10000;
        // Integer[] testAry = {9, 4, 3, 6, 1, 7};
        for(int i = 0 ; i < N ; i ++){
            Integer key = new Integer((int)(Math.random()*N));
        //  Integer key = testAry[i];
            bst.insert(key, key);
        }

        Integer order[] = new Integer[N];
        for( int i = 0 ; i < N ; i ++ )
            order[i] = new Integer(i);
        // Integer[] order = {3, 4, 6, 7, 9, 1};

        // 打乱order数组的顺序
        for(int i = order.length-1 ; i >= 0 ; i --){
            int pos = (int) (Math.random() * (i+1));
            int t = order[pos];
            order[pos] = order[i];
            order[i] = t;
        }

        System.out.println("Initial order:");
        bst.levelOrder();
        System.out.println("Initial size = " + bst.size() );

        // 乱序删除[0...n)范围里的所有元素
        for( int i = 0 ; i < N ; i ++ )
            if( bst.contain( order[i] )){
                bst.remove( order[i] );
                System.out.println("After remove " + order[i] + " size = " + bst.size() );
                //bst.levelOrder();
            }

        // 最终整个二分搜索树应该为空
        System.out.println("size = " + bst.size());

    }
}
