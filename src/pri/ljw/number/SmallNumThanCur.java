package pri.ljw.number;

import java.util.stream.Stream;

/**
 * problem_1365 有多少小于当前数字的数字
 *
 * @author liaojinwei
 */
public class SmallNumThanCur {

    public static void main(String[] args) {
        SmallNumThanCur main = new SmallNumThanCur();
        int[] nums = new int[]{8, 1, 2, 2, 3};
        int[] result = main.smallerNumbersThanCurrent(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }

    /**
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(n^2)
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null) {
            return new int[0];
        }
        int len = nums.length;
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            int tmp = 0;
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] > nums[j]) {
                    tmp++;
                }
            }
            result[i] = tmp;
        }
        return result;
    }
}
