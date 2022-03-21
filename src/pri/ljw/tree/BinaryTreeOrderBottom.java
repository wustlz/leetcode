package pri.ljw.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * problem_107 二叉树的遍历
 *
 * @author liaojinwei
 */
public class BinaryTreeOrderBottom {

    public static void main(String[] args) {

        BinaryTreeOrderBottom main = new BinaryTreeOrderBottom();

        TreeNode node1 = new TreeNode(15);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(20, node1, node2);
        TreeNode node4 = new TreeNode(9);
        TreeNode root = new TreeNode(3, node4, node3);
        List<List<Integer>> result = main.levelOrderBottom(root);
        result.forEach(list -> {
            list.forEach(integer -> System.out.print(integer + ", "));
            System.out.println();
        });
    }

    /**
     * 时间复杂度 O(n)

     * 空间复杂度 O(n)
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        List<TreeNode> curNodes = Arrays.asList(root);

        while (!curNodes.isEmpty()) {
            List<Integer> data = new ArrayList<>();
            List<TreeNode> next = new ArrayList<>();

            curNodes.forEach(treeNode -> {
                data.add(treeNode.val);
                if (treeNode.left != null) {
                    next.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    next.add(treeNode.right);
                }
            });

            list.add(0, data);
            curNodes = next;
        }

        return list;
    }
}
