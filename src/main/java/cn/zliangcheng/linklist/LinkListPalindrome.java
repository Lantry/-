package cn.zliangcheng.linklist;

public class LinkListPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode endHalf = slow.next;

        if (fast.next != null) {
            endHalf = endHalf.next;
        }
        slow.next = null;

        return equalsLinkList(endHalf, reverseList(head));
    }

    private boolean equalsLinkList(ListNode endHalf, ListNode reverseStartHalf) {
        while (endHalf != null && reverseStartHalf != null) {
            if (endHalf.val != reverseStartHalf.val) {
                return false;
            }

            endHalf = endHalf.next;
            reverseStartHalf = reverseStartHalf.next;
        }

        return endHalf == null && reverseStartHalf == null;
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
