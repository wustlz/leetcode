package pri.ljw.number;

/**
 * problem_152 乘积最大子数组
 *
 * @author liaojinwei
 */
public class MaxProductSubArray {

    public static void main(String[] args) {
        MaxProductSubArray main = new MaxProductSubArray();
//        int[] nums = new int[]{2, 3, -2, 4};
        int[] nums = new int[]{-3, 0, 1, -2};
//        int max = main.maxProduct1(nums);
        int max = main.maxProduct2(nums);
        System.out.println(max);
    }

    /**
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    public int maxProduct1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                if (product >= max) {
                    max = product;
                }
            }
        }
        return max;
    }

    /**
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    public int maxProduct2(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = max, mn = min;
            max = Math.max(mx * nums[i], Math.max(mn * nums[i], nums[i]));
            min = Math.min(mn * nums[i], Math.min(mx * nums[i], nums[i]));
            ans = Math.max(max, ans);
        }
        return ans;
    }
}
