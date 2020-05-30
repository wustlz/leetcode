package pri.ljw.number;

/**
 * problem_84 柱状图中的最大矩阵面积
 *
 * @author liaojinwei
 */
public class LargestRectangle {

    public static void main(String[] args) {
        LargestRectangle main = new LargestRectangle();
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(main.largestRectangleArea(heights));
    }

    /**
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null) {
            return 0;
        }
        int result = 0;
        int len = heights.length;

        for (int i = 0; i < len; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                result = Math.max(result, (j - i + 1) * minHeight);
            }
        }
        return result;
    }
}
