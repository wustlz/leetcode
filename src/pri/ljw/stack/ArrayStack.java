package pri.ljw.stack;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liaojinwei
 */
public class ArrayStack {

    private volatile int[] datas;
    private volatile int length;
    private volatile int size = 0;
    private volatile int minData = Integer.MAX_VALUE;

    private final int defaultCapacity = 10;

    public ArrayStack() {
        datas = new int[defaultCapacity];
        length = defaultCapacity;
    }

    public ArrayStack(int capacity) {
        datas = new int[capacity];
        length = capacity;
    }

    public void push(int num) {
        if (length == size) {
            grow();
        }
        if (minData > num) {
            minData = num;
        }
        this.datas[size++] = num;
    }

    public int pop() throws IllegalAccessException {
        checkData();
        int result = this.datas[0];
        int[] newData = new int[length];
        for (int i = 1; i < length; i++) {
            newData[i - 1] = this.datas[i];
        }
        this.datas = newData;
        return result;
    }

    public int min() throws IllegalAccessException {
        checkData();
        return this.minData;
    }

    private void grow() {
        length >>= 1;
        int[] newData = new int[length];
        for (int i = 0; i < length; i++) {
            newData[i] = this.datas[i];
        }
        this.datas = newData;
    }

    private void checkData() throws IllegalAccessException {
        if (size == 0) {
            throw new IllegalAccessException("There is no data");
        }
    }
}
