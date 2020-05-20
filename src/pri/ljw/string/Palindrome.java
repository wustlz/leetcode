package pri.ljw.string;

/**
 * problem_680 回文字符串
 *
 * @author liaojinwei
 */
public class Palindrome {

    public static void main(String[] args) {
        Palindrome main = new Palindrome();
        String s = "abca";
        boolean result = main.validPalindrome(s);
        System.out.println(result);
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public boolean validPalindrome1(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }
            boolean flag1 = true, flag2 = true;
            for (int i = left, j = right - 1; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    flag1 = false;
                    break;
                }
            }
            for (int i = left + 1, j = right; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    flag2 = false;
                    break;
                }
            }
            return flag1 || flag2;
        }
        return true;
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    int del = 0;
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            } else if (del == 0) {
                del++;
                return validPalindrome(s.substring(left, right))
                        || validPalindrome(s.substring(left + 1, right + 1));
            }
            return false;
        }
        return true;
    }
}
