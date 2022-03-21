package pri.ljw.string;

import java.util.HashMap;
import java.util.Map;

/**
 * problem 567 字符串的排列
 *
 * @author liaojinwei
 */
public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidboaoo"));
        System.out.println(check("ab", "eidboaoo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> ori = new HashMap<>();
        for (char c : s1.toCharArray()) {
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> target = new HashMap<>(ori.size());
        int right = 0, left = 0, check = 0;
        int len = s2.length();

        while (right < len) {
            char c = s2.charAt(right++);
            ori.put(c, ori.getOrDefault(c, 0) - 1);
            if (left < right && ori.get(c) < 0) {
                char cr = s2.charAt(left++);
                ori.put(cr, ori.getOrDefault(cr, 0) + 1);
            }
            if (right - left == s1.length()) {
                return true;
            }
        }

        return false;
    }

    public static boolean check(String s1, String s2) {
        char[] chars = s1.toCharArray();
        Map<Character, Integer> map = new HashMap();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        chars = s2.toCharArray();
        int l = 0, r = 0;
        while (r < s2.length()) {
            char c = chars[r++];
            map.put(c, map.getOrDefault(c, 0) - 1);
            while (l < r && (!map.containsKey(c) || map.get(c) < 0)) {
//                map.computeIfPresent(chars[l++], (k, v) -> v + 1);
                char cr = chars[l++];
                map.put(cr, map.getOrDefault(cr, 0) + 1);
            }
            if (r - l == s1.length()) return true;

        }
        return false;
    }
}
