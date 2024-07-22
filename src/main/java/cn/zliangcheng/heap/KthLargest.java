package cn.zliangcheng.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {
    private final PriorityQueue<Integer> queue;
    private final int size;

    public KthLargest(int k, int[] nums) {
        this.size = k;
        queue = new PriorityQueue<>(Integer::compareTo);
        for (int num : nums) {
            queue.add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < size) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.offer(val);
            queue.poll();
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
    }
}
