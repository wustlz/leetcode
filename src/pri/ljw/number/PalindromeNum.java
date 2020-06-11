package pri.ljw.number;


/**
 * problem_9 回文数
 *
 * @author liaojinwei
 */
public class PalindromeNum {

    public static void main(String[] args) {
        PalindromeNum main = new PalindromeNum();
        System.out.println(main.isPalindrome(121) + " > " + main.isPalindrome1(121));
//        System.out.println(main.isPalindrome(-121) + " > " + main.isPalindrome1(-121));
//        System.out.println(main.isPalindrome(1231) + " > " + main.isPalindrome1(1231));
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
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

    public boolean isPalindrome1(int x) {
        if (x < 0 || (x > 9 && x % 10 == 0)) {
            return false;
        } else if (x < 10) {
            return true;
        }
        int reverse = 0;
        while (reverse < x) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return x == reverse || x == reverse / 10;
    }
}
