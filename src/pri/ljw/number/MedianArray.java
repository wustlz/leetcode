package pri.ljw.number;

/**
 * problem_4 2个有序数组的中位数
 *
 * @author lz
 */
public class MedianArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        double median = findMedianSortedArrays1(nums1, nums2);
        System.out.println(median);
    }

    /**
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(m+n)
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0) {
            if (len2 % 2 == 0) {
                return (nums2[len2 / 2 - 1] + nums2[len2 / 2]) / 2.0;
            } else {
                return nums2[len2 / 2];
            }
        } else if (len2 == 0) {
            if (len1 % 2 == 0) {
                return (nums1[len1 / 2 - 1] + nums1[len1 / 2]) / 2.0;
            } else {
                return nums1[len1 / 2];
            }
        }
        int[] all = new int[len1 + len2];
        int i = 0, j = 0, index = 0;
        while (index < len1 + len2) {
            if (i == len1) {
                while (j != len2) {
                    all[index++] = nums2[j++];
                }
                break;
            }
            if (j == len2) {
                while (i != len1) {
                    all[index++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                all[index++] = nums1[i++];
            } else {
                all[index++] = nums2[j++];
            }
        }
        if (index % 2 == 0) {
            return (all[index / 2 - 1] + all[index / 2]) / 2.0;
        } else {
            return all[index / 2];
        }
    }

    /**
     * 时间复杂度：O(m+n)
     * 空间复杂度：O()
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        return 0.0;
    }

    /**
     * 时间复杂度：O()
     * 空间复杂度：O()
     */
    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        return 0.0;
    }
}
