package pri.ljw.string;

import java.util.HashMap;
import java.util.Map;

/**
 * problem_76 最小覆盖子串
 *
 * @author liaojinwei
 */
public class MinSubString {

    public static void main(String[] args) {
        MinSubString main = new MinSubString();
        String s = "ADOBECODEBANC";
        String t = "ABC";
//        String s = "A";
//        String t = "AA";
//        String result = main.minWindow(s, t);
//        String result = main.minWindow1(s, t);
//        System.out.println(result);
        System.out.println(minWindow3(s, t));
    }

    public static String minWindow3(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> ori = new HashMap<>();
        for (char c : t.toCharArray()) {
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int len = s.length();
        int left = 0, right = 0, check = 0;
        int min = Integer.MAX_VALUE, start = 0;
        Map<Character, Integer> target = new HashMap<>(ori.size());
        while (right < len) {
            char c = s.charAt(right++);
            if (ori.get(c) != null) {
                Integer tmp = target.getOrDefault(c, 0) + 1;
                target.put(c, tmp);
                if (tmp.equals(ori.get(c))) {
                    check++;
                }
            }
            while (check == ori.size()) {
                if (min > right - left) {
                    min = right - left;
                    start = left;
                }
                char cr = s.charAt(left++);
                if (ori.get(cr) != null) {
                    if (target.get(cr).equals(ori.get(cr))) {
                        check--;
                    }
                    target.put(cr, target.get(cr) - 1);
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }

    /**
     * 时间复杂度 O(ns^2+nt)
     * 空间复杂度 O(nt)
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> ts = new HashMap<>();
        for (char c : t.toCharArray()) {
            Integer cnt = ts.getOrDefault(c, 0);
            ts.put(c, cnt + 1);
        }
        int len = s == null ? 0 : s.length();
        int size = ts.size();
        if (len < size) {
            return "";
        }
        int min = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i < len; i++) {
            if (ts.get(s.charAt(i)) != null) {
                Map<Character, Integer> tmp = new HashMap<>();
                int cur = 0;
                for (int j = i; j < len; j++) {
                    if (min < j - i + 1) {
                        break;
                    }
                    char c = s.charAt(j);
                    Integer cnt = ts.get(c);
                    if (cnt != null) {
                        Integer tmpCnt = tmp.getOrDefault(c, 0);
                        tmp.put(c,  tmpCnt + 1);
                        if (tmpCnt + 1 == cnt) {
                            cur++;
                        }
                        if (cur == ts.size()) {
                            if (min > (j - i + 1)) {
                                result = s.substring(i, j + 1);
                                min = j - i + 1;
                            }
                        }
                    }
                }
            }
            if (min == size) {
                break;
            }
        }
        return result;
    }

    /**
     *
     */
    public String minWindow1(String s, String t) {
        if (s == null || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> ori = new HashMap<>();
        for (char c : t.toCharArray()) {
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> com = new HashMap<>(ori.size());
        int len = s.length();
        int min = Integer.MAX_VALUE;
        int start = 0;
        int l = 0, r = 0, valid = 0;
        while (r < len) {
            // 移右指针
            char cr = s.charAt(r);
            r++;
            if (ori.get(cr) != null) {
                Integer tmp = com.getOrDefault(cr, 0) + 1;
                com.put(cr, tmp);
                if (tmp.equals(ori.get(cr))) {
                    valid++;
                }
            }
            // 移动左指针
            while (valid == ori.size()) {
                if (min > r - l) {
                    min = r - l;
                    start = l;
                }
                char cl = s.charAt(l);
                l++;
                if (ori.get(cl) != null) {
                    if (com.get(cl).equals(ori.get(cl))) {
                        valid--;
                    }
                    com.put(cl, com.get(cl) - 1);
                }
            }

        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
