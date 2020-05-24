package pri.ljw.string;

/**
 * problem_5 最长回文子串
 *
 * @author liaojinwei
 */
public class Palindromic {

    public static void main(String[] args) {
        Palindromic main = new Palindromic();
        String s = "babad";
        System.out.println(main.longestPalindrome(s));
    }

    /**
     * 时间复杂度 O(n^3)
     * 空间复杂度 O(1)
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int max = 0;
        String result = "";
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = s.length(); j > 0; j--) {
                if (isPalindromic(s.substring(i, j))) {
                    if (max < (j - i)) {
                        result = s.substring(i, j);
                        max = j - i;
                        break;
                    }
                }
                if (max >= j - i) {
                    break;
                }
            }
            if (s.length() - i <= max) {
                break;
            }
        }
        return result;
    }

    private boolean isPalindromic(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
