package pri.ljw.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem_3 无重复的最长子串
 *
 * @author lz
 */
public class NoRepeatLongestStr {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(|B|) |B|表示最长子串长度
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> characters = new HashSet<>();
        int len = s.length();
        int rk = -1;
        int result = 0;

        for (int i = 0; i < len; i++) {
            if (i != 0) {
                characters.remove(s.charAt(i - 1));
            }
            while (rk < len - 1 && !characters.contains(s.charAt(rk + 1))) {
                characters.add(s.charAt(rk + 1));
                rk++;
            }
            if (result < characters.size()) {
                result = characters.size();
            }
        }
        return result;
    }
}
