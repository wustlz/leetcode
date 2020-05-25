package pri.ljw.link;

import java.util.HashMap;
import java.util.Map;

/**
 * problem_146 LRU缓存机制
 *
 * @author liaojinwei
 */
public class LRUCache {

    class LruNode {
        int key;
        int value;
        LruNode pre;
        LruNode next;

        public LruNode(){
        }

        public LruNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, LruNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private LruNode head;
    private LruNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new LruNode();
        tail = new LruNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        LruNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        move2Head(node);
        return node.value;
    }

    public void put(int key, int value) {
        LruNode node = cache.get(key);
        if (node == null) {
            node = new LruNode(key, value);
            cache.put(key, node);
            add2Head(node);
            size++;
            if (size > capacity) {
                LruNode tmpTail = removeTail();
                cache.remove(tmpTail.key);
                size--;
            }
        } else {
            node.value = value;
            move2Head(node);
        }
    }

    private void add2Head(LruNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(LruNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void move2Head(LruNode node) {
        removeNode(node);
        add2Head(node);
    }

    private LruNode removeTail() {
        LruNode node = tail.pre;
        removeNode(node);
        return node;
    }
}
