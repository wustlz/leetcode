package pri.ljw.tree;

/**
 * problem_572 另一个树的子树
 *
 * @author liaojinwei
 */
public class SubTreeOfOtherTree {

    public static void main(String[] args) {
        SubTreeOfOtherTree main = new SubTreeOfOtherTree();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4, node1, node2);
        TreeNode node4 = new TreeNode(5);
        TreeNode s = new TreeNode(3, node3, node4);

        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(2);
        TreeNode t = new TreeNode(4, node5, node6);
//
//        String s1 = main.ergodic(t);
//        System.out.println(s1);

        boolean result = main.isSubtree(s, t);
        System.out.println(result);
    }

    /**
     * 时间复杂度 O(s*t)
     * 空间复杂度 O(max{Ds, Dt}) Ds Dt分别表示s和t的深度
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (t == null) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s, t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    private String ergodic(TreeNode node) {
        if (node == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        TreeNode tmp = node.left;
        while  (tmp != null) {
            sb.append(ergodic(tmp));
            tmp = tmp.left;
        }
        tmp = node.right;
        while (tmp != null) {
            sb.append(ergodic(tmp));
            tmp = tmp.right;
        }
        return sb.toString();
    }
}
