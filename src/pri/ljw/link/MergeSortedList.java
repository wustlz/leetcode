package pri.ljw.link;

import java.util.stream.Stream;

/**
 * Problem_23  合并K个有序链表
 *
 * @author liaojinwei
 */
public class MergeSortedList {
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

        ListNode listNode31 = new ListNode(2);
        ListNode listNode32 = new ListNode(6);
        listNode31.next = listNode32;
//        print(listNode11);
//        print(listNode21);
//        print(listNode31);
        ListNode[] listNodes = new ListNode[]{listNode11, listNode21, listNode31};
//        ListNode listNode = mergeKLists1(listNodes);
        ListNode listNode = mergeKLists2(listNodes);
        print(listNode);
    }

    public static ListNode mergeKLists1(ListNode[] lists) {
        ListNode listNode = null;
        ListNode[] cur = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            cur[i] = lists[i];
        }
        while (true) {
            boolean flag = true;
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int i = 0; i < cur.length; i++) {
                if (cur[i] != null) {
                    if (min > cur[i].val) {
                        min = cur[i].val;
                        minIdx = i;
                    }
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            if (listNode == null) {
                listNode = new ListNode(min);
            } else {
                ListNode tmp = listNode;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tmp.next = new ListNode(min);
            }
            cur[minIdx] = cur[minIdx].next;
        }

        return listNode;
    }

    public static ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        return merge2Lists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private static ListNode merge2Lists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 != null ? list1 : list2;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode node1 = list1;
        ListNode node2 = list2;
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

    private static void print(ListNode listNode) {
        ListNode tmp = listNode;
        while (tmp != null) {
            System.out.print(tmp.val + " > ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
