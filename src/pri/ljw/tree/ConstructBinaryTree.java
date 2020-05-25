package pri.ljw.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * problem_105 从前序和中序遍历序列构造二叉树
 *
 * @author liaojinwei
 */
public class ConstructBinaryTree {

    public static void main(String[] args) {
        ConstructBinaryTree main = new ConstructBinaryTree();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = main.buildTree(preorder, inorder);
        System.out.println(root);
    }

    private Map<Integer, Integer> map;

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length < 1 || inorder == null || inorder.length < 1) {
            return null;
        }
        int size = inorder.length;
        map = new HashMap<>(size);
        for (int i = 0; i < size; i++) {
            map.put(inorder[i], i);
        }
        return subBuildTree(preorder, inorder, 0, size - 1, 0, size - 1);
    }

    private TreeNode subBuildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        // 中序根节点index
        int inRoot = map.get(preorder[preLeft]);

        // 根节点
        TreeNode root = new TreeNode(preorder[preLeft]);
        int leftSize = inRoot - inLeft;
        root.left = subBuildTree(preorder, inorder, preLeft + 1, preLeft + leftSize, inLeft, inRoot - 1);
        root.right = subBuildTree(preorder, inorder, preLeft + leftSize + 1, preRight, inRoot + 1, inRight);
        return root;
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inIndex]) {
                node.left = new TreeNode(preVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inIndex]) {
                    stack.pop();
                    inIndex++;
                }
                node.right = new TreeNode(preVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
