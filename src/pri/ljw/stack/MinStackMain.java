package pri.ljw.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * problem_155 最小栈
 *
 * @author liaojinwei
 */
public class MinStackMain {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(395);
        int min = minStack.getMin();
        System.out.println(min);
        int top = minStack.top();
        System.out.println(top);
        min = minStack.getMin();
        System.out.println(min);
        minStack.push(276);
        minStack.push(29);
        min = minStack.getMin();
        System.out.println(min);
        minStack.push(-482);
        min = minStack.getMin();
        System.out.println(min);
        minStack.pop();
        minStack.push(-108);
        minStack.push(-251);
        min = minStack.getMin();
        System.out.println(min);
        minStack.push(-439);
        top = minStack.top();
        System.out.println(top);
        minStack.push(370);
        minStack.pop();
        minStack.pop();
        min = minStack.getMin();
        System.out.println(min);
    }
}

class MinStack {
    /**
     * initialize your data structure here.
     */
    private final List<Integer> list;
    private int minIndex;
    private int head;

    public MinStack() {
        this.list = new ArrayList<>();
        this.minIndex = -1;
        this.head = -1;
    }

    public void push(int x) {
        list.add(x);
        head++;
        if (minIndex == -1) {
            minIndex = 0;
        } else if (list.get(minIndex) > x) {
            minIndex = head;
        }
    }

    public void pop() {
        if (head ==  0) {
            list.clear();
            minIndex = -1;
            head = -1;
        } else if (head > 0) {
            list.remove(head);
            if (minIndex == head) {
                minIndex = 0;
                for (int i = 1; i < head; i++) {
                    if (list.get(minIndex) > list.get(i)) {
                        minIndex = i;
                    }
                }
            }
            head--;
        }
    }

    public Integer top() {
        if (head == -1) {
            return null;
        }
        return list.get(head);
    }

    public Integer getMin() {
        if (minIndex == -1) {
            return null;
        }
        return list.get(minIndex);
    }
}