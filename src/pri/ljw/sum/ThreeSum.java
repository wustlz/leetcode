package pri.ljw.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem_15 3数之和
 *
 * @author liaojinwei
 */
public class ThreeSum {
    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums = new int[]{0, 0, 0};
//        List<List<Integer>> result = threeSum1(nums);
        List<List<Integer>> result = threeSum2(nums);
        print(result);
    }

    /**
     * 3次遍历，但超时
     * 时间复杂度 O(n^3)
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0 && i != j && i != k && j != k) {
                        String key = nums[i] + "_" + nums[j] + "_" + nums[k];
                        if (set.contains(key)) {
                            continue;
                        }
                        set.add(key);
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 双指针法
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (true) {
                if (left >= right) {
                    break;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                    result.add(list);
                    while (left + 1 < nums.length && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right - 1 >= 0 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void print(List<List<Integer>> list) {
        list.forEach(l -> {
            l.forEach(i -> System.out.print(i + ", "));
            System.out.println();
        });
    }
}
