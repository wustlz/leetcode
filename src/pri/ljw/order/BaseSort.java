package pri.ljw.order;

import java.util.Arrays;

/**
 * ClassName: BaseSort
 * Description: 基本排序.
 *
 * @author liaojinwei
 * @date 2020/2/1 12:40 上午
 **/
public class BaseSort {
    public static void main(String[] args) {
        BaseSort main = new BaseSort();
        int[] array = {3, 44 ,38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        main.printArray(array, "Original Array");
        int[] bubbleArray = main.bubbleSort(array.clone());
        main.printArray(bubbleArray, "1st bubble sort");
        int[] selectArray = main.selectionSort(array.clone());
        main.printArray(selectArray, "2nd selection sort");
        int[] heapArray = main.heapSort(array.clone());
        main.printArray(heapArray, "3rd Heap Array");
        int[] mergeArray = main.mergeSort(array.clone());
        main.printArray(mergeArray, "4th Merge Array");
        int[] quickArray = main.quickSort(array.clone(), 0, array.length-1);
        main.printArray(quickArray, "5th Quick Array");
        int[] shellArray = main.shellSort(array.clone());
        main.printArray(shellArray, "6th Shell Array");
        int[] insertArray = main.insertionSort(array.clone());
        main.printArray(insertArray, "7th insert Array");
    }

    /**
     * 打印数组.
     * @param array
     */
    void printArray(int[] array, String arrayName) {
        System.out.println("---- " + arrayName + " ----");
        for (int a : array) {
            System.out.print(a);
            System.out.print(", ");
        }
        System.out.println();
    }

    /**
     * 冒泡排序.重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
     * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
     * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
     * 最佳情况：T(n) = O(n)
     * 最差情况：T(n) = O(n2)
     * 平均情况：T(n) = O(n2)
     *
     * @param array
     * @return
     */
    int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 选择排序.首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，
     * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     * 最佳情况：T(n) = O(n2)
     * 最差情况：T(n) = O(n2)
     * 平均情况：T(n) = O(n2)
     *
     * @param array
     * @return
     */
    int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                // 找到最小的数
                if (array[j] < array[minIndex]) {
                    // 将最小数的索引保存
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * 插入排序。通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。插入排序在实现上，通常采用in-place排序
     * （即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     * 最佳情况：T(n) = O(n)
     * 最坏情况：T(n) = O(n2)
     * 平均情况：T(n) = O(n2)
     *
     * @param array
     * @return
     */
    int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    /**
     * 希尔排序.把记录按下表的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，
     * 当增量减至1时，整个文件恰被分成一组，算法便终止。
     * 最佳情况：T(n) = O(nlog2 n)
     * 最坏情况：T(n) = O(nlog2 n)
     * 平均情况：T(n) = O(nlog2 n)
     *
     * @param array
     * @return
     */
    int[] shellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    /**
     * 归并排序。建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
     * 归并排序是一种稳定的排序方法。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
     * 若将两个有序表合并成一个有序表，称为2-路归并。
     * 最佳情况：T(n) = O(n)
     * 最差情况：T(n) = O(nlogn)
     * 平均情况：T(n) = O(nlogn)
     *
     * @param array
     * @return
     */
    int[] mergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }

    /**
     * 快速排序。通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，
     * 则可分别对这两部分记录继续进行排序，以达到整个序列有序。
     * 最佳情况：T(n) = O(nlogn)
     * 最差情况：T(n) = O(n2)
     * 平均情况：T(n) = O(nlogn)
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    int[] quickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) {
            return null;
        }
        int smallIndex = partition(array, start, end);
        if (smallIndex > start) {
            quickSort(array, start, smallIndex - 1);
        }
        if (smallIndex < end) {
            quickSort(array, smallIndex + 1, end);
        }
        return array;
    }
    /**
     * 快速排序算法——partition
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex) {
                    swap(array, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }

    /**
     * 交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 堆排序。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
     */
    int len;
    int[] heapSort(int[] array) {
        len = array.length;
        if (len < 1) {
            return array;
        }
        //1.构建一个最大堆
        buildMaxHeap(array);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }
    /**
     * 建立最大堆
     *
     * @param array
     */
    private void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始向上构造最大堆
        //for循环这样写会更好一点：i的左子树和右子树分别2i+1和2(i+1)
        for (int i = (len/2- 1); i >= 0; i--) {
            adjustHeap(array, i);
        }
    }
    /**
     * 调整使之成为最大堆
     *
     * @param array
     * @param i
     */
    private void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 < len && array[i * 2] > array[maxIndex]) {
            maxIndex = i * 2;
        }
        // 如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex]) {
            maxIndex = i * 2 + 1;
        }
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }
}
