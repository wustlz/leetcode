package pri.ljw.math;

/**
 * problem_69 x的平方根
 *
 * @author liaojinwei
 */
public class Sqrtx {

    public static void main(String[] args) {
        Sqrtx main = new Sqrtx();
        int x = 2;
        int s = main.mySqrt1(x);
        System.out.println(s);
    }


    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        return  (int) Math.sqrt(x);
    }

    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
//        int result =
        return 0;
    }
}
