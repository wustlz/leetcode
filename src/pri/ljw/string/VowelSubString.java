package pri.ljw.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * problem_1371 每个元音包含偶数次的最长子字符串
 *
 * @author liaojinwei
 */
public class VowelSubString {

    public static void main(String[] args) {
        VowelSubString main = new VowelSubString();
        String s = "eleetminicoworoep";
        int result = main.findTheLongestSubstring(s);
        System.out.println(result);
        s = "";
        main.updateString(s);
        System.out.println(s);
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int findTheLongestSubstring(String s) {
        int result = 0;
        int state = 0;
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        pos[0] = 0;
        // 通过map存储元音
        Map<Character, Integer> vowel = new HashMap<>();
        vowel.put('a', 1);
        vowel.put('e', 1 << 1);
        vowel.put('i', 1 << 2);
        vowel.put('o', 1 << 3);
        vowel.put('u', 1 << 4);
        for (int i = 0; i < s.length(); i++) {
            Integer v = vowel.get(s.charAt(i));
            if (v != null) {
                state ^= v;
            }
            if (pos[state] >= 0) {
                result = Math.max(result, i + 1 - pos[state]);
            } else {
                pos[state] = i + 1;
            }
        }
        return result;
    }

    public void updateString(String s) {
        s = "abc";
    }
}
