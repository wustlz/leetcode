package pri.ljw.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4数之和
 *
 * @author liaojinwei
 */
public class FourSum {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
//        int[] nums = new int[]{0, 0, 0, 0};
        int[] nums = new int[]{-5, -4, -3, -2, -1, 0, 0, 1, 2, 3, 4, 5};
        int target = 0;
        List<List<Integer>> result = fourSum(nums, target);
        ThreeSum.print(result);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 4; i++) {
            for (int j = i + 1; j <= nums.length - 3; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                while (true) {
                    if (left >= right) {
                        break;
                    }
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        result.add(list);
                        while (left + 1 < nums.length && nums[left] == nums[++left]) {}
                        while (right > 0 && nums[right] == nums[--right]) {}
                    } else if (sum < target) {
                        while (left + 1 < nums.length && nums[left] == nums[++left]) {}
                    } else {
                        while (right > 0 && nums[right] == nums[--right]) {}
                    }
                }
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }
}
