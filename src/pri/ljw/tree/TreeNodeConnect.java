package pri.ljw.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * problem 117填充每个节点的下一个右侧节点指针 II
 *
 * @author liaojinwei
 */
public class TreeNodeConnect {

    public static void main(String[] args) {
        TreeNodeConnect main = new TreeNodeConnect();

        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node7 = new Node(7);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node7;

//        main.printNode(root);

        int depth = main.treeDepth(root);
        System.out.println(depth);
    }

    public Node connect(Node root) {
        return null;
    }

    public void printNode(Node node) {
        printVal(node);
        List<Node> nexts = new ArrayList<>();
        if (node != null) {
            printVal(node.left);
            printVal(node.right);

            if (node.left != null) {
                nexts.add(node.left);
            }
            if (node.right != null) {
                nexts.add(node.right);
            }
        }
    }

    private void printVal(Node node) {
        if (node != null) {
            System.out.print(node.val + ", ");
        } else {
            System.out.print("#, ");
        }
    }

    private int treeDepth1(Node node) {
        int depth = 0;
        List<Node> nodes = Collections.singletonList(node);

        while (!nodes.isEmpty()) {
            depth++;
            List<Node> tmp = new ArrayList<>();
            nodes.forEach(nd -> {
                if (nd.left != null) {
                    tmp.add(nd.left);
                }
                if (nd.right != null) {
                    tmp.add(nd.right);
                }
            });
            nodes = tmp;
        }
        System.out.println("node.depth=" + depth);
        return depth;
    }

    private int treeDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int left = treeDepth(node.left) + 1;
        int right = treeDepth(node.right) + 1;
        return Math.max(left, right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
