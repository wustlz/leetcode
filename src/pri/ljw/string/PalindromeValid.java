package pri.ljw.string;

/**
 * problem_125 验证回文串
 *
 * @author liaojinwei
 */
public class PalindromeValid {

    public static void main(String[] args) {
        PalindromeValid main = new PalindromeValid();
        System.out.println(main.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(main.isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        if (null == s) {
            return false;
        } else if ("".equals(s.trim())) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
