package pri.ljw.string;

/**
 * @author liaojinwei
 */
public class ReverseString {

    public static void main(String[] args) {
        ReverseString main = new ReverseString();
        System.out.println(main.reverseStr("hello  world  java"));
        System.out.println(main.checkOddNumber(33));
        System.out.println(main.checkOddNumber(66));
    }

    public String reverseStr(String s) {
        String[] ss = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = ss.length - 1; i>=1; i--) {
            sb.append(ss[i]).append(" ");
        }
        sb.append(ss[0]);
        return sb.toString();
    }

    public boolean checkOddNumber(int num) {
        return (num &= 1) == 1;
    }
}
