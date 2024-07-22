package cn.zliangcheng.linklist;

public class InsertCycle {
    public ListNode insert(ListNode head, int insertVal) {
        ListNode cur = new ListNode(insertVal);
        if (head == null) {
            head = cur;
            head.next = cur;
        } else if (head.next == head) {
            head.next = cur;
            cur.next = head;
        } else {
            insertCycle(head, cur);
        }

        return head;
    }

    public ListNode insertCycle(ListNode head, ListNode insertNode) {
        ListNode pre = head;
        ListNode after = head.next;
        ListNode biggest = head;

        while (!(pre.val <= insertNode.val && after.val >= insertNode.val) && after != head) {
            pre = pre.next;
            after = after.next;
            if (pre.val >= biggest.val) {
                biggest = pre;
            }
        }

        if (pre.val <= insertNode.val && after.val >= insertNode.val) {
            pre.next = insertNode;
            insertNode.next = after;
        } else {
            insertNode.next = biggest.next;
            biggest.next = insertNode;
        }

        return head;
    }
}
