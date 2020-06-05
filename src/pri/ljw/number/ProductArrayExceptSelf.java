package pri.ljw.number;

/**
 * problem_238 除自身以外数组的乘积
 *
 * @author liaojinwei
 */
public class ProductArrayExceptSelf {

    public static void main(String[] args) {
        ProductArrayExceptSelf main = new ProductArrayExceptSelf();
        int[] nums = new int[]{1, 2, 3, 4};
        int[] result = main.productExceptSelf(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        result[0] = 1;
        // left
        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        // right
        int r = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] = result[i] * r;
            r *= nums[i];
        }
        return result;
    }
}
