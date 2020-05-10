package pri.ljw.number;

/**
 * 二维数组最大正方形
 *
 * @author liaojinwei
 */
public class MaxSquare {

    public static void main(String[] args) {
        MaxSquare main = new MaxSquare();
        char[][] matrix = new char[4][5];
        matrix[0] = new char[]{'1', '0', '1', '0', '0'};
        matrix[1] = new char[]{'1', '0', '1', '1', '1'};
        matrix[2] = new char[]{'1', '1', '1', '1', '1'};
        matrix[3] = new char[]{'1', '0', '0', '1', '0'};
        int square = main.maximalSquare(matrix);
        System.out.println(square);
    }

    /**
     * 时间复杂度 O(m*n*(min{m,n})^2)
     * 空间复杂度 O(1)
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int width = matrix[0].length;
        int height = matrix.length;
        int square = 0;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (matrix[row][col] == '1') {
                    square = Math.max(square, 1);
                    int cur = Math.min(height - row, width - col);
                    for (int k = 1; k < cur; k++) {
                        boolean flag = true;
                        if (matrix[row + k][col + k] == '0') {
                            break;
                        }
                        for (int i = 0; i < k; i++) {
                            if (matrix[row + k][col + i] == '0' || matrix[row + i][col + k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            square = Math.max(square, k + 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return square * square;
    }
}
