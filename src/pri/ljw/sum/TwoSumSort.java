package pri.ljw.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem_167  有序数组的2数之和
 *
 * @author liaojinwei
 */
public class TwoSumSort {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 13};
        int target = 9;
//        int[] result = twoSum1(nums, target);
//        int[] result = twoSum2(nums, target);
        int[] result = twoSum3(nums, target);
        System.out.println(result[0] + ", " + result[1]);
    }

    /**
     * 暴力破解，2遍循环
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    public static int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i+1, j+1};
                }
            }
        }
        return null;
    }

    /**
     * hash，1遍循环
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public static int[] twoSum2(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(target-numbers[i]) != null) {
                return new int[]{map.get(target-numbers[i])+1, i+1};
            }
            map.put(numbers[i], i);
        }
        return null;
    }

    /**
     * 双指针，1遍循环
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static int[] twoSum3(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left+1, right+1};
            } else if (sum < target) {
                while (left < numbers.length - 1 && numbers[left] == numbers[++left]){}
            } else if (sum > target) {
                while (right > 0 && numbers[right] == numbers[--right]){}
            }
        }
        return null;
    }
}
