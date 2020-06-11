package pri.ljw.string;

import java.util.*;

/**
 * problem_126 单词接龙
 *
 * @author liaojinwei
 */
public class WordLadder {

    public static void main(String[] args) {
        WordLadder main = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> result = main.findLadders(beginWord, endWord, wordList);
        for (List<String> list : result) {
            if (list != null) {
                for (String word : list) {
                    System.out.print(word + ", ");
                }
            }
            System.out.println();
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) {
                return new ArrayList<>(0);
            }
            // 将word转为map
            Map<String, Integer> wordId = new HashMap<>(wordList.size());
            // 去除重复的word，index与wordId的value保持一致
            List<String> idWord = new ArrayList<>();
            int id = 0;
            for (String word : wordList) {
                if (!wordId.containsKey(word)) {
                    wordId.put(word, id++);
                    idWord.add(word);
                }
            }
            if (!wordId.containsKey(beginWord)) {
                wordId.put(beginWord, id);
                idWord.add(beginWord);
            }

            // 构建边
            int size = idWord.size();
            List<List<Integer>> edges = new ArrayList<>(size);
            // 边权重
            int[] cost = new int[size];
            for (int i = 0; i < size; i++) {
                edges.add(new ArrayList<>());
                cost[i] = Integer.MAX_VALUE;
            }
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (canLadder(idWord.get(i), idWord.get(j))) {
                        edges.get(i).add(j);
                        edges.get(j).add(i);
                    }
                }
            }

            int target = wordId.get(endWord);
            List<List<String>> result = new ArrayList<>();

            Queue<List<Integer>> queue = new LinkedList<>();
            List<Integer> begin = new ArrayList<>();
            begin.add(wordId.get(beginWord));
            queue.add(begin);
            cost[wordId.get(beginWord)] = 0;

            while (!queue.isEmpty()) {
                List<Integer> cur = queue.poll();
                int last = cur.get(cur.size() - 1);
                if (last == target) {
                    List<String> tmp = new ArrayList<>();
                    for (int idx : cur) {
                        tmp.add(idWord.get(idx));
                    }
                    result.add(tmp);
                } else {
                    for (int i = 0; i < edges.get(last).size(); i++) {
                        int to = edges.get(last).get(i);
                        if (cost[last] + 1 <= cost[to]) {
                            cost[to] = cost[last] + 1;
                            List<Integer> tmp = new ArrayList<>(cur);
                            tmp.add(to);
                            queue.add(tmp);
                        }
                    }
                }
            }

            return result;
    }

    /**
     * 判断next是否可以接在str后
     */
    private boolean canLadder(String str, String next) {
        int diff = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != next.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }
}
