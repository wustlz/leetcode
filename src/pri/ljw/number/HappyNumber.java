package pri.ljw.number;

import java.util.HashSet;
import java.util.Set;

/**
 * problem_202 happy number
 *
 * @author liaojinwei
 */
public class HappyNumber {

    public static void main(String[] args) {
        int n = 130;
//        boolean result = isHappy1(n);
        boolean result2 = isHappy2(n);
        boolean result3 = isHappy3(n);
        System.out.println(result2 + ", " + result3);
    }

    /**
     * 时间复杂度 O(log n)
     * 空间复杂度 O(log n)
     */
    private static boolean isHappy1(int n) {
        Set<Integer> set = new HashSet<>();
        int tmp = n;
        while (true) {
            int sum = 0;
            char[] chars = ("" + tmp).toCharArray();
            for (char c : chars) {
                sum += Math.pow((int) c - 48, 2);
            }
            if (sum == 1) {
                return true;
            } else if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            tmp = sum;
            System.out.println(sum);
        }
    }

    /**
     * 时间复杂度 O(log n)
     * 空间复杂度 O(log n)
     */
    private static boolean isHappy2(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    /**
     * 时间复杂度 O(log n)
     * 空间复杂度 O(1)
     */
    private static boolean isHappy3(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && fast != slow) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private static int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }
}
