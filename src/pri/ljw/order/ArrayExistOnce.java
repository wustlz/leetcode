package pri.ljw.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Problem_56  数组中数字出现的次数
 *
 * @author liaojinwei
 */
public class ArrayExistOnce {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,4,6};
//        int[] res = singleNumbers(nums);
        int[] res = singleNumbers2(nums);
        for(int i : res) {
            System.out.print("" + i + ",");
        }
    }

    public static int[] singleNumbers(int[] nums) {
        if (nums == null) {
            return null;
        } else if (nums.length == 1) {
            return new int[]{nums[0]};
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] != nums[i + 1]) {
                list.add(nums[i]);
            } else {
                i++;
            }
        }
        if (nums.length == 2) {
            if (nums[0] == nums[1]) {
                return null;
            } else {
                return nums;
            }
        } else {
            if (nums[nums.length - 1] != nums[nums.length - 2] && nums[nums.length - 3] != nums[nums.length - 2]) {
                list.add(nums[nums.length - 2]);
            }
            if (nums[nums.length - 1] != nums[nums.length - 2]) {
                list.add(nums[nums.length - 1]);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static int[] singleNumbers2(int[] nums) {
        // 异或运算，得到a 和 b 的异或结果
        int k = 0;
        for (int i : nums) {
            k ^= i;
        }
        // 找出低位的1
        int mask = 1;
        while ((mask & k) == 0) {
            mask <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int i : nums) {
            if ((i & mask) == 0) {
                // 成对出现的数2次异或运算为0，0与单次出现的数异或运算还是该数
                a ^= i;
            } else {
                b ^= i;
            }
        }
        return new int[]{a, b};
    }
}
