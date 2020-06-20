package pri.ljw.number;

/**
 * problem_1014 最佳观光组合
 *
 * @author liaojinwei
 */
public class SightseeingPair {

    public static void main(String[] args) {
        SightseeingPair main = new SightseeingPair();
        int[] A = new int[]{8, 1, 5, 2, 6};
        System.out.println(main.maxScoreSightseeingPair(A));
        System.out.println(main.maxScoreSightseeingPair1(A));
    }

    /**
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    public int maxScoreSightseeingPair(int[] A) {
        if (A == null || A.length < 2) {
            return 0;
        }
        int len = A.length;
        int score = 0;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int tmp = A[i] + A[j] + i - j;
                if (score < tmp) {
                    score = tmp;
                }
            }
        }
        return score;
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int maxScoreSightseeingPair1(int[] A) {
        if (A == null || A.length < 2) {
            return 0;
        }
        int score = 0;
        int pre = A[0];
        for (int i = 1; i < A.length; i++) {
            score = Math.max(score, pre + A[i] - i);
            pre = Math.max(pre, A[i] + i);
        }
        return score;
    }
}
