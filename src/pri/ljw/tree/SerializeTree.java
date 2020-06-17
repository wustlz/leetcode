package pri.ljw.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * problem_297 二叉树的序列化与反序列化
 *
 * @author liaojinwei
 */
public class SerializeTree {

    public static void main(String[] args) {
        SerializeTree main = new SerializeTree();
        String data = "1,2,3,null,null,4,5,null,null,null,null";
        TreeNode resT = main.deserialize(data);
        System.out.println(resT);
        String resS = main.serialize(resT);
        System.out.println(resS);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return reSerialize(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ss = data.split(",");
        return reDeserialize(new LinkedList<>(Arrays.asList(ss)));
    }

    /**
     * 前序遍历
     */
    private String reSerialize(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += root.val + ",";
            str = reSerialize(root.left, str);
            str = reSerialize(root.right, str);
        }
        return str;
    }

    /**
     * 按照前序遍历结果解析树
     */
    private TreeNode reDeserialize(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        } else if ("null".equals(list.get(0))) {
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        if (!list.isEmpty()) {
            node.left = reDeserialize(list);
        }
        if (!list.isEmpty()) {
            node.right = reDeserialize(list);
        }
        return node;
    }
}
