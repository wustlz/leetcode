package pri.ljw.number;

/**
 * problem_983 最低票价
 *
 * @author liaojinwei
 */
public class MinCostForTickets {

    public static void main(String[] args) {
        MinCostForTickets main = new MinCostForTickets();

//        int[] days = new int[]{1, 4, 6, 7, 8, 20};
        int[] days = new int[]{1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = new int[]{2, 7, 15};
        int result = main.mincostTickets(days, costs);
        System.out.println(result);
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int mincostTickets(int[] days, int[] costs) {
        int[] saleDays = new int[]{1, 7, 30};
        Integer[] dps = new Integer[days.length];
        return dp(0, dps, costs, saleDays, days);
    }

    private int dp(int i, Integer[] dps, int[] costs, int[] saleDays, int[] days) {
        if (i >= days.length) {
            return 0;
        }
        if (dps[i] != null) {
            return dps[i];
        }
        dps[i] = Integer.MAX_VALUE;
        int j = i;
        for (int k = 0; k < costs.length; k++) {
            while(j < days.length && days[j] < days[i] + saleDays[k]) {
                j++;
            }
            dps[i] = Math.min(dps[i], dp(j, dps, costs, saleDays, days) + costs[k]);
        }
        return dps[i];
    }
}
