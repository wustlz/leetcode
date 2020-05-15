package pri.ljw.number;

/**
 * problem_136 只出现一次的数字
 *
 * @author liaojinwei
 */
public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber main = new SingleNumber();
        int[] nums = new int[]{4,1,2,1,2};
        int result = main.singleNumber(nums);
        System.out.println(result);
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }
}
