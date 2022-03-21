package pri.ljw.link;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liaojinwei
 */
public class LruCacheThreadSafe<K, V> {

    // 最大容量
    private int capacity = 100;

    // 存储缓存
    private ConcurrentHashMap<K, V> cache;

    // 单链表存储key，头节点表示最久未使用，尾节点为最近使用
    private ConcurrentLinkedQueue<K> queue;

    // 读写锁控制线程安全
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    public LruCacheThreadSafe(int capacity) {
        this();
        this.capacity = capacity;
    }

    public LruCacheThreadSafe() {
        cache = new ConcurrentHashMap<>();
        queue = new ConcurrentLinkedQueue<>();
    }

    public V get(K key) {
        readLock.lock();
        try {
            V value = cache.get(key);
            if (value != null) {
                // 更新 当前节点到尾部
                queue.remove(key);
                queue.add(key);
            }
            return value;
        } finally {
            readLock.unlock();
        }
    }

    public V put(K key, V value) {
        writeLock.lock();
        try {
            if (cache.containsKey(key)) {
                queue.remove(key);
            } else if (cache.size() >= capacity) {
                // 超过最大容量, 移除头部元素
                K oldest = queue.poll();
                if (oldest != null) {
                    cache.remove(oldest);
                }
            }
            cache.put(key, value);
            queue.add(key);
            return value;
        } finally {
            writeLock.unlock();
        }
    }

    public V remove(K key) {
        writeLock.lock();
        try {
            V value = cache.get(key);
            if (value != null) {
                cache.remove(key);
                queue.remove(key);
            }
            return value;
        } finally {
            writeLock.unlock();
        }
    }

}
