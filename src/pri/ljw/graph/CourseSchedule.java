package pri.ljw.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * problem_210 课程表
 *
 * @author liaojinwei
 */
public class CourseSchedule {

    /**
     * 存储边.
     * 外层List的index对应节点.
     * 内层List的值对应节点.
     */
    private List<List<Integer>> edges;

    /**
     * 判断是否访问，0-未访问，1-访问中，2-已完成，据此判断是否成环.
     */
    private int[] visited;

    /**
     * 判断是否成环，true-是，false-否
     */
    private boolean invalid;

    /**
     * 存储结果栈的节点index.
     */
    private int index;

    /**
     * 结果栈.
     */
    private int[] order;

    public static void main(String[] args) {
        CourseSchedule main = new CourseSchedule();
        int numCourses = 4;
        int[][] prerequisites = new int[4][2];
        prerequisites[0] = new int[]{1, 0};
        prerequisites[1] = new int[]{2, 0};
        prerequisites[2] = new int[]{3, 1};
        prerequisites[3] = new int[]{3, 2};
        int[] result = main.findOrder(numCourses, prerequisites);
        for (int i : result) {
            System.out.print(i + " > ");
        }
    }

    /**
     * 时间复杂度 O(n + m)，其中 nn 为课程数，mm 为先修课程的要求数
     * 空间复杂度 O(n + m)，其中 nn 为课程数，mm 为先修课程的要求数
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 初始化边
        edges = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            edges.get(edge[1]).add(edge[0]);
        }
        // 初始化结果栈 访问记录数组
        visited = new int[numCourses];
        index = numCourses - 1;
        order = new int[numCourses];
        invalid = false;

        // 开始深度遍历
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (invalid) {
            return new int[0];
        }

        return order;
    }

    /**
     * 深度优先遍历
     *
     * @param u 节点
     */
    private void dfs(int u) {
        visited[u] = 1;

        // 遍历相邻节点
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                // 未遍历，递归进行深度遍历
                dfs(v);
                // 存在环
                if (invalid) {
                    return;
                }
            } else if (visited[v] == 1) {
                // 遍历中，存在环
                invalid = true;
                return;
            }
        }
        // 遍历结束后，将当前节点置为2并放入栈中，已完成
        visited[u] = 2;
        order[index--] = u;
    }
}
