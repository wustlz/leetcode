package pri.ljw.sum;

import java.util.Arrays;

/**
 * Problem_16 最相近的三数之和
 *
 * @author liaojinwei
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, -1, -1, 3};
        int target = -1;
//        int result = threeSumClosest1(nums, target);
        int result = threeSumClosest2(nums, target);
        System.out.println(result);
    }

    public static int threeSumClosest1(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int diff = Math.abs(sum - target);
                    if (diff == 0) {
                        return sum;
                    } else if (diff < Math.abs(closest - target)) {
                        closest = sum;
                    }
                }
            }
        }
        return closest;
    }

    public static int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i+1;
            int right = nums.length-1;
            while (true) {
                if (left >= right) {
                    break;
                }
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(sum - target);
                if (sum == target) {
                    return sum;
                } else if (diff < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (target < sum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return closest;
    }
}
