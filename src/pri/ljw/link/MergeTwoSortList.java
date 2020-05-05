package pri.ljw.link;

/**
 * 合并2个有序链表
 *
 * @author lz
 */
public class MergeTwoSortList {

    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(4);
        ListNode listNode13 = new ListNode(5);
        listNode11.next = listNode12;
        listNode12.next = listNode13;

        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(3);
        ListNode listNode23 = new ListNode(4);
        listNode21.next = listNode22;
        listNode22.next = listNode23;

        ListNode listNode = mergeTwoLists(listNode11, listNode21);
        MergeSortedList.print(listNode);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode node1 = l1;
        ListNode node2 = l2;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                tail.next = node1;
                node1 = node1.next;
            } else {
                tail.next = node2;
                node2 = node2.next;
            }
            tail = tail.next;
        }
        tail.next = node1 == null ? node2 : node1;
        return head.next;
    }
}
