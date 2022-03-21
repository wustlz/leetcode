package pri.ljw.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 单例
 *
 * @author liaojinwei
 */
public class SingletonInstance {

    private static SingletonInstance instance = null;

    private volatile AtomicBoolean lock = new AtomicBoolean(false);

    public static final Object instanceLock = new Object();

    private SingletonInstance() {}

    public static SingletonInstance getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (SingletonInstance.class) {
            if (instance != null) {
                return instance;
            }
            instance = new SingletonInstance();
            return instance;
        }
    }

    public boolean getLock() {
        return lock.get();
    }

    public synchronized boolean startLock() {
        return this.lock.compareAndSet(false, true);
    }

    public boolean startLock(int threadNo) {
        synchronized (SingletonInstance.class) {
            boolean result = this.lock.compareAndSet(false, true);
            System.out.println("threadNo_" + threadNo + "\t, startLock: " + result);
            return result;
        }
    }

    public boolean unLock() {
        return this.lock.compareAndSet(true, false);
    }
}
