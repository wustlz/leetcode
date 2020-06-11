package pri.ljw.string;

/**
 * problem_46 数字转字符串
 *
 * @author liaojinwei
 */
public class Num2String {

    public static void main(String[] args) {
        Num2String main = new Num2String();
        int num = 12258;
        System.out.println(main.translateNum(num));
    }

    /**
     * 滚动数组
     *
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int f1 = 0, f2 = 0;
        int result = 1;

        for (int i = 0; i < str.length(); i++) {
            f1 = f2;
            f2 = result;
            if (i == 0) {
                continue;
            }
            String pre = str.substring(i - 1, i + 1);
            if (pre.compareTo("10") >= 0 && pre.compareTo("25") <= 0) {
                result += f1;
            }
        }
        return result;
    }
}
