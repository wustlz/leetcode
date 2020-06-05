package pri.ljw.number;

import java.util.ArrayList;
import java.util.List;

/**
 * problem_1431 拥有最多糖果的孩子
 *
 * @author liaojinwei
 */
public class KidsWithGreatestCandies {

    public static void main(String[] args) {
        KidsWithGreatestCandies main = new KidsWithGreatestCandies();
        int[] candies = new int[]{4,2,1,1,2};
        int extraCandies = 1;
        List<Boolean> list = main.kidsWithCandies(candies, extraCandies);
        for (Boolean b : list) {
            System.out.println(b);
        }
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies == null) {
            return new ArrayList<Boolean>(0);
        }
        int max = Integer.MIN_VALUE;
        for (int i : candies) {
            if (max < i) {
                max = i;
            }
        }
        List<Boolean> list = new ArrayList<>(candies.length);
        for (int i : candies) {
            if (i + extraCandies < max) {
                list.add(false);
            } else {
                list.add(true);
            }
        }
        return list;
    }
}
