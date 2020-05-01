package pri.ljw.query;

/**
 * ClassName: FindMedianSortedArrays
 * Description: 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *              找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))
 *
 * @author liaojinwei
 * @date 2020/2/1 12:27 上午
 **/
public class FindMedianSortedArrays {
    public static void main(String[] args) {

        FindMedianSortedArrays main = new FindMedianSortedArrays();

        int[] nums1 = {1, 3};
        int[] nums2 = {4};

        main.findMedianSortedArrays(nums1, nums2);
    }

    double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return calculateMedian(nums2);
        }
        if (nums2 == null || nums2.length == 0) {
            return calculateMedian(nums1);
        }
        int length1 = nums1.length;
        int length2 = nums2.length;
        return 0.0d;
    }

    double calculateMedian(int[] array) {
        int length = array.length;
        int idx = length / 2;
        if (length % 2 == 0) {
            return (array[idx] + array[idx+1]) / 2.0;
        }
        return array[idx];
    }

}
