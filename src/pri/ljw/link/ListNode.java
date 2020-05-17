package pri.ljw.link;

/**
 * @author lz
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        this.val  = x;
        this.next = next;
    }

    public static void printNode(ListNode node) {
        ListNode cur = node;
        while (cur != null) {
            System.out.print(cur.val + " > ");
            cur = cur.next;
        }
        System.out.println();
    }
}
