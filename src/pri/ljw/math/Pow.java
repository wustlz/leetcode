package pri.ljw.math;

/**
 * problem_50 pow(x, n)
 *
 * @author liaojinwei
 */
public class Pow {

    public static void main(String[] args) {
        Pow pow = new Pow();
//        double result = pow.myPow(2, -2);
        double result = pow.myPow2(2, -2147483648);
        System.out.println(result);
    }

    public double myPow(double x, int n) {
        return n < 0 ? 1.0 / mul(x, -n) : mul(x, n);
    }

    private double mul(double x, long t) {
        if (t == 0) {
            return 1.0;
        }
        double y = mul(x, t >> 1);
        return t % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow2(double x, int n) {
        /*if (n == 0) {
            return 1.0;
        }
        long t = n < 0 ? -n : n;
        double result = 1.0;
        double a = x;
        while (t > 0) {
            if (t % 2 == 1) {
                result *= a;
            }
            a *= a;
            t = t >> 1;
        }
        return n < 0 ? 1.0 / result : result;*/
        long t = n;
        return t >= 0 ? mul2(x, t) : 1.0 / mul2(x, -t);
    }

    private double mul2(double x, long t) {
        double result = 1.0;
        double a = x;
        while (t > 0) {
            if (t % 2 == 1) {
                result *= a;
            }
            a *= a;
            t >>= 1;
        }
        return result;
    }
}
