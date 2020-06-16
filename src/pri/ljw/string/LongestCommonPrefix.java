package pri.ljw.string;

/**
 * problem_14  最长公共前缀
 * lz
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix main = new LongestCommonPrefix();
        System.out.println(main.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(main.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(main.longestCommonPrefix(new String[]{"abab", "aba", ""}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String result = "";
        int idx = 0;
        String str = strs[0];
        if (str.length() == 0) {
            return result;
        }
        while (true) {
            char c = str.charAt(idx);
            boolean end = false;
            boolean append = true;
            for (String s : strs) {
                if (idx < s.length()) {
                    if (c != s.charAt(idx)) {
                        append = false;
                    }
                } else {
                    append = false;
                }
                if (idx == s.length() - 1) {
                    end = true;
                }
            }
            if (append) {
                result += c;
            }
            if (!append || end) {
                return result;
            }
            idx++;
        }
    }
}
