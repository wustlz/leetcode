package pri.ljw.query;

/**
 * 山脉数组
 *
 * @author liaojinwei
 */
public class MountainArray {
    private int[] array;

    public MountainArray(int[] array) {
        this.array = array;
    }

    private void setArray(int[] array) {
        this.array = array;
    }

    public int get(int index) {
        return array[index];
    }

    public int length() {
        return array.length;
    }
}
