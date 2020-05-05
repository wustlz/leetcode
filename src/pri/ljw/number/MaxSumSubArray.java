package pri.ljw.number;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * @author lz
 */
public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray1(nums);
        System.out.println(result);
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static int maxSubArray1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = nums[0];
        int pre = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (pre < 0) {
                pre = nums[i];
            } else {
                pre += nums[i];
            }
            if (result < pre) {
                result = pre;
            }
        }
        return result;
    }
}
