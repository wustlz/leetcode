package pri.ljw.tree;

/**
 * problem_236 二叉树的最近公共祖先
 *
 * @author liaojinwei
 */
public class AncestorOfBinaryTree {

    private static TreeNode ancestor = null;

    public static void main(String[] args) {
        AncestorOfBinaryTree main = new AncestorOfBinaryTree();

        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2, node1, node2);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node4, node3);

        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(1, node6, node7);

        TreeNode root = new TreeNode(3, node5, node8);

        main.lowestCommonAncestor(root, node5, node8);
        System.out.println(ancestor.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ancestor;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        boolean son = root.val == p.val || root.val == q.val;
        if ((lson && rson) || (son && (lson || rson))) {
            ancestor = root;
        }
        return lson || rson || son;
    }
}
