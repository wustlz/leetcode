package pri.ljw.number;

/**
 * problem_287 寻找重复数
 *
 * @author liaojinwei
 */
public class DuplicateNumber {

    public static void main(String[] args) {
        DuplicateNumber main = new DuplicateNumber();
        int[] nums = new int[]{1, 3, 4, 2, 2};
        int result = main.findDuplicate(nums);
        System.out.println(result);
    }

    /**
     * 时间复杂度 O(nlogn)
     * 空间复杂度 O(nlogn)
     */
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1;
        int result = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= mid) {
                    cnt ++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                result = mid;
            }
        }
        return result;
    }
}
