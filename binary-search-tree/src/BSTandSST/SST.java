package BSTandSST;

/**
 * created by PATRICK
 * 2018/5/31 1:01
 *
 * 顺序查找表
 *
 **/

public class SST<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    // 表头
    private Node head;
    private int count;

    public SST(){
        head = null;
        count = 0;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    /**
     * 插入 (key, value)
     * @param key
     * @param value
     */
    public void insert(Key key, Value value){

        // 先查找
        Node node = head;
        while( node != null ){
            if(key.compareTo(node.key) == 0){
                node.value = value;
                return;
            }
            node = node.next;
        }

        // 找不到该元素
        Node newNode = new Node(key, value);
        newNode.next = head;
        head = newNode;
        count ++;
    }

    /**
     * 查询是否存在 key 键
     * @param key
     * @return
     */
    public boolean contain(Key key){
        Node node = head;
        while( node != null ){
            if( key.compareTo(node.key) == 0 )
                return true;
            node = node.next;
        }
        return false;
    }

    /**
     * 搜索 key 对应的 value
     * @param key
     * @return
     */
    public Value search(Key key){

        Node node = head;
        while( node != null ){
            if( key.compareTo(node.key) == 0 )
                return node.value;
            node = node.next;
        }
        return null;
    }

    /**
     * 查出 key 键
     * @param key
     */
    public void remove(Key key){

        if(head == null)
            return;

        if( key.compareTo(head.key) == 0 ){
            Node delNode = head;
            head = head.next;
            delNode.next = null;
            count--;
            return;
        }

        Node node = head;
        while( node.next != null && node.next.key.compareTo(key) != 0 )
            node = node.next;

        if( node.next != null ){
            Node delNode = node.next;
            node.next = delNode.next;
            delNode.next = null;
            count --;
            return;
        }
    }
}
