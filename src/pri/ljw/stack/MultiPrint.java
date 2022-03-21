package pri.ljw.stack;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liaojinwei
 */
public class MultiPrint {

    public volatile static int n = 0;
    public static final int limit = 100;
    public static final int threadSize = 3;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(threadSize);
        for (int threadNo = 0; threadNo < threadSize; threadNo++) {
            int finalThreadNo = threadNo;
            executor.submit(() -> print(finalThreadNo));
        }
        executor.shutdown();
    }

    public static void print(int threadNo) {
        while(n <= limit){
            if (n % threadSize == threadNo && n <= limit) {
                System.out.println(n);
                n++;
            } else {
                Thread.yield();
            }
        }
    }
}
