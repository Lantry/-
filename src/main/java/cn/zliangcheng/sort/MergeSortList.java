package cn.zliangcheng.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeSortList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode head : lists) {
            if (head != null) {
                minQueue.offer(head);
            }
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!minQueue.isEmpty()) {
            ListNode minVal = minQueue.poll();
            cur.next = minVal;
            if (minVal.next != null) {
                minQueue.offer(minVal.next);
            }

            cur = cur.next;
        }

        return dummy.next;
    }
}
