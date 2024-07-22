package cn.zliangcheng.linklist;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode endHalf = slow.next;
        slow.next = null;
        link(head, reverseList(endHalf), dummyHead);
    }

    private void link(ListNode startHalf, ListNode endHalf, ListNode head) {
        ListNode pre = head;
        while (endHalf != null && startHalf != null) {
            ListNode next = startHalf.next;
            pre.next = startHalf;
            startHalf.next = endHalf;
            pre = endHalf;

            startHalf = next;
            endHalf = endHalf.next;
        }

        if (startHalf != null) {
            pre .next = startHalf;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
