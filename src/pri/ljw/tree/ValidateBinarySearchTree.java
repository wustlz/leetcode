package pri.ljw.tree;

/**
 * problem_98 判断是否是一个有效的二叉搜索树
 *
 * @author liaojinwei
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        ValidateBinarySearchTree main = new ValidateBinarySearchTree();

        TreeNode root = new TreeNode(5);
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(4);
        TreeNode right11 = new TreeNode(3);
        TreeNode right12 = new TreeNode(6);

        root.left = left1;
        root.right = right1;
        right1.left = right11;
        right1.right = right12;

        boolean result = main.isValidBST(root);
        System.out.println(result);
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }

    private boolean valid(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!valid(node.right, val, upper)) {
            return false;
        }
        if (!valid(node.left, lower, val)) {
            return false;
        }
        return true;
    }
}
