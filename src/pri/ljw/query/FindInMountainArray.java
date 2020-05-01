package pri.ljw.query;

/**
 * 山脉数组中查找目标值
 *
 * @author liaojinwei
 */
public class FindInMountainArray {

    public static void main(String[] args) {
//        int[] array = new int[]{1, 2, 3, 4, 5, 3, 1};
        int[] array = new int[]{1, 5, 2};
        MountainArray mountainArray = new MountainArray(array);
        int target = 0;
        int index = findInMountainArray(target, mountainArray);
        System.out.println(index);
    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        // 1、首先找到山顶元素
        int left = 0;
        int right = mountainArr.length() - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int peak = left;
        // 先找左边的
        int index = binarySearch(mountainArr, target, 0, peak, true);
        if (index != -1) {
            return index;
        }
        // 未找到，则再找右边的
        return binarySearch(mountainArr, target, peak, mountainArr.length(), false);
    }

    private static int binarySearch(MountainArray mountainArray, int target, int left, int right, boolean isAsc) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (mid >= mountainArray.length()) {
                break;
            }
            if (mountainArray.get(mid) == target) {
                return mid;
            } else if (mountainArray.get(mid) < target) {
                if (isAsc) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (isAsc) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
