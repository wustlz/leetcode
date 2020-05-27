package pri.ljw.number;

import java.util.HashMap;
import java.util.Map;

/**
 * problem_974 和可被 K 整除的子数组
 *
 * @author liaojinwei
 */
public class SubArrayForDivisible {

    public static void main(String[] args) {
        SubArrayForDivisible main = new SubArrayForDivisible();
        int[] A = new int[]{4,5,0,-2,-3,1};
        int K = 5;
//        int result = main.subarraysDivByK(A, K);
        int result = main.subarraysDivByK1(A, K);
        System.out.println(result);
    }

    /**
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    public int subarraysDivByK(int[] A, int K) {
        int result = 0;
        if (K == 0 || A == null || A.length == 0) {
            return result;
        }
        int len = A.length;

        int sum = 0;
        for (int i = 0; i < len; i++ ) {
            sum = 0;
            for (int j = i; j < len; j++) {
                sum += A[j];
                if (sum % K == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 思路：
     *      p[i] = A[0] + ... + A[i]
     *      sum{i, j} = p[j] - p[i-1]
     *      sum{i, j} % K = (p[j] - p[i-1]) % K == 0
     *          ==> p[j] % K == p[i - 1] % K
     *      记 Map<Key, Value>, Key = 1, 2, ... , min{n, k}, 表示 %K 的值集合, value为出现次数
     *      加和value即为总子数组数
     * 时间复杂度 O(n)
     * 空间复杂度 O(min{n, K})
     */
    public int subarraysDivByK1(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int result = 0, sum = 0;
        for (int a : A) {
            sum += a;
            int mod = sum % K;
            if (mod < 0) {
                mod += K;
            }
            int tmp = map.getOrDefault(mod, 0);
            result += tmp;
            map.put(mod, tmp + 1);
        }
        return result;
    }
}
