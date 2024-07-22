package cn.zliangcheng.linklist;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        ListNode inCycle = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                inCycle = slow;
                break;
            }
        }

        if (inCycle != null) {
            ListNode cur = dummy;
            while (cur != inCycle) {
                cur = cur.next;
                inCycle = inCycle.next;
            }

            return inCycle;
        }

        return null;
    }
}
