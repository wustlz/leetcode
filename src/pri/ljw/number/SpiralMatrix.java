package pri.ljw.number;

import java.util.Arrays;

/**
 * problem_29 顺时针打印矩阵
 *
 * @author liaojinwei
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix main = new SpiralMatrix();

        int[][] matrix = new int[3][4];
        matrix[0] = new int[]{1, 2, 3, 4};
        matrix[1] = new int[]{5, 6, 7, 8};
        matrix[2] = new int[]{9, 10, 11, 12};

        int[] result = main.spiralOrder(matrix);
        for (int num : result) {
            System.out.println(num);
        }
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int[] spiralOrder(int[][] matrix) {
        int height = matrix.length;
        if (height < 1) {
            return new int[0];
        }
        int width = matrix[0].length;
        int size = width * height;
        int[] result = new int[size];
        int left = 0, right = width - 1, top = 0, bottom = height - 1;
        int index = 0;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }
            for (int i = top + 1; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    result[index++] = matrix[bottom][i];
                }
                for (int i = bottom - 1; i > top; i--) {
                    result[index++] = matrix[i][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }
}
