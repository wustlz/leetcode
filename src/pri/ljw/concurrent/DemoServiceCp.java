package pri.ljw.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * demo
 *
 * @author liaojinwei
 */
public class DemoServiceCp {

    private final static Object lock = new Object();

    public static void main(String[] args) {
        SingletonInstance instance = SingletonInstance.getInstance();
        DemoServiceCp main = new DemoServiceCp();
        List<Integer> threadNos = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threadNos.add(i);
        }

        threadNos.parallelStream().forEach(threadNo -> {
            synchronized (SingletonInstance.class) {
                main.method(threadNo);
            }
            /*while (!instance.startLock(threadNo)) {
                main.method(threadNo);
                instance.unLock();
            }*/
        });
    }

    private void method(int threadNo) {
        try {
            Thread.sleep(5000);
            System.out.println("COPY_ThreadNo >>> " + threadNo + "\t, time: " + System.currentTimeMillis()
                    + ", lock: " + SingletonInstance.getInstance().getLock());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
