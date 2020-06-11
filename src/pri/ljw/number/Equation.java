package pri.ljw.number;

import java.util.*;

/**
 * problem_990 等式方程的可满足性
 *
 * @author liaojinwei
 */
public class Equation {

    public static void main(String[] args) {
        Equation main = new Equation();
        String[] equations = new String[]{"a==b", "b!=a"};
        String[] equations1 = new String[]{"b==a","a==b"};
        String[] equations2 = new String[]{"a==b","b==c","a==c"};
        String[] equations3 = new String[]{"a==b","b!=c","c==a"};
        String[] equations4 = new String[]{"c==c","b==d","x!=z"};
        String[] equations5 = new String[]{"c!=c"};
        String[] equations6 = new String[]{"a==b","e==c","b==c","a!=e"};
        System.out.println(main.equationsPossible(equations));
        System.out.println(main.equationsPossible(equations1));
        System.out.println(main.equationsPossible(equations2));
        System.out.println(main.equationsPossible(equations3));
        System.out.println(main.equationsPossible(equations4));
        System.out.println(main.equationsPossible(equations5));
        System.out.println(main.equationsPossible(equations6));
    }

    public boolean equationsPossible(String[] equations) {
        int len = equations.length;
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int idx1 = eq.charAt(0) - 'a';
                int idx2 = eq.charAt(3) - 'a';
                union(parent, idx1, idx2);
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                if (eq.charAt(0) == eq.charAt(3)) {
                    return false;
                }
                int idx1 = eq.charAt(0) - 'a';
                int idx2 = eq.charAt(3) - 'a';
                if (find(parent, idx1) == find(parent, idx2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void union(int[] parent, int idx1, int idx2) {
        parent[find(parent, idx1)] = find(parent, idx2);
    }

    private int find(int[] parent, int idx) {
        while (parent[idx] != idx) {
            parent[idx] = parent[parent[idx]];
            idx = parent[idx];
        }
        return idx;
    }
}
