package pri.ljw.number;

import java.util.HashMap;
import java.util.Map;

/**
 * problem_560 和为K的子数组
 *
 * @author liaojinwei
 */
public class SubArrayEqualK {

    public static void main(String[] args) {
        SubArrayEqualK main = new SubArrayEqualK();
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
//        int result = main.subarraySum(nums, k);
        int result = main.subarraySum2(nums, k);
        System.out.println(result);
    }

    /**
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * 思路：
     *  sum[i] = sum[i-1]+nums[i]
     *  对[j, ... , i] = sum[i] - sum[j-1] = k
     *  sum[j-1] = sum[i] - k
     */
    public int subarraySum2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i : nums) {
            sum += i;
            if (map.containsKey(sum - k)) {
                result += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
