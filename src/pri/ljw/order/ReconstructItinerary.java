package pri.ljw.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * problem 332
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 *
 *
 * @author liaojinwei
 */
public class ReconstructItinerary {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
//        tickets.add(Arrays.asList("MUC", "LHR"));
//        tickets.add(Arrays.asList("JFK", "MUC"));
//        tickets.add(Arrays.asList("SFO", "SJC"));
//        tickets.add(Arrays.asList("LHR", "SFO"));

        tickets.add(Arrays.asList("JFK","SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));

        ReconstructItinerary main = new ReconstructItinerary();
        List<String> itinerary = main.findItinerary(tickets);

        itinerary.forEach(System.out::println);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();

        tickets.forEach(ticket -> {
            String from = ticket.get(0);
            List<String> list = map.getOrDefault(from, new ArrayList<>());
            list.add(ticket.get(1));
            map.put(from, list);
        });

        for(Map.Entry<String, List<String>> m : map.entrySet()) {
            List<String> list = m.getValue();
            if (list.size() > 1) {
                Collections.sort(list);
            }
        }

        List<String> itinerary = new ArrayList<>();

        dfs("JFK", map, itinerary);
        Collections.reverse(itinerary);
        return itinerary;
    }

    private void dfs(String from, Map<String, List<String>> map, List<String> itinerary) {
        while (map.containsKey(from) && map.get(from).size() > 0) {
            String next = map.get(from).get(0);
            map.get(from).remove(0);
            dfs(next, map, itinerary);
        }
        itinerary.add(from);
    }
}
