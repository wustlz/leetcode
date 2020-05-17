package pri.ljw.link;

/**
 * problem_25 K个一组翻转链表
 *
 * @author liaojinwei
 */
public class ReverseKListNode {

    public static void main(String[] args) {
        ReverseKListNode main = new ReverseKListNode();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

//        ListNode.printNode(main.reverse(node1, node3));

        ListNode.printNode(main.reverseKGroup(node1, 3));
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode start = node.next;
        ListNode cur = node.next;
        ListNode pre = node;
        ListNode tail = null;
        int idx = 0;
        while (cur != null) {
            tail = cur.next;
            idx++;
            if (idx % k == 0) {
                ListNode temp = reverse(start, tail);
                pre.next = temp;
                pre = start;
                start = tail;
                cur = tail;
            } else {
                cur = cur.next;
            }
        }
        return node.next;
    }

    /**
     * 就地反转
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node.next;
        ListNode after = pre.next;
        while(after != null && after != tail) {
            pre.next = after.next;
            after.next = node.next;
            node.next = after;
            after = pre.next;
        }
        return node.next;
    }
}
