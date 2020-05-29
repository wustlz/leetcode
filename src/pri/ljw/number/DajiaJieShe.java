package pri.ljw.number;

/**
 * problem_198 打家劫舍
 *
 * @author liaojinwei
 */
public class DajiaJieShe {

    public static void main(String[] args) {
        DajiaJieShe main = new DajiaJieShe();
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(main.rob(nums));
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int[] cost = new int[len];
        cost[0] = nums[0];
        cost[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            cost[i] = Math.max(cost[i - 1], nums[i] + cost[i - 2]);
        }
        return cost[len - 1];
    }
}
