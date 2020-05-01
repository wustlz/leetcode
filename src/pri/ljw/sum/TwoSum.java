package pri.ljw.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem_1  两数之和
 *
 * @author liaojinwei
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 5, 15};
        int target = 9;
//        int[] result = twoSum1(nums, target);
        int[] result = twoSum2(nums, target);
        System.out.println(result[0] + ", " + result[1]);
    }

    /**
     * 两次遍历
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 通过map
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
