package pri.ljw.number;

/**
 * problem_837 新21点
 *
 * @author liaojinwei
 */
public class New21Game {

    public static void main(String[] args) {
        New21Game main = new New21Game();
        System.out.println(main.new21Game(10, 1, 10));
    }

    public double new21Game(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        double[] dp = new double[K + W];
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
        dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
        for (int i = K - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        }
        return dp[0];
    }
}
