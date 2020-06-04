package pri.ljw.number;

/**
 * problem_64 求n的累加, 不能使用乘除法、for、while、if、else、switch、case等关键字，条件表达式
 *
 * @author liaojinwei
 */
public class SumForN {
    public static void main(String[] args) {
        SumForN main = new SumForN();
        System.out.println(main.sumNums(5));
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int sumNums(int n) {
        boolean tmp = n > 0 && (n += sumNums(n-1)) > 0;
        return n;
    }
}
