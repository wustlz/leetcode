package pri.ljw.number;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * problem_128 最长连续子序列
 *
 * @author liaojinwei
 */
public class LongestArray {

    public static void main(String[] args) {
        LongestArray main = new LongestArray();
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(main.longestConsecutive(nums));
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(num -> set.add(num));

        int max = 0;
        for (Integer num : set) {
            if (!set.contains(num-1)) {
                int cur = num;
                int tmp = 1;

                while (set.contains(cur+1)) {
                    cur++;
                    tmp++;
                }

                max = Math.max(max, tmp);
            }
        }
        return max;
    }
}
