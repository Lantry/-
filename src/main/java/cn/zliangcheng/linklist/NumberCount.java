package cn.zliangcheng.linklist;

public class NumberCount {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverseL1 = reverseList(l1);
        ListNode reverseL2 = reverseList(l2);
        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode reverseRes = dummyHead;

        while (reverseL1 != null || reverseL2 != null) {
            int sum = (reverseL1 == null ? 0 : reverseL1.val) + (reverseL2 == null ? 0 : reverseL2.val) + carry;
            int value = sum % 10;
            carry = sum / 10;
            reverseRes.next = new ListNode(value);

            reverseL1 = reverseL1 != null ? reverseL1.next : null;
            reverseL2 = reverseL2 != null ? reverseL2.next : null;
            reverseRes = reverseRes.next;
        }

        if (carry > 0) {
            reverseRes.next = new ListNode(carry);
        }

        return reverseList(dummyHead.next);
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
