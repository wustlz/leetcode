package pri.ljw.string;

import java.util.LinkedList;

/**
 * problem_394 字符串解码
 *
 * @author liaojinwei
 */
public class DecodeString {

    public static void main(String[] args) {
        DecodeString main = new DecodeString();
        String s = "3[a]2[bc]";
        System.out.println(main.decodeString(s));
    }

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        LinkedList<Integer> digits = new LinkedList<>();
        LinkedList<String> chars = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + Integer.parseInt(c.toString());
            } else if (c == '[') {
                digits.addLast(num);
                chars.addLast(sb.toString());
                num = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int numTmp = digits.removeLast();
                for (int i = 0; i < numTmp; i++) {
                    tmp.append(sb);
                }
                sb = new StringBuilder(chars.removeLast() + tmp);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
