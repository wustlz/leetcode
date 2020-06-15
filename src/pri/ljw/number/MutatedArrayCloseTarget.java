package pri.ljw.number;

import java.util.Arrays;

/**
 * problem_1300 转变数组后最接近目标值的数组和
 *
 * @author liaojinwei
 */
public class MutatedArrayCloseTarget {

    public static void main(String[] args) {
        MutatedArrayCloseTarget main = new MutatedArrayCloseTarget();
//        System.out.println(main.findBestValue(new int[]{4, 9, 3}, 10));
        System.out.println(main.findBestValue(new int[]{2, 3, 5}, 11));
//        System.out.println(main.findBestValue(new int[]{60864, 25176, 27249, 21296, 20204}, 56803));
    }

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
        int[] sumArr = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i - 1];
        }
        int left = 0;
        int right = arr[len - 1];
        int result = -1;
        int smallSum = 0;
        int bigIdx = 0;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int idx = Arrays.binarySearch(arr, mid);
            if (idx < 0) {
                idx = -idx - 1;
            }
            int cur = sumArr[idx] + (len - idx) * mid;
            if (cur <= target) {
                result = mid;
                left = mid + 1;
                smallSum = cur;
                bigIdx = idx;
            } else {
                right = mid - 1;
            }
        }
        int bigSum = sumArr[bigIdx];
        for (int i = bigIdx; i < len; i++) {
            if (arr[i] < result + 1) {
                bigSum += arr[i];
            } else {
                bigSum += (result + 1) * (len - i);
                break;
            }
        }
        return Math.abs(smallSum - target) <= Math.abs(bigSum - target) ? result : result + 1;
    }
}
