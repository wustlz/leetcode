package pri.ljw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author frank
 * @date 2023/2/20
 */
public class P2347BestPokerHand {

    public static void main(String[] args) {
        P2347BestPokerHand main = new P2347BestPokerHand();
//        int[] ranks = {13,2,3,1,9};
//        char[] suits = {'a','a','a','a','a'};
        int[] ranks = {10,10,2,12,9};
        char[] suits = {'a','b','c','a','d'};
        System.out.println(main.bestHand(ranks, suits));
    }

    public String bestHand(int[] ranks, char[] suits) {
        Map<Integer, Integer> rankMap = new HashMap<>();
        int maxRankCount = 1;
        for (int rank : ranks) {
            Integer count = rankMap.getOrDefault(rank, 0);
            count++;
            if (maxRankCount < count) {
                maxRankCount = count;
            }
            rankMap.put(rank, count);
        }
        
        Map<Character, Integer> suitMap = new HashMap<>();
        for (char suit : suits) {
            Integer count = suitMap.getOrDefault(suit, 0);
            suitMap.put(suit, count + 1);
        }
        
        if (suitMap.size() == 1) {
            // 同花
            return "Flush";
        } else if (maxRankCount >= 3) {
            // 三条
            return "Three of a Kind";
        } else if (maxRankCount == 1) {
            // 高牌
            return "High Card";
        } else {
            // 对子
            return "Pair";
        }
    }
}
