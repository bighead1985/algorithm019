import java.util.HashMap;
import java.util.Map;

/**
 * Description: LRU缓存实现
 * User: liqing
 * Date: 2020-12-27
 * Time: 3:21 PM
 */
public class LRUCache {

    /**
     * 双向链表节点
     */
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    /**
     * 定义成员变量
     */
    private Map<Integer, Node> cache = new HashMap<Integer, Node>();
    private int size;
    private int capacity;
    private Node head, tail;

    /**
     * 构造方法
     */
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        //移动到链表的头部
        moveToHead(node);
        return node.value;

    }


    public void put(int key, int value) {

        Node node;
        if (!cache.containsKey(key)) {
            node = new Node(key, value);
            cache.put(key, node);
            addToHead(node);
            ensureCapacity();
        } else {
            node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }
    }

    private Node removeTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void ensureCapacity() {
        if (size + 1 > capacity) {
            cache.remove(removeTail().key);
        } else {
            size++;
        }
    }

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        lruCache.get(2);
        lruCache.put(3, 2);

    }

}
