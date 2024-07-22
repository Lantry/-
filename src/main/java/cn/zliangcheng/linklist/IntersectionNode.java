package cn.zliangcheng.linklist;

public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1 = count(headA);
        int count2 = count(headB);
        int delta = Math.abs(count1 - count2);

        ListNode longer = count1 > count2 ? headA : headB;
        ListNode shorter = count1 > count2 ? headB : headA;
        for (int i = 0; i < delta; i++) {
            longer = longer.next;
        }

        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }

        return longer;
    }

    public int count(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
}
