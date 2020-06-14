package pri.ljw.number;

/**
 * problem_739 每日温度
 *
 * @author liaojinwei
 */
public class DailyTemperature {

    public static void main(String[] args) {
        DailyTemperature main = new DailyTemperature();
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = main.dailyTemperatures(T);

        for (int i : res) {
            System.out.print(" > " + i);
        }
    }

    public int[] dailyTemperatures(int[] T) {
        if (T == null) {
            return new int[0];
        }
        int len = T.length;
        int[] result = new int[len];

        for (int i = 0; i < len - 1; i++) {
            int idx = 1;
            for (int j = i + 1; j < len; j++) {
                if (T[j] > T[i]) {
                    result[i] = idx;
                    break;
                }
                idx++;
            }
        }
        result[len - 1] = 0;
        return result;
    }
}
