package pri.ljw.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * problem_102 二叉树的层序遍历
 *
 * @author liaojinwei
 */
public class BinaryTreeLeverOrder {

    public static void main(String[] args) {
        BinaryTreeLeverOrder main = new BinaryTreeLeverOrder();

        TreeNode node1 = new TreeNode(15);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(20, node1, node2);
        TreeNode node4 = new TreeNode(9);
        TreeNode root = new TreeNode(3, node4, node3);
        List<List<Integer>> result = main.levelOrder(root);
        result.forEach(list -> {
            list.forEach(integer -> System.out.print(integer + ", "));
            System.out.println();
        });
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<TreeNode> preTree = Arrays.asList(root);

        while (!preTree.isEmpty()) {
            List<Integer> detail = new ArrayList<>();
            List<TreeNode> tmp = new ArrayList<>();
            preTree.forEach(treeNode -> {
                if (treeNode != null) {
                    detail.add(treeNode.val);
                    if (treeNode.left != null) {
                        tmp.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        tmp.add(treeNode.right);
                    }
                }
            });
            preTree = tmp;
            list.add(detail);
        }
        return list;
    }
}
