package pri.ljw.math;

/**
 * problem_70 爬楼梯
 *
 * @author liaojinwei
 */
public class ClimbStair {

    public static void main(String[] args) {
        ClimbStair main = new ClimbStair();
        System.out.println(main.climbStairs2(2));
        System.out.println(main.climbStairs2(3));
    }

    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int climbStairs1(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int p = 1, q = 2;
        int idx = 3;

        while (idx++ < n) {
            int tmp = p;
            p = q;
            q += tmp;
        }
        return p + q;
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int climbStairs2(int n) {
        int p = 0, q = 0, r = 1;

        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }

        return r;
    }
}
